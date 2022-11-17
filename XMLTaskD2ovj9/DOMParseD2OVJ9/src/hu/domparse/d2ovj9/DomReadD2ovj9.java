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
			//F�jl beolvas�s
			File xmlData = new File("XMLD2ovj9.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(xmlData);
			doc.getDocumentElement().normalize();
			int elementCount = 1;
			
			//Gy�k�r ki�r�s
			System.out.println("Root: " + doc.getDocumentElement().getNodeName());
			System.out.println("===============================================");
			
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
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("telephely").item(0);
					String lname = node2.getTextContent();
					
					Node node3 = elem.getElementsByTagName("email").item(0);
					String email = node3.getTextContent();
					
					System.out.println("ID: "+ uid);
					System.out.println("Tulajdonos ID: " + fkeyOwner);
					System.out.println("N�v: " + fname);
					System.out.println("Telephely: " + lname);
					System.out.println("Email c�m: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
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
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("alakult").item(0);
					String lname = node2.getTextContent();
					
					Node node3 = elem.getElementsByTagName("mufaj").item(0);
					String email = node3.getTextContent();
					
					System.out.println("ID: "+ uid);
					System.out.println("Kiad� ID: " + fkeyKiado);
					System.out.println("N�v: " + fname);
					System.out.println("Alakult: " + lname);
					System.out.println("M�faj: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Zen�szek ki�r�sa
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
					System.out.println("Vezet�kn�v: " + fname);
					System.out.println("Keresztn�v: " + lname);
					System.out.println("Sz�letett: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Hangszerek ki�r�sa
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
					System.out.println("Gy�rt�: " + fname);
					System.out.println("T�pus: " + lname);
					System.out.println("Oszt�ly: " + email);
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			//Hangszerismeretek ki�r�sa
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
					System.out.println("Zen�sz ID: " + fkeyKiado);
					System.out.println("Tapasztalat: " + fname + " �v");
					System.out.println("===============================================");
					elementCount++;
				}
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
