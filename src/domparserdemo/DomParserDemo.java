package domparserdemo;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {

    public static void main(String[] args) {
        try {
            String dir = "James Wan";
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("film");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :"
                        + nNode.getNodeName() + (temp + 1));
                Element eElement = (Element) nNode;
                System.out.println("title : "
                        + eElement
                        .getElementsByTagName("title")
                        .item(0)
                        .getTextContent());
                System.out.println("year : "
                        + eElement
                        .getElementsByTagName("year")
                        .item(0)
                        .getTextContent());
                System.out.println("types : "
                        + eElement
                        .getElementsByTagName("types")
                        .item(0)
                        .getTextContent());
                System.out.println("time : "
                        + eElement
                        .getElementsByTagName("time")
                        .item(0)
                        .getTextContent());
                System.out.println("director : "
                        + eElement
                        .getElementsByTagName("director")
                        .item(0)
                        .getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
