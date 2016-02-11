/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.api.PhysioManagerServerIF;
import edu.avans.ivh5.shared.util.Settings;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import org.apache.log4j.PropertyConfigurator;


public class PhysioServer {
    
    static private PhysioManagerClientIF stub;
//    static private PhysioManagerServerIF serverStub;
    
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
        
        try {
            String service = Settings.props.getProperty(Settings.propRmiServiceGroup) +
                            Settings.props.getProperty(Settings.propRmiServiceName);
            String hostname = Settings.props.getProperty(Settings.propRmiHostName);
            
            System.out.println(service);
            
            PhysioManagerImpl obj = new PhysioManagerImpl(service);
            stub = (PhysioManagerClientIF) UnicastRemoteObject.exportObject(obj, 0);
            
//            PhysioManagerServerImpl sObj = new PhysioManagerServerImpl();
//            serverStub = (PhysioManagerServerIF) UnicastRemoteObject.exportObject(sObj);
            
            Registry registry = LocateRegistry.getRegistry(hostname);
            
            registry.rebind(service, stub);
        } catch (java.rmi.ConnectException e) {
            System.out.println("Could not connect: " + e.getMessage());
        } catch (java.security.AccessControlException e) {
            System.out.println("No access: " + e.getMessage());
        } catch (RemoteException ex) {
            System.out.println("RemoteException in server" + ex.getMessage());
        }
    }
    
    public static String parseCommandLine(String[] args) {
        boolean errorFound = false;
        String propertiesfilename = null;
        
        if (args.length != 2) {
            System.out.println("Error reading options; expected 2 but found " + args.length + ".");
            errorFound = true;
        } else {
            if (args[0].equalsIgnoreCase("-properties")) {
                System.out.println("Propertiesfilename: " + args[1]);
                propertiesfilename = args[1];
            } else {
                errorFound = true;
            }
        }
        
        if (errorFound) {
            System.out.println("errorfound");
        }
        return propertiesfilename;
    }
    
    public static void exit(String service) throws RemoteException {
        try {
            Naming.unbind(service);
        } catch (NotBoundException ex) {
        } catch (MalformedURLException ex) {
        } catch (java.rmi.NoSuchObjectException ex) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("goodbye");
        }
    }
    
    public PhysioServer() {
        System.out.println("Constructor");
    }
    
    class ShutdownHook extends Thread {
        private String service;
        
        public ShutdownHook(String svc) { service = svc; }
        
        public void run() {
            try {
                PhysioServer.exit(service);
            } catch (RemoteException e) {
                System.out.println("Error exiting: could not contact remote server or registry.");
            }
        }
    }
}
