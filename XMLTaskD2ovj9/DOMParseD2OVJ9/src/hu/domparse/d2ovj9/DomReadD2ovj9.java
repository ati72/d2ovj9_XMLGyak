package hu.domparse.d2ovj9;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReadD2ovj9 {

	public static void main(String[] args) {
		
		try {
			//Fájl beolvasás
			File xmlData = new File("XMLD2ovj9.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(xmlData);
			doc.getDocumentElement().normalize();
			int elementCount = 1;
			
			//Gyökér kiírás
			System.out.println("Root: " + doc.getDocumentElement().getNodeName());
			System.out.println("===============================================");
			
			//Tulajdonosok kiírása
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
					System.out.println("Vezetéknév: " + fname);
					System.out.println("Keresztnév: " + lname);
					System.out.println("Telefonszám: " + phoneNumber);
					System.out.println("Email cím: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Kiadók kiírása
			NodeList nListKiado = doc.getElementsByTagName("kiado");
			for(int i = 0; i < nListKiado.getLength(); i++) {
				Node nNode = nListKiado.item(i);
				System.out.println(elementCount + ". Element: " + nNode.getNodeName());
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("ID");
					String fkeyOwner = elem.getAttribute("tulaj_ID");
					
					Node node1 = elem.getElementsByTagName("nev").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("telephely").item(0);
					String lname = node2.getTextContent();
					
					Node node3 = elem.getElementsByTagName("email").item(0);
					String email = node3.getTextContent();
					
					System.out.println("ID: "+ uid);
					System.out.println("Tulajdonos ID: " + fkeyOwner);
					System.out.println("Név: " + fname);
					System.out.println("Telephely: " + lname);
					System.out.println("Email cím: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Zenekarok kiírása
			NodeList nListZenekar = doc.getElementsByTagName("zenekar");
			for(int i = 0; i < nListZenekar.getLength(); i++) {
				Node nNode = nListZenekar.item(i);
				System.out.println(elementCount + ". Element: " + nNode.getNodeName());
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("ID");
					String fkeyKiado = elem.getAttribute("kiado_ID");
					
					Node node1 = elem.getElementsByTagName("nev").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("alakult").item(0);
					String lname = node2.getTextContent();
					
					Node node3 = elem.getElementsByTagName("mufaj").item(0);
					String email = node3.getTextContent();
					
					System.out.println("ID: "+ uid);
					System.out.println("Kiadó ID: " + fkeyKiado);
					System.out.println("Név: " + fname);
					System.out.println("Alakult: " + lname);
					System.out.println("Mûfaj: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Zenészek kiírása
			NodeList nListZenesz = doc.getElementsByTagName("zenesz");
			for(int i = 0; i < nListZenesz.getLength(); i++) {
				Node nNode = nListZenesz.item(i);
				System.out.println(elementCount + ". Element: " + nNode.getNodeName());
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("ID");
					String fkeyKiado = elem.getAttribute("zenekar_ID");
					
					Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("keresztnev").item(0);
					String lname = node2.getTextContent();
					
					Node node3 = elem.getElementsByTagName("szuletett").item(0);
					String email = node3.getTextContent();
					
					System.out.println("ID: "+ uid);
					System.out.println("Zenekar ID: " + fkeyKiado);
					System.out.println("Vezetéknév: " + fname);
					System.out.println("Keresztnév: " + lname);
					System.out.println("Született: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Hangszerek kiírása
			NodeList nListHangszer = doc.getElementsByTagName("hangszer");
			for(int i = 0; i < nListHangszer.getLength(); i++) {
				Node nNode = nListHangszer.item(i);
				System.out.println(elementCount + ". Element: " + nNode.getNodeName());
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("ID");
					
					Node node1 = elem.getElementsByTagName("gyarto").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("tipus").item(0);
					String lname = node2.getTextContent();
					
					Node node3 = elem.getElementsByTagName("osztaly").item(0);
					String email = node3.getTextContent();
					
					System.out.println("ID: "+ uid);
					System.out.println("Gyártó: " + fname);
					System.out.println("Típus: " + lname);
					System.out.println("Osztály: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Hangszerismeretek kiírása
			NodeList nListHangszerismeret = doc.getElementsByTagName("hangszerismeret");
			for(int i = 0; i < nListHangszerismeret.getLength(); i++) {
				Node nNode = nListHangszerismeret.item(i);
				System.out.println(elementCount + ". Element: " + nNode.getNodeName());
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("hangszer_ID");
					String fkeyKiado = elem.getAttribute("zenesz_ID");
					
					Node node1 = elem.getElementsByTagName("ideje").item(0);
					String fname = node1.getTextContent();
					
					System.out.println("Hangszer ID: "+ uid);
					System.out.println("Zenész ID: " + fkeyKiado);
					System.out.println("Tapasztalat: " + fname + " év");
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
