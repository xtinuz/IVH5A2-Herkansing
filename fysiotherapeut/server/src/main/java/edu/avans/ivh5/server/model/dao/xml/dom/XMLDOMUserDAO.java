/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.UserDAOIF;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author bernd_000
 */
public class XMLDOMUserDAO implements UserDAOIF {
    
    private XmlDOMDocument domDocument = null;
    private Document document = null;
    
    public XMLDOMUserDAO() {
        this.domDocument = new XmlDOMDocument("resources\\accounts.xml", "resources\\accounts.xsd");
        this.document = domDocument.getDocument();
    }

    @Override
    public boolean checkUserExistance(String username) {
        System.out.println("XMLDOMUserDAO is checking user existance");
        if (document != null) {
            NodeList list = document.getElementsByTagName("account");
            
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    String accountUsername = child.getElementsByTagName("username").item(0).getTextContent();
                    if (accountUsername.equals(username)) {
                        System.out.println("XMLDOMUserDAO found the username");
                        return true;
                    }
                }
            }
        } else {
            System.out.println("XMLDOMUserDAO could not check the user existance due to a missing document");
        }
        System.out.println("XMLDOMUserDAO did not find the username");
        return false;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        System.out.println("XMLDOMUserDAO is checking the users' password");
        if (document != null) {
            NodeList list = document.getElementsByTagName("account");
            
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    String accountUsername = child.getElementsByTagName("username").item(0).getTextContent();
                    if (accountUsername.equals(username)) {
                        String usersPassword = child.getElementsByTagName("hashedPassword").item(0).getTextContent();
                        return usersPassword.equals(password);
                    }
                }
            }
        } else {
            System.out.println("XMLDOMUserDAO could not check the password due to a missing document");
        }
        System.out.println("XMLDOMUserDAO found that the password was incorrect");
        return false;
    }

    @Override
    public byte[] getSalt(String username) {
        System.out.println("XMLDOMUserDAO is retrieving the users' salt");
        if (document != null) {
            NodeList list = document.getElementsByTagName("account");
            
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    String accountUsername = child.getElementsByTagName("username").item(0).getTextContent();
                    if (accountUsername.equals(username)) {
                        String salt = child.getElementsByTagName("salt").item(0).getTextContent();
                        System.out.println("XMLDOMUserDAO has found the users' salt");
                        return salt.getBytes();
                    }
                }
            }
        } else {
            System.out.println("XMLDOMUserDAO could not find the salt due to a missing document");
        }
        System.out.println("XMLDOMUserDAO did not find the salt");
        return null;
    }
    
}
