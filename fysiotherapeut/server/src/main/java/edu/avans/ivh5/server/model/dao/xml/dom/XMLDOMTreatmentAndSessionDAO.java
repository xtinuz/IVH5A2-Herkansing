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
import edu.avans.ivh5.shared.models.SharedTreatment;
import edu.avans.ivh5.shared.models.*;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
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

    //Schedule
    @Override
    public Schedule getScheduleTableData(ArrayList dates, String lastname) {
//        System.out.println("Scheduledata in DAO");
        Schedule schedule = null;
        int BSN = 0;

        if ((document != null) && (lastname != null)) {
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
                        for (int z = 0; z < treatmentchildlist.getLength(); z++) {                                       // for every child the treatment has
                            Node treatmentchildnode = treatmentchildlist.item(z);                                       // create a node for it.
                            //Element treatmentchildElement = (Element) treatmentchildnode;
                            String nodeName = treatmentchildnode.getNodeName();                                         // get the nodename
                            if (nodeName == "BSN") {
                                Element bsnElement = (Element) treatmentchildnode;
                                BSN = Integer.parseInt(bsnElement.getTextContent());
                            }
                            if (nodeName == "session") {                                                                  // if it is a session
                                Element sessionElement = (Element) treatmentchildnode;
                                String date = sessionElement.getElementsByTagName("date").item(0).getTextContent();
//                                System.out.println( "after if + " + date);
                                Iterator<String> datesIterator = dates.iterator();
                                while (datesIterator.hasNext()) {
                                    String compare = datesIterator.next();
                                    if (date.equals(compare)) {
//                                        System.out.println("match at " + compare);
                                        String starttime = sessionElement.getElementsByTagName("starttime").item(0).getTextContent();
                                        String endtime = sessionElement.getElementsByTagName("endtime").item(0).getTextContent();

                                        ScheduleItem scheduleItem = new ScheduleItem(date, starttime, endtime, lastname, BSN);
                                        scheduleItems.add(scheduleItem);

//                                        System.out.println("starttime = " + starttime);
//                                        System.out.println("bsn = " + BSN);
                                    } else {
//                                        System.out.println("no match at " + compare + "compare to " + date);

                                    }
                                }

                            }
                        }
                    }
                }
            }
            schedule = new Schedule(lastname, scheduleItems);
        } else if (document != null) {
            System.out.println("document not null, No lastname parameter");

        } else {
            System.out.println("Document is not found");
        }

        return schedule;
    }

    public ArrayList<Treatment> getTreatments() {
        System.out.println("XMLDOMTreatmentAndSessionDAO is getting all treatments");
        ArrayList<Treatment> treatments = new ArrayList<>();
        if (document != null) {
            NodeList list = document.getElementsByTagName("treatment");

            // for every treatment
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i); // = treatment
                if (node instanceof Element) {
                    Element child = (Element) node; // = treatment
                    treatments.add(
                            new Treatment(
                                    Integer.parseInt(child.getElementsByTagName("treatmentid").item(0).getTextContent()),
                                    child.getElementsByTagName("treatmentcode").item(0).getTextContent(),
                                    child.getElementsByTagName("BSN").item(0).getTextContent(),
                                    child.getElementsByTagName("physiotherapist").item(0).getTextContent(),
                                    child.getElementsByTagName("status").item(0).getTextContent()
                            )
                    );
                }
            }
        } else {
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
        }
        System.out.println("XMLDOMTreatmentAndSessionDAO returns arraylist treatments");
        return treatments;
    }

    @Override
    public boolean deleteTreatment(Treatment treatment) {
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
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
        }
        System.out.println("XMLDOMEmployeeDAO did not find the treatment");
        return false;
    }

    @Override
    public boolean deleteTreatmentByTreatmentID(int treatmentID) {
        System.out.println("XMLDOMTreatmentDAO is deleting the Treatment");
        if (document != null) {
            String id = "" + treatmentID;
            NodeList list = document.getElementsByTagName("treatment");

            for (int i = 0; i < list.getLength(); i++) { // For every treatment
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node; // child = treatment
                    if (child.getElementsByTagName("treatmentid").item(0).getTextContent().equals(id)) { // Treatment with the treatmentID found
                        child.getParentNode().removeChild(node);

                        domDocument.writeDocument();

                        return true;
                    }
                }
            }
        } else {
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
        }
        System.out.println("XMLDOMEmployeeDAO did not find the treatment");
        return false;
    }

    @Override
    public ArrayList<SharedTreatment> getAllFinishedTreatments() {
        System.out.println("XMLDOMTreatmentDAO is getAllFinishedTreatments");
        ArrayList<SharedTreatment> treatments = new ArrayList();
        if (document != null) {
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
                        for (int z = 0; z < treatmentchildlist.getLength(); z++) {                                       // for every child the treatment has
                            Node treatmentchildnode = treatmentchildlist.item(z);                                       // create a node for it.
                            if (treatmentchildnode.getNodeName() == "session") {                                                                  // if it is a session
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
        } else {
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
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
    public boolean saveTreatment(Treatment newTreatment) {
        System.out.println("XMLDOMTreatmentAndSessionDAO saveTreatment ");
        boolean saveSuccess = false;
        if (document != null) {
            // Found document
            // find root element treatments
            Node rootElement = document.getElementsByTagName("treatments").item(0);
            // make new empty treatment and add it to treatments
            Element treatment = document.createElement("treatment");
            rootElement.appendChild(treatment);

            // add data
            Element TreatmentID = document.createElement("treatmentid");
            TreatmentID.appendChild(document.createTextNode(Integer.toString(getMaxID())));
            treatment.appendChild(TreatmentID);

            Element TreatmentCode = document.createElement("treatmentcode");
            TreatmentCode.appendChild(document.createTextNode(newTreatment.getTreatmentCode()));
            treatment.appendChild(TreatmentCode);

            Element BSN = document.createElement("BSN");
            BSN.appendChild(document.createTextNode(newTreatment.getBSN()));
            treatment.appendChild(BSN);

            Element PhysioTherapistLastName = document.createElement("physiotherapist");
            PhysioTherapistLastName.appendChild(document.createTextNode(newTreatment.getPhysioTherapistLastName()));
            treatment.appendChild(PhysioTherapistLastName);

            Element status = document.createElement("status");
            status.appendChild(document.createTextNode(newTreatment.getStatus()));
            treatment.appendChild(status);

            domDocument.writeDocument();
            saveSuccess = true;
        } else {
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
        }

        System.out.println("end save treatment in DAO");
        return saveSuccess;
    }

    @Override
    public Treatment getTreatmentByTreatmentID(int treatmentID) {
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
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
        }
        System.out.println("XMLDOMEmployeeDAO did not find the employee");
        return null;
    }

//    @Override
//    public ArrayList<Treatment> getTreatments(){
//        System.out.println("XMLDOMTreatmentAndSessionDAO is getting all treatments");
//        ArrayList<Treatment> treatments = new ArrayList<>();
//        if (document != null) {
//            NodeList list = document.getElementsByTagName("treatment");
//
//            for (int i = 0; i < list.getLength(); i++) {
//                Node node = list.item(i);
//                if (node instanceof Element) {
//                    Element child = (Element) node;
//                    treatments.add(
//                            new Treatment(
//                                    Integer.parseInt( child.getElementsByTagName("treatmentid").item(0).getTextContent() ),
//                                    child.getElementsByTagName("treatmentcode").item(0).getTextContent(),
//                                    child.getElementsByTagName("BSN").item(0).getTextContent(),
//                                    child.getElementsByTagName("physiotherapist").item(0).getTextContent(),
//                                    child.getElementsByTagName("status").item(0).getTextContent()
//                            )
//                    );
//                }
//            }
//            return treatments;
//        }
//        System.out.println("XMLDOMTreatmentAndSessionDAO did not find any treatments due to a missing document");
//        return null;
//        }
    @Override
    public boolean saveSession(Session session) {
        System.out.println("XMLDOMTreatmentAndSessionDAO savesession ");
        String id = session.getTreatmentID();
        System.out.println("id in the dao = " + id);
        boolean saveSuccess = false;

        NodeList list = document.getElementsByTagName("treatment");

        System.out.println("amount of treatments = " + list.getLength());
        for (int i = 0; i < list.getLength(); i++) { //for every treatment
            Node node = list.item(i);
            Element treatmentElement = (Element) node; // make an element of treatment

            System.out.println("try if id matches " + id);
            if (treatmentElement.getElementsByTagName("treatmentid").item(0).getTextContent().equals(id)) {

                System.out.println("found treatment with matching id");
                // find the node with name "sessions"
                // if the sessions node does not exist yet
                if (treatmentElement.getElementsByTagName("sessions").getLength() == 0) {
                    System.out.println("new sessions element");

                    Element Sessions = document.createElement("sessions");
                    node.appendChild(Sessions);
                    Element Session = document.createElement("session");
                    Sessions.appendChild(Session);
                    Element Date = document.createElement("date");
                    Date.appendChild(document.createTextNode(session.getDate()));
                    Session.appendChild(Date);

                    Element StartTime = document.createElement("starttime");
                    StartTime.appendChild(document.createTextNode(session.getStartTime()));
                    Session.appendChild(StartTime);

                    Element EndTime = document.createElement("endtime");
                    EndTime.appendChild(document.createTextNode(session.getEndTime()));
                    Session.appendChild(EndTime);

                    saveSuccess = true;

                } //if it already exists
                else {
                    System.out.println("add to already existing sessions element");

                    Element sessionsElement = (Element) treatmentElement.getElementsByTagName("sessions").item(0);
                    System.out.println("cast succesful");
                    Element Session = document.createElement("session");
                    sessionsElement.appendChild(Session);

                    System.out.println("sessionsdata");

                    Element Date = document.createElement("date");
                    Date.appendChild(document.createTextNode(session.getDate()));
                    Session.appendChild(Date);

                    System.out.println("datedata");

                    Element StartTime = document.createElement("starttime");
                    StartTime.appendChild(document.createTextNode(session.getStartTime()));
                    Session.appendChild(StartTime);

                    System.out.println("");

                    Element EndTime = document.createElement("endtime");
                    EndTime.appendChild(document.createTextNode(session.getEndTime()));
                    Session.appendChild(EndTime);

                    System.out.println("values added");

                    saveSuccess = true;
                }
            } else {
                System.out.println("no match");
            }

            //}   
        }
        System.out.println("write document ");
        domDocument.writeDocument();
        return saveSuccess;
    }

    @Override
    public ArrayList getSessionsByTreatmentID(int treatmentID) {
        System.out.println("XMLDOMTreatmentAndSession is getting the sessions by treatmentID " + treatmentID);
        ArrayList<Session> sessions = new ArrayList<Session>();
        if (document != null) {
            //System.out.println("Found document");
            NodeList list = document.getElementsByTagName("session");
            for (int i = 0; i < list.getLength(); i++) { // for every session; not the best way if xml is huge, but for this project sufficient.
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if (child.getElementsByTagName("treatmentid").item(0).getTextContent().equalsIgnoreCase(String.valueOf(treatmentID))) {
                        System.out.println("test");
                        Session s = new Session(
                                child.getElementsByTagName("date").item(0).getTextContent(),
                                child.getElementsByTagName("starttime").item(0).getTextContent(),
                                child.getElementsByTagName("endtime").item(0).getTextContent(),
                                child.getElementsByTagName("notes").item(0).getTextContent(),
                                child.getElementsByTagName("treatmentid").item(0).getTextContent());
                        sessions.add(s);
                    }
                }
            }

        } else {
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
        }
        return sessions;
    }

    @Override
    public ArrayList getAllSessionsByDate(String firstDate, String secondDate) {
                System.out.println("XMLDOMTreatmentAndSession is getting the sessions by date" + firstDate + "till" + secondDate);
        ArrayList<Session> sessionsByDate = new ArrayList<>();
        if (document != null) {
            NodeList list = document.getElementsByTagName("session");
            for (int i = 0; i < list.getLength(); i++) { // for every session; not the best way if xml is huge, but for this project sufficient.
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    if(Integer.parseInt(child.getElementsByTagName("date").item(0).getTextContent()) >= Integer.parseInt(firstDate) && Integer.parseInt(child.getElementsByTagName("date").item(0).getTextContent()) <= Integer.parseInt(secondDate) )
                    //if (child.getElementsByTagName("date").item(0).getTextContent().equalsIgnoreCase(String.valueOf(firstDate))){
                        System.out.println("test");
                        Session s = new Session(
                                child.getElementsByTagName("date").item(0).getTextContent(),
                                child.getElementsByTagName("starttime").item(0).getTextContent(),
                                child.getElementsByTagName("endtime").item(0).getTextContent(),
                                child.getElementsByTagName("notes").item(0).getTextContent(),
                                child.getElementsByTagName("treatmentid").item(0).getTextContent());
                        sessionsByDate.add(s);
                    }
                }
        } else {
            System.out.println("XMLDOMTreatment&SessionDAO could not find the document");
        }
        return sessionsByDate;
    }


}
