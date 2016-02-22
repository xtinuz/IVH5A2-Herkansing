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
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.models.*;
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
//        System.out.println("Scheduledata in DAO");
        Schedule schedule = null;
        int BSN = 0;
        
        if ((document != null) && (lastname != null)){
//            System.out.println("document not null and lastname not null");
            ArrayList scheduleItems = new ArrayList();
            NodeList treatmentslist = document.getElementsByTagName("treatment"); 
            for (int i = 0; i < treatmentslist.getLength(); i++) {                                                      // For every treatment
                Node node = treatmentslist.item(i);                                                                     // Make a node for the treatment
                 if (node instanceof Element) {                                                                         // Check if node is an Element
                    Element child = (Element) node;                                                                     // child = Treatment
                    if (child.getElementsByTagName("physiotherapist").item(0).getTextContent().equals(lastname)) {      // check the name
//                        System.out.println("lastname equals xml name : "  + lastname);
                        NodeList treatmentchildlist = child.getChildNodes();                                            // make a list from all nodes in treatment (including times and notes)
//                        System.out.println("treatmentchildlist " + treatmentchildlist.getLength());
                        for (int z = 0; z < treatmentchildlist.getLength(); z++){                                       // for every child the treatment has
                            Node treatmentchildnode = treatmentchildlist.item(z);                                       // create a node for it.
                            //Element treatmentchildElement = (Element) treatmentchildnode;
                            String nodeName = treatmentchildnode.getNodeName();                                         // get the nodename
                            if(nodeName == "BSN"){
                                Element bsnElement = (Element) treatmentchildnode;
                                BSN = Integer.parseInt( bsnElement.getTextContent() );
                            }
                            if(nodeName == "session"){                                                                  // if it is a session
                                Element sessionElement = (Element) treatmentchildnode;
                                String date = sessionElement.getElementsByTagName("date").item(0).getTextContent();
//                                System.out.println( "after if + " + date);
                                Iterator<String> datesIterator = dates.iterator();
                                while(datesIterator.hasNext()){
                                    String compare = datesIterator.next();
                                    if(date.equals(compare)){
//                                        System.out.println("match at " + compare);
                                        String starttime = sessionElement.getElementsByTagName("starttime").item(0).getTextContent();
                                        String endtime = sessionElement.getElementsByTagName("endtime").item(0).getTextContent();
                                        
                                        ScheduleItem scheduleItem = new ScheduleItem(date, starttime, endtime, lastname, BSN);
                                        scheduleItems.add(scheduleItem);
                                        
//                                        System.out.println("starttime = " + starttime);
//                                        System.out.println("bsn = " + BSN);
                                    }
                                    else {
//                                        System.out.println("no match at " + compare + "compare to " + date);
                                        
                                    }
                                }
                                
                                
                            }
                        }
                    }
                 }
            }
            schedule = new Schedule( lastname, scheduleItems);
        }
        
        
        else if (document != null){
            System.out.println("document not null, No lastname parameter");
            
        }
        
        else {
            System.out.println("Document is not found");
        }

        return schedule;
    }   
    
    @Override
    public boolean deleteTreatment(Treatment treatment){
        System.out.println("XMLDOMTreatmentAndSessionDAO is deleting the Treatment");
        if (document != null) {
                            System.out.println("In de for in DAO");

            NodeList list = document.getElementsByTagName("treatment");

            for (int i = 0; i < list.getLength(); i++) {
                System.out.println("In de for in DAO");
                
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("treatmentid").item(0).getTextContent().equals(treatment.getTreatmentID())) {
                    System.out.println("Te verwijderen treatment gevonden");
                        
                        child.getParentNode().removeChild(node);
                        System.out.println("verwijderd");

                        domDocument.writeDocument();

                        System.out.println("geschreven");
                        
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
    public boolean deleteTreatmentByTreatmentID(int treatmentID){
        System.out.println("XMLDOMTreatmentDAO is deleting the Treatment");
        if (document != null) {
            NodeList list = document.getElementsByTagName("treatmentid");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("treatmentid").item(0).getTextContent().equals(treatmentID)) {
                        System.out.println("Voor" + treatmentID);
                        child.getParentNode().removeChild(node);
                        System.out.println("Na" + treatmentID);
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
    public ArrayList<SharedTreatment> getAllFinishedTreatments(){
        System.out.println("XMLDOMTreatmentDAO is getAllFinishedTreatments");
        ArrayList<SharedTreatment> treatments = new ArrayList();
         if (document != null){
            System.out.println("document not null");
            NodeList treatmentslist = document.getElementsByTagName("treatment"); 
            //NodeList sessiondateslist = new NodeList();
            for (int i = 0; i < treatmentslist.getLength(); i++) {                                                      // For every treatment
                int sessions = 0;
                Node node = treatmentslist.item(i);                                                                     // Make a node for the treatment
                 if (node instanceof Element) {                                                                         // Check if node is an Element
                    Element child = (Element) node;                                                                     // child = Treatment
                    if (child.getElementsByTagName("status").item(0).getTextContent().equals("Afgerond")) {
                        child.getElementsByTagName("status").item(0).setTextContent("Gefactureerd");
                        NodeList treatmentchildlist = child.getChildNodes();                             
                        for (int z = 0; z < treatmentchildlist.getLength(); z++){                                       // for every child the treatment has
                            Node treatmentchildnode = treatmentchildlist.item(z);                                       // create a node for it.
                            if(treatmentchildnode.getNodeName() == "session"){                                                                  // if it is a session
                                sessions++;
                            }
                        }
                        treatments.add(new SharedTreatment(
                                child.getElementsByTagName("BSN").item(0).getTextContent(),
                                child.getElementsByTagName("treatmentcode").item(0).getTextContent(),
                                sessions
                        ));
                        // TODO: verander status naar "done" oid
                    }
                 }
            }
            domDocument.writeDocument();
        }
         return treatments;
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
    
    @Override
    public Treatment getTreatmentByTreatmentID(int treatmentID){
        System.out.println("XMLDOMTreatmentAndSession is getting the treatment");
        if (document != null) {
            NodeList list = document.getElementsByTagName("treatment"); // hier de naam van hetgene wat je zoekt
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("treatmentid").item(0).getTextContent().equalsIgnoreCase(String.valueOf(treatmentID))) {
                        //System.out.println("Gevonden Treatment:  " + child.getElementsByTagName("treatmentid").item(0).getTextContent());
                        return new Treatment(
                                Integer.parseInt(child.getElementsByTagName("treatmentid").item(0).getTextContent()),
                                child.getElementsByTagName("treatmentcode").item(0).getTextContent(),
                                child.getElementsByTagName("BSN").item(0).getTextContent(),
                                child.getElementsByTagName("physiotherapist").item(0).getTextContent(),
                                child.getElementsByTagName("status").item(0).getTextContent()
                        );
                    }
                }
            }
        } else {
            System.out.println("XMLDOMEmployeeDAO could not get the employee due to a missing document");
        }
        System.out.println("XMLDOMEmployeeDAO did not find the employee");
        return null;
    }
    
    @Override
    public ArrayList<Treatment> getTreatments(){
        System.out.println("XMLDOMTreatmentAndSessionDAO is getting all treatments");
        ArrayList<Treatment> treatments = new ArrayList<>();
        if (document != null) {
            NodeList list = document.getElementsByTagName("treatment");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    treatments.add(
                            new Treatment(
                                    Integer.parseInt( child.getElementsByTagName("treatmentid").item(0).getTextContent() ),
                                    child.getElementsByTagName("treatmentcode").item(0).getTextContent(),
                                    child.getElementsByTagName("BSN").item(0).getTextContent(),
                                    child.getElementsByTagName("physiotherapist").item(0).getTextContent(),
                                    child.getElementsByTagName("status").item(0).getTextContent()
                            )
                    );
                }
            }
            return treatments;
        }
        System.out.println("XMLDOMTreatmentAndSessionDAO did not find any treatments due to a missing document");
        return null;
        }
    
     @Override
        public boolean saveSession(Session session){
            System.out.println("XMLDOMTreatmentAndSessionDAO save ");
            String id = session.getTreatmentID();
            
        NodeList list = document.getElementsByTagName("treatment");
        for(int i = 0; i < list.getLength(); i++ ){
            Node node = list.item(i);   // Treatment
            NodeList treatmentChilds = node.getChildNodes();
            for(int y = 0; y < treatmentChilds.getLength(); y++){
                Node node2 = list.item(y);      // any child of treatment
                Element child = (Element) node;
                if( child.getElementsByTagName("treatmentID").item(0).getTextContent().equals("id")){
                    // find the node with name "sessions"
                    // if the sessions node does not exist yet
                    if(child.getElementsByTagName("sessions") == null ){
                         Element Sessions = document.createElement("sessions");
                         node.appendChild(Sessions);
                         Element Session = document.createElement("session");
                         Sessions.appendChild(Session);
                         Element Date = document.createElement("date");
                         Date.appendChild(document.createTextNode(session.getDate() ));
                         Session.appendChild( Date);
                    
                    Element StartTime = document.createElement("date");
                    StartTime.appendChild(document.createTextNode(session.getDate() ));
                    Session.appendChild( StartTime);
                    
                    Element EndTime = document.createElement("date");
                    EndTime.appendChild(document.createTextNode(session.getDate() ));
                    Session.appendChild( EndTime);
                         
                    }
                    //if it already exists
                    else{
                        Element sessionsElement = (Element) child.getElementsByTagName("sessions");
                                                 Element Session = document.createElement("session");
                         sessionsElement.appendChild(Session);
                         Element Date = document.createElement("date");
                         Date.appendChild(document.createTextNode(session.getDate() ));
                         Session.appendChild( Date);
                    
                    Element StartTime = document.createElement("date");
                    StartTime.appendChild(document.createTextNode(session.getDate() ));
                    Session.appendChild( StartTime);
                    
                    Element EndTime = document.createElement("date");
                    EndTime.appendChild(document.createTextNode(session.getDate() ));
                    Session.appendChild( EndTime);
                    }

                }
            }
            
            
        }
        

        domDocument.writeDocument();
            
            return true; // change later
        }
}
