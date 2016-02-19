/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.SessionDAOIF;
import org.w3c.dom.Document;


public class XMLDOMSessionDAO implements SessionDAOIF {

    private XmlDOMDocument domDocument = null;
    private Document document = null;

    public XMLDOMSessionDAO() {
        this.domDocument = new XmlDOMDocument("resources\\employees.xml", "resources\\employees.xsd");
        this.document = domDocument.getDocument();
    }
    
    private void getDocument() {
        this.domDocument = new XmlDOMDocument("resources\\employees.xml", "resources\\employees.xsd");
        this.document = domDocument.getDocument();
    }
    
}
