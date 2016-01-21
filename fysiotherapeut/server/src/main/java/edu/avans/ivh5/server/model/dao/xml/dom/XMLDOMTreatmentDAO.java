/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.rmi.RemoteException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author bernd_000
 */
public class XMLDOMTreatmentDAO implements TreatmentDAOIF {
    private XmlDOMDocument domDocument = null;
    private Document document = null;

    public XMLDOMTreatmentDAO() {
        this.domDocument = new XmlDOMDocument("resources\\TreatmentAndSession.xml", "resources\\TreatmentAndSession.xsd");
        this.document = domDocument.getDocument();
    }
    
    private void getDocument() {
        this.domDocument = new XmlDOMDocument("resources\\TreatmentAndSession.xml", "resources\\TreatmentAndSession.xsd");
        this.document = domDocument.getDocument();
    }

    @Override
    public void getSceduleTableData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean deleteTreatment(Treatment treatment) throws RemoteException{
        System.out.println("XMLDOMTreatmentDAO is deleting the Treatment");
        if (document != null) {
            NodeList list = document.getElementsByTagName("treatmentid");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("treatmentid").item(0).getTextContent().equals(treatment.getTreatmentID())) {
                        child.getParentNode().removeChild(node);
                        domDocument.writeDocument();

                        return true;
                    }
                }
            }
        } else {
            System.out.println("XMLDOMEmployeeDAO could not get the treatment due to a missing document");
        }
        System.out.println("XMLDOMEmployeeDAO did not find the treatment");
        return false;
    }
    
    @Override
    public boolean deleteTreatmentByTreatmentID(int treatmentID) throws RemoteException{
        System.out.println("XMLDOMTreatmentDAO is deleting the Treatment");
        if (document != null) {
            NodeList list = document.getElementsByTagName("treatmentid");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("treatmentid").item(0).getTextContent().equals(treatmentID)) {
                        child.getParentNode().removeChild(node);
                        domDocument.writeDocument();

                        return true;
                    }
                }
            }
        } else {
            System.out.println("XMLDOMEmployeeDAO could not get the treatment due to a missing document");
        }
        System.out.println("XMLDOMEmployeeDAO did not find the treatment");
        return false;
    }
}