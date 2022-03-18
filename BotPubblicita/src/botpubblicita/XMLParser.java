/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import telegramapi.*;
/**
 *
 * @author dani2
 */
public class XMLParser {

    public XMLParser() {
    }

    public static ArrayList<Location> parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Element root, element;
        NodeList nodelist;

        Document document;

        factory = DocumentBuilderFactory.newDefaultInstance();
        builder = factory.newDocumentBuilder();

        document = builder.parse(filename);
        root = document.getDocumentElement();

        nodelist = root.getElementsByTagName("place");
        ArrayList<Location> lista = new ArrayList<Location>();

        for (int i = 0; i < nodelist.getLength(); i++) {
            lista.add(parseLocation(nodelist.item(i)));
        }
        return lista;
    }

    public static Location parseLocation(Node o) {
        return new Location(Double.parseDouble(((Element)o).getAttribute("lat")), Double.parseDouble(((Element)o).getAttribute("lon")));
    }
}
