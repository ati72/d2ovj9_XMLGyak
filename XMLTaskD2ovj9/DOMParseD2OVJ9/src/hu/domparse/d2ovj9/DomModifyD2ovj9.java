package hu.domparse.d2ovj9;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyD2ovj9 {
	
	public static Document createDocument() throws ParserConfigurationException, SAXException, IOException {
		//Fájl beolvasás
		File xmlData = new File("XMLD2ovj9_edit.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.parse(xmlData);
		doc.getDocumentElement().normalize();

		return doc;
	}
	
	public static void executeEdit(Document doc) throws TransformerException, TransformerConfigurationException {
		//XML átírás
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult newFile = new StreamResult(new File("modositott_xml.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, newFile);
	}
	
	public static void editOwnerName(Document doc) throws TransformerConfigurationException, TransformerException {
		//Tulaj vezetéknév átírás
		NodeList nodeList = doc.getElementsByTagName("tulajdonos");
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element element = (Element) nNode;
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				if(element.getAttribute("ID").equals("edit-me")) {
					Node fName = element.getElementsByTagName("vezeteknev").item(0);
					Node lName = element.getElementsByTagName("keresztnev").item(0);
					fName.setTextContent("Hegedus");
					lName.setTextContent("Attila");
				}
			}
		}
		doc.normalize();
	}
	
	public static void deleteOwner(Document doc) {
		//Tulaj törlése
		NodeList nodeList = doc.getElementsByTagName("tulajdonos");
		 for(int i = 0; i < nodeList.getLength(); i++) {
			 Node nNode = nodeList.item(i);
			 Element element = (Element) nNode;
			 if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				 if(element.getAttribute("ID").equals("delete-me")) {
					 element.getParentNode().removeChild(element);
				 }
			 }
		 }
	}
	
	public static void addOwner(Document doc) {
		//Tulaj hozzáadása
		Element root = doc.getDocumentElement();
		Element newOwner = doc.createElement("tulajdonos");
		newOwner.setAttribute("ID", "UJ-TULAJ");
		Element fName = doc.createElement("vezeteknev");
		fName.setTextContent("Miklós");
		Element lName = doc.createElement("keresztnev");
		lName.setTextContent("Béla");
		newOwner.appendChild(fName);
		newOwner.appendChild(lName);
		root.appendChild(newOwner);
	}
	
	public static void addBand(Document doc) {
		//Tulaj hozzáadása
		Element root = doc.getDocumentElement();
		Element newBand = doc.createElement("zenekar");
		newBand.setAttribute("ID", "UJ-ZENEKAR");
		newBand.setAttribute("kiado_ID", "kia-01");
		Element bName = doc.createElement("nev");
		bName.setTextContent("LGT");
		Element founded = doc.createElement("alakult");
		founded.setTextContent("1971");
		Element genre = doc.createElement("mufaj");
		genre.setTextContent("Rock");
		newBand.appendChild(bName);
		newBand.appendChild(founded);
		newBand.appendChild(genre);
		root.appendChild(newBand);
	}
	
	public static void addInstrument(Document doc) {
		//Tulaj hozzáadása
		Element root = doc.getDocumentElement();
		Element newInstrument = doc.createElement("hangszer");
		newInstrument.setAttribute("ID", "UJ-HANGSZER");
		Element bName = doc.createElement("gyarto");
		bName.setTextContent("Fender");
		Element type = doc.createElement("tipus");
		type.setTextContent("Telecaster");
		Element className = doc.createElement("osztaly");
		className.setTextContent("Rock");
		newInstrument.appendChild(bName);
		newInstrument.appendChild(type);
		newInstrument.appendChild(className);
		root.appendChild(newInstrument);
	}

	public static void main(String[] args) {
		
		try {
			
			Document doc = createDocument();
			editOwnerName(doc);
			deleteOwner(doc);
			addOwner(doc);
			addBand(doc);
			addInstrument(doc);
			executeEdit(doc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
}
