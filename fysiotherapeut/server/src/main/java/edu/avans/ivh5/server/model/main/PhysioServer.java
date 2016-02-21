/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.api.PhysioManagerServerIF;
import edu.avans.ivh5.shared.api.ClientInterface;
import edu.avans.ivh5.shared.rmi.InsuranceServerInterface;
import edu.avans.ivh5.shared.rmi.PhysioServerInterface;
import edu.avans.ivh5.shared.util.Settings;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import org.apache.log4j.PropertyConfigurator;


public class PhysioServer {
    
    static private PhysioManagerClientIF stub;
    static private InsuranceServerInterface insuranceServerInterface;
    private static final boolean RMI = true;
//    static private PhysioManagerServerIF serverStub;
    
    public static void main(String[] args) {
        System.setProperty("sun.rmi.transport.tcp.readTimeout", "100000");
        System.setProperty("sun.rmi.transport.connectionTimeout", "100000");
        System.setProperty("sun.rmi.transport.tcp.responseTimeout", "100000");
        
        if (args.length == 2) {
            String propertiesfile = parseCommandLine(args);
            System.setProperty("java.security.policy", "file://C:/xampp/htdocs/classes/resources/breda.policy");
        } else {
            System.out.println("No properties file was found. Provide a properties file name.");
            System.out.println("Program is exiting");
            return;
        }
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
//        PropertyConfigurator.configure(Settings.props.getProperty(Settings.propLogConfigFile));
        
        try {
            //URL whatismyip = new URL("http://checkip.amazonaws.com");
            //BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            //String ip = in.readLine();
            //System.setProperty("java.rmi.server.hostname", ip);
            
            String service = "Library/Breda";
            String otherService = "/other";
            String hostname = "localhost";
            
            PhysioManagerImpl obj = new PhysioManagerImpl(service);
            
            stub = (PhysioManagerClientIF) UnicastRemoteObject.exportObject(obj, 0);
            PhysioServerInterface physioImpl = (PhysioServerInterface)UnicastRemoteObject.exportObject(new InsuranceServerImpl(), 0);
//            PhysioManagerServerImpl sObj = new PhysioManagerServerImpl();
//            serverStub = (PhysioManagerServerIF) UnicastRemoteObject.exportObject(sObj);
            
            Registry registry = LocateRegistry.getRegistry(hostname);
            
            registry.rebind(service, stub);
            registry.rebind(otherService, physioImpl);
        } catch (java.rmi.ConnectException e) {
            System.out.println("Could not connect: " + e.getMessage());
        } catch (java.security.AccessControlException e) {
            System.out.println("No access: " + e.getMessage());
        } catch (RemoteException ex) {
            System.out.println("RemoteException in server" + ex.getMessage());
        } catch(Exception e)
        {
            System.out.println("Other exception: " + e.getMessage());
        }
        
        if(RMI)
        {
            while(true) {
                try {
                String hostname = "192.168.178.28";
                String service = "/other";
                //String service = "/standard";
                Registry registry = LocateRegistry.getRegistry(hostname);

                insuranceServerInterface = (InsuranceServerInterface)registry.lookup(service);
                //ClientInterface clientIf = (ClientInterface)registry.lookup(service);
                if(insuranceServerInterface == null)
                    throw new Exception(); 
                //System.out.println("Insurance Company: " + clientIf.getInsuranceCompany().getName());
                System.out.println("Clientname: " + insuranceServerInterface.getClient("Burak").getName());
                System.out.println("Done");
                break;
                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    try{
                        Thread.sleep(3000);
                    }
                    catch(Exception ex)
                    {
                        
                    }
                }
            }
        }
    }
    
    public static InsuranceServerInterface getInsuranceServerInterface(){
        return insuranceServerInterface;
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
