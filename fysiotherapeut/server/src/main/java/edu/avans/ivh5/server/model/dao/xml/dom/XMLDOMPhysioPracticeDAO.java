/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.PhysioPracticeDAOIF;
import edu.avans.ivh5.shared.model.domain.PhysioPractice;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;


public class XMLDOMPhysioPracticeDAO implements PhysioPracticeDAOIF{
    private XmlDOMDocument domDocument;
    private Document document;
    private DateFormat format;
    private Format formatter;
    
    
    public XMLDOMPhysioPracticeDAO(){
        this.format = new SimpleDateFormat("yyyy-MM-dd");
        this.formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.domDocument = new XmlDOMDocument("resources\\physiopractice.xml", "resources\\physiopractice.xsd");
        this.document = domDocument.getDocument();
    }

    @Override
    public boolean savePhysioPractice(PhysioPractice physiopractice) {
        System.out.println("XMLDOAPysioPracticeDAO is getting the obj:PhysioPractice");
        if (document != null) {

                    Node practice = document.getElementsByTagName("physiopractice").item(0);
                    Element child = (Element) practice;
                    
                    child.getElementsByTagName("name").item(0).setTextContent(physiopractice.getName());
                    child.getElementsByTagName("address").item(0).setTextContent(physiopractice.getAddress());
                    child.getElementsByTagName("postal").item(0).setTextContent(physiopractice.getPostal());
                    child.getElementsByTagName("phone").item(0).setTextContent(physiopractice.getPhone());
                    child.getElementsByTagName("email").item(0).setTextContent(physiopractice.getEmail());
                    child.getElementsByTagName("kvk").item(0).setTextContent(physiopractice.getKVK());
                    child.getElementsByTagName("iban").item(0).setTextContent(physiopractice.getIBAN());
                    child.getElementsByTagName("bic").item(0).setTextContent(physiopractice.getBIC());
                    child.getElementsByTagName("bank").item(0).setTextContent(physiopractice.getBank());
                    
                    this.domDocument.writeDocument();
                    return true;
        } else {
            System.out.println("XMLDOAPysioPracticeDAO could not get the PhysioPractice due to a missing document");
        }
        System.out.println("XMLDOAPysioPracticeDAO did not find the PhysioPractice");
        return false;
    }
    
    @Override
    public PhysioPractice getCompanyInfo() {
        System.out.println("XMLDOAPysioPracticeDAO is getting the obj:PhysioPractice");
        if (document != null) {
            System.out.println("XMLDOAPysioPracticeDAO has found the document");
                    
                    Node practice = document.getElementsByTagName("physiopractice").item(0);
                    Element child = (Element) practice;
                    
                    System.out.println("test");
                    
                    String name = child.getElementsByTagName("name").item(0).getTextContent();
                    String address = child.getElementsByTagName("address").item(0).getTextContent();
                    String postal = child.getElementsByTagName("postal").item(0).getTextContent();
                    String city = child.getElementsByTagName("city").item(0).getTextContent();
                    String phone = child.getElementsByTagName("phone").item(0).getTextContent();
                    String email = child.getElementsByTagName("email").item(0).getTextContent();
                    String KVK = child.getElementsByTagName("kvk").item(0).getTextContent();
                    String IBAN = child.getElementsByTagName("iban").item(0).getTextContent();
                    String BIC = child.getElementsByTagName("bic").item(0).getTextContent();
                    String bank = child.getElementsByTagName("bank").item(0).getTextContent();
                    System.out.println("XMLDOAPysioPracticeDAO has updated the variables");                    
                    return new PhysioPractice(name, address, postal, city, phone, email, KVK, IBAN, BIC, bank);
        } else {
            System.out.println("XMLDOMUserDAO could not get the PhysioPractice due to a missing document");
        }
        System.out.println("XMLDOMUserDAO did not find the PhysioPractice");
        return null;
    }
}