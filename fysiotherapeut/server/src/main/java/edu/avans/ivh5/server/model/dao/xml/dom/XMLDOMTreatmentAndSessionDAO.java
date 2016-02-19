/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.TreatmentAndSessionDAOIF;
import edu.avans.ivh5.server.model.dao.api.TreatmentDAOIF;
import edu.avans.ivh5.shared.model.domain.Schedule;
import edu.avans.ivh5.shared.model.domain.ScheduleItem;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLDOMTreatmentAndSessionDAO implements TreatmentAndSessionDAOIF {
    private XmlDOMDocument domDocument = null;
    private Document document = null;
    private XmlDOMDocument domDocument2 = null;
    private Document document2 = null;

    public XMLDOMTreatmentAndSessionDAO() {
        this.domDocument = new XmlDOMDocument("resources\\TreatmentAndSession.xml", "resources\\TreatmentAndSession.xsd");
        this.document = domDocument.getDocument();
        this.domDocument2 = new XmlDOMDocument("resources\\treatmenttype.xml", "resources\\treatmenttype.xsd");
        this.document2 = domDocument2.getDocument();
    }
    
    private void getDocument() {
        this.domDocument = new XmlDOMDocument("resources\\TreatmentAndSession.xml", "resources\\TreatmentAndSession.xsd");
        this.document = domDocument.getDocument();
        this.domDocument2 = new XmlDOMDocument("resources\\treatmenttype.xml", "resources\\treatmenttype.xsd");
        this.document2 = domDocument2.getDocument();
    }

   
    @Override
    public Schedule getScheduleTableData( ArrayList dates, String lastname) {
         System.out.println("Scheduledata in DAO");
        Schedule schedule = null;
        
        if ((document != null) && (lastname != null)){
            System.out.println("document not null");
            NodeList treatmentslist = document.getElementsByTagName("treatment"); 
            //NodeList sessiondateslist = new NodeList();
            for (int i = 0; i < treatmentslist.getLength(); i++) {                                                      // For every treatment
                Node node = treatmentslist.item(i);                                                                     // Make a node for the treatment
                 if (node instanceof Element) {                                                                         // Check if node is an Element
                    Element child = (Element) node;                                                                     // child = Treatment
                    if (child.getElementsByTagName("physiotherapist").item(0).getTextContent().equals(lastname)) {      // check the name
                        System.out.println("lastname equals xml name : "  + lastname);
                        NodeList treatmentchildlist = child.getChildNodes();                                            // make a list from all nodes in treatment (including times and notes)
                        System.out.println("treatmentchildlist " + treatmentchildlist.getLength());
                        for (int z = 0; z < treatmentchildlist.getLength(); z++){                                       // for every child the treatment has
                            Node treatmentchildnode = treatmentchildlist.item(z);                                       // create a node for it.
                            String nodeName = treatmentchildnode.getNodeName();                                         // get the nodename
                            if(nodeName == "session"){                                                                  // if it is a session
                                Element testelement = (Element) treatmentchildnode;
                                String date = testelement.getElementsByTagName("date").item(0).getTextContent();
                                System.out.println( "after if + " + date);
                                
                                
                            }
                        }
                    }
                 }
            }
        }
        return schedule;
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
    @Override
    public int getMaxID() {
        System.out.println("XMLDOMTreatmentandSessionDAO is getting the max id");
        if (document != null) {
            NodeList list = document.getElementsByTagName("treatment");
            return list.getLength();
        } else {
            System.out.println("XMLDOMtreatmentandsessionDAO did not find the max id due to a missing document");
            return 0;
        }
    }
    
    @Override
    public boolean saveTreatment(Treatment newTreatment)
    {
        System.out.println("XMLDOMTreatmentDAO save ");

        // vind root element treatments
        Node rootElement = document.getElementsByTagName("treatment").item(0);
        // maak nieuwe lege treatment en voeg deze toe aan treatments
        Element treatments = document.createElement("treatment");
        rootElement.appendChild(treatments);

        // voeg data toe
        Element TreatmentID = document.createElement("treatmentid");
        TreatmentID.appendChild(document.createTextNode(Integer.toString(getMaxID() + 1)));
        treatments.appendChild(TreatmentID);

        Element TreatmentCode = document.createElement("treatmentcode");
        TreatmentCode.appendChild(document.createTextNode(newTreatment.getTreatmentCode()));
        treatments.appendChild(TreatmentCode);

        Element BSN = document.createElement("BSN");
        BSN.appendChild(document.createTextNode(newTreatment.getBSN()));
        treatments.appendChild(BSN);

        Element PhysioTherapistLastName = document.createElement("physiotherapist");
        PhysioTherapistLastName.appendChild(document.createTextNode(newTreatment.getPhysioTherapistLastName()));
        treatments.appendChild(PhysioTherapistLastName);
        
        Element status = document.createElement("status");
        status.appendChild(document.createTextNode(newTreatment.getStatus()));
        treatments.appendChild(status);

        domDocument.writeDocument();
        return true;
    }
}