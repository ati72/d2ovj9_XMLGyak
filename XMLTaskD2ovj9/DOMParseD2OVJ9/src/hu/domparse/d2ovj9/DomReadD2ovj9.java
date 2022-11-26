package hu.domparse.d2ovj9;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadD2ovj9 {
	
	public static void printRoot(Document doc) {
		//Gy�k�r ki�r�s
		System.out.println("Root: " + doc.getDocumentElement().getNodeName());
		System.out.println("===============================================");
	}
	
	public static int printOwners(Document doc, int elementCount) {
		//Tulajdonosok ki�r�sa
		NodeList nListTulaj = doc.getElementsByTagName("tulajdonos");
		for(int i = 0; i < nListTulaj.getLength(); i++) {
			Node nNode = nListTulaj.item(i);
			System.out.println(elementCount + ". Element: " + nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("ID");
				
				Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
				String fname = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("keresztnev").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("telefonszam").item(0);
				String phoneNumber = node3.getTextContent();
				
				Node node4 = elem.getElementsByTagName("email").item(0);
				String email = node4.getTextContent();
				
				System.out.println("ID: "+ uid);
				System.out.println("Vezet�kn�v: " + fname);
				System.out.println("Keresztn�v: " + lname);
				System.out.println("Telefonsz�m: " + phoneNumber);
				System.out.println("Email c�m: " + email);
				System.out.println("===============================================");
				elementCount++;
			}
		}
		return elementCount;
	}
	
	public static int printLabels(Document doc, int elementCount) {
		//Kiad�k ki�r�sa
		NodeList nListKiado = doc.getElementsByTagName("kiado");
		for(int i = 0; i < nListKiado.getLength(); i++) {
			Node nNode = nListKiado.item(i);
			System.out.println(elementCount + ". Element: " + nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("ID");
				String fkeyOwner = elem.getAttribute("tulaj_ID");
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String name = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("telephely").item(0);
				String location = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("email").item(0);
				String email = node3.getTextContent();
				
				System.out.println("ID: "+ uid);
				System.out.println("Tulajdonos ID: " + fkeyOwner);
				System.out.println("N�v: " + name);
				System.out.println("Telephely: " + location);
				System.out.println("Email c�m: " + email);
				System.out.println("===============================================");
				elementCount++;
			}
		}
		return elementCount;
	}
	
	public static int printBands(Document doc, int elementCount) {
		//Zenekarok ki�r�sa
		NodeList nListZenekar = doc.getElementsByTagName("zenekar");
		for(int i = 0; i < nListZenekar.getLength(); i++) {
			Node nNode = nListZenekar.item(i);
			System.out.println(elementCount + ". Element: " + nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("ID");
				String fkeyKiado = elem.getAttribute("kiado_ID");
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String name = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("alakult").item(0);
				String est = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("mufaj").item(0);
				String genre = node3.getTextContent();
				
				System.out.println("ID: "+ uid);
				System.out.println("Kiad� ID: " + fkeyKiado);
				System.out.println("N�v: " + name);
				System.out.println("Alakult: " + est);
				System.out.println("M�faj: " + genre);
				System.out.println("===============================================");
				elementCount++;
			}
		}
		return elementCount;
	}
	
	public static int printMusicians(Document doc, int elementCount) {
		//Zen�szek ki�r�sa
		NodeList nListZenesz = doc.getElementsByTagName("zenesz");
		for(int i = 0; i < nListZenesz.getLength(); i++) {
			Node nNode = nListZenesz.item(i);
			System.out.println(elementCount + ". Element: " + nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("ID");
				String fkeyZenekar = elem.getAttribute("zenekar_ID");
				
				Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
				String fname = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("keresztnev").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("szuletett").item(0);
				String born = node3.getTextContent();
				
				System.out.println("ID: "+ uid);
				System.out.println("Zenekar ID: " + fkeyZenekar);
				System.out.println("Vezet�kn�v: " + fname);
				System.out.println("Keresztn�v: " + lname);
				System.out.println("Sz�letett: " + born);
				System.out.println("===============================================");
				elementCount++;
			}
		}
		return elementCount;
	}
	
	public static int printInstruments(Document doc, int elementCount) {
		//Hangszerek ki�r�sa
		NodeList nListHangszer = doc.getElementsByTagName("hangszer");
		for(int i = 0; i < nListHangszer.getLength(); i++) {
			Node nNode = nListHangszer.item(i);
			System.out.println(elementCount + ". Element: " + nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("ID");
				
				Node node1 = elem.getElementsByTagName("gyarto").item(0);
				String manufacturer = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("tipus").item(0);
				String type = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("osztaly").item(0);
				String instrumentClass = node3.getTextContent();
				
				System.out.println("ID: "+ uid);
				System.out.println("Gy�rt�: " + manufacturer);
				System.out.println("T�pus: " + type);
				System.out.println("Oszt�ly: " + instrumentClass);
				System.out.println("===============================================");
				elementCount++;
			}
		}
		return elementCount;
	}
	
	public static int printInstrumentKnowledge(Document doc, int elementCount) {
		//Hangszerismeretek ki�r�sa
		NodeList nListHangszerismeret = doc.getElementsByTagName("hangszerismeret");
		for(int i = 0; i < nListHangszerismeret.getLength(); i++) {
			Node nNode = nListHangszerismeret.item(i);
			System.out.println(elementCount + ". Element: " + nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				String instrumentId = elem.getAttribute("hangszer_ID");
				String fkeyMusician = elem.getAttribute("zenesz_ID");
				
				Node node1 = elem.getElementsByTagName("ideje").item(0);
				String since = node1.getTextContent();
				
				System.out.println("Hangszer ID: "+ instrumentId);
				System.out.println("Zen�sz ID: " + fkeyMusician);
				System.out.println("Tapasztalat: " + since + " �v");
				System.out.println("===============================================");
				elementCount++;
			}
		}
		return elementCount;
	}
	
	public static void printXml(Document doc, int elementCount) {
		printRoot(doc);
		elementCount = printOwners(doc, elementCount);
		elementCount = printLabels(doc, elementCount);
		elementCount = printBands(doc, elementCount);
		elementCount = printMusicians(doc, elementCount);
		elementCount = printInstruments(doc, elementCount);	
		elementCount = printInstrumentKnowledge(doc, elementCount);
	}
	
	public static Document createDocument() throws ParserConfigurationException, SAXException, IOException {
		//F�jl beolvas�s
		File xmlData = new File("XMLD2ovj9.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.parse(xmlData);
		doc.getDocumentElement().normalize();

		return doc;
	}

	public static void main(String[] args) {
		
		try {
			
			Document doc = createDocument();
			int elementCount = 1;		
			printXml(doc, elementCount);	
			
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
}
