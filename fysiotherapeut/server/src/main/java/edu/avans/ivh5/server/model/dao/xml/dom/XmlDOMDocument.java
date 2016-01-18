/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author bernd_000
 */
public class XmlDOMDocument {

    // The file that contains the XML data.
    private String xmlFilename;

    // The file that contains the schema to validate the data file.
    private String xmlSchema;

    // The document (structure) that will contain the object model of the XML file.
    private Document document = null;

    /**
     * Constructor
     */
    public XmlDOMDocument(String xmlFName, String xmlSchemaName) {

        // Read filenames from the previously installed properties; undefined otherwise.
        xmlFilename = xmlFName;
        xmlSchema = xmlSchemaName;
    }

    /**
     * Get the XML document that functions as the data source. We try to
     * validate it, if the given XSD file is available.
     *
     * @return The XML DOM document that holds objects representing the XML
     * elements in the file.
     */
    public Document getDocument() {

        if (document == null) {
            // First validate that the XML datasource conforms the schema.
            Schema schema = getValidationSchema();
            if (schema == null) {
//                JOptionPane.showMessageDialog(null, "Unable to log in due to a missing XSD file");
//                System.exit(0);
            } else {
                System.out.println("XmlDOMDocument is validating the xml file");
                validateDocument(xmlFilename, schema);
            }

            // Whether validated or not, try to build the
            // Document Object Model from the inputfile
            document = buildDocument(xmlFilename);
            if (document == null) {
                JOptionPane.showMessageDialog(null, "Unable to log in due to a missing XML file");
                System.exit(0);
            }
        }
        return document;
    }

    /**
     * Write the in-memory document object model to the given file. This is
     * useful when the document object model has been modified, for example by
     * adding or deleting members, books, reservations or loans.
     */
    public void writeDocument() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(xmlFilename));
            transformer.transform(source, result);

        } catch (TransformerConfigurationException e) {
        } catch (TransformerException e) {
        }
    }

    /**
     * Build a DOM document using the XML input filename.
     *
     * @param filename The file that provides the XML contents to create the
     * document object model.
     * @return The DOM document that was created, or null otherwise.
     */
    private Document buildDocument(String filename) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            File file = new File(filename);
            if (file.exists()) {
                document = builder.parse(new FileInputStream(file));
            } else {
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {

        }

        return document;
    }

    /**
     * Create the schema object that enables validation of the XML document.
     *
     * @return The schema which is created from the schema file, or null
     * otherwise.
     */
    private Schema getValidationSchema() {
        Schema schema = null;

        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            File xmlSchemaFile = new File(xmlSchema);
            if (xmlSchemaFile.exists()) {
                schema = factory.newSchema(xmlSchemaFile);
            } else {
            }
        } catch (Exception e) {
        }

        return schema;
    }

    /**
     * Perform the actual validation of the XML file using the provided schema.
     *
     * @param xmlFile	The file containing the XML data.
     * @param schema	The schema containing validation rules.
     */
    private boolean validateDocument(String xmlFile, Schema schema) {
        boolean result = false;

        try {
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            result = true;
        } catch (IOException | SAXException e) {
        }
        return result;
    }

}
