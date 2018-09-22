package edu.bsu.cs222;

import org.w3c.dom.*; //.Nodelist
import org.w3c.dom.Document; //Added

import org.xml.sax.SAXException;

import javax.swing.text.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Revision> parse(InputStream input) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;

        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IOException(e);
        }

        Document document = documentBuilder.parse(input);
        NodeList nodeList = ((org.w3c.dom.Document) document).getElementsByTagName("rev");
        List<Revision> result = new ArrayList<>();
        for (int i = 0; i<nodeList.getLength();i++){
            result.add(new Revision());
        }
        return result;
    }
}
