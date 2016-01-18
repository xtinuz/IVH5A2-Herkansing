/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.rmi;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Handles the connection to a remote service via Java Remote Method Invocation
 * (RMI).
 *
 * @author Robin Schellius
 */
public class RmiConnection {

    // 
    static Object remoteService = null;

    // The name of the host to connect to
    public static String hostname = null;
    // The name of the service to connect to
    public static String servicename = null;

    // A list of available registries, possibly on other remote hosts.
    private static HashMap<String, Registry> registries = new HashMap<String, Registry>();

    // The list of services that we can connect to
    private static ArrayList<String> availableServices = null;

    /**
     * Method to get and return a reference to the RMI registry on the given
     * server.
     *
     * @param hostname
     * @return
     */
    public static Registry getRegistry(String hostname) {

        try {
            // Check if we have previously found the requested registry
            if (registries.containsKey(hostname) && (registries.get(hostname) != null)) {
            } else {
                Registry registry = LocateRegistry.getRegistry(hostname);
                registries.put(hostname, registry);
            }
        } catch (RemoteException e) {
        } catch (java.security.AccessControlException e) {
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return registries.get(hostname);
    }

    /**
     * Find all available services that can be contacted from this service. This
     * includes all services that are listed in the RMI registry on the host
     * that this service is running on, and could include more remote registries
     * and services if available.
     *
     * @return
     */
    public static ArrayList<String> findAvailableServices(String hostname, String serviceGroup) {

        // Make sure we start with a fresh list.
        availableServices = null;
        String[] listOfServices = null;
        Registry registry;

        try {
            registry = LocateRegistry.getRegistry(hostname);
            listOfServices = registry.list();

            if (listOfServices != null) {
                availableServices = new ArrayList<String>();
                for (String servicename : listOfServices) {
                    // Return only services that share the given service group name
                    if (servicename.startsWith(serviceGroup)) {
                        availableServices.add(servicename);
                    }
                }
            }
        } catch (AccessException e) {
        } catch (RemoteException e) {
        }

        return availableServices;
    }

    /**
     * Internal class to get a service using a separate thread.
     *
     * @author Robin Schellius
     */
    public static class getService implements Runnable {

        private String hostname;
        private String service;

        /**
         * Creates a RMI connection to the given service on the given hostname.
         *
         * @param host Hostname or IP-address of remote server.
         * @param service The name of the service as it is registered in the
         * registry.
         */
        public getService(String host, String svc) {
            hostname = host;
            service = svc;
        }

        /**
         * The thread's main method that runs and does the work.
         */
        public void run() {

            try {
                Registry registry = getRegistry(hostname);
                remoteService = (Object) registry.lookup(service);
            } catch (java.security.AccessControlException e) {
            } catch (java.rmi.NotBoundException e) {
            } catch (Exception e) {
            }
        }
    }

    /**
     * Threaded class to get a list of services from a given host.
     *
     * @author Robin Schellius
     */
    public static class listServices implements Runnable {

        private static String hostname;

        /**
         * Constructor
         *
         * @param host
         */
        public listServices(String host) {
            hostname = host;
        }

        /**
         * The thread's main method that runs and does the work.
         */
        public void run() {
            try {
                String[] list = getRegistry(hostname).list();

                if (list != null) {
                }
            } catch (RemoteException e) {
            }
        }
    }
}
