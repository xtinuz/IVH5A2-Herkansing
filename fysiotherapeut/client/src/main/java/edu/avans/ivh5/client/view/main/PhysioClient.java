/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.main;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.control.LoginController;
import edu.avans.ivh5.client.view.ui.LoginScreen;
import edu.avans.ivh5.shared.util.Settings;
import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author bernd_000
 */
public class PhysioClient {

    public static void main(String[] args) {
        if (args.length == 2) {
            String propertiesfile = parseCommandLine(args);
            Settings.loadProperties(propertiesfile);
        } else {
            System.out.println("No properties file was found. Provide a properties file name.");
            System.out.println("Program is exiting");
            return;
        }
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        PropertyConfigurator.configure(Settings.props.getProperty(Settings.propLogConfigFile));
        
        String hostname = System.getProperty(Settings.propRmiHostName);

        
        new PhysioClient(hostname);
    }

    public PhysioClient(String hostname) {
        System.out.println("Constructor using " + hostname);
        
        String service = Settings.props.getProperty(Settings.propRmiServiceGroup) +
                        Settings.props.getProperty(Settings.propRmiServiceName);
        
        PhysioManagerClientIF manager = null;
        
        try {
            System.out.println("Locate registry on " + hostname);
            Registry registry = LocateRegistry.getRegistry(hostname);
            System.out.println("Found registry");
            System.out.println("Connecting to remote service" + service);
            manager = (PhysioManagerClientIF) registry.lookup(service);
            System.out.println("Connected");
        } catch (RemoteException e) {
            System.out.println("Could not access registry: " + e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("RemoteException: " + e.getMessage());
        } catch (java.security.AccessControlException e) {
            System.out.println("Service not found: " + e.getMessage());
        }
        
        final LoginController controller = new LoginController(manager);
        
        EventQueue.invokeLater(() -> {
            new LoginScreen(controller);
        });
    }
    
    private static String parseCommandLine(String[] args) {
        boolean errorFound = false;
        String propertiesfilename = null;
        
        if (args.length != 2) {
            System.out.println("Error reading options; expected 2 but found"
                                + args.length + ".");
            errorFound = true;
        } else {
            if (args[0].equalsIgnoreCase("-properties")) {
                System.out.println("properties file: " + args[1]);
                propertiesfilename = args[1];
            } else {
                errorFound = true;
            }
        }
        
        if (errorFound) {
            System.out.println("Error reading command line parameters.");
            System.out.println("Usage: -properties [filename or URL]");
            System.out.println("       -properties client.properties");
            System.exit(0);
        }
        return propertiesfilename;
    }
}
