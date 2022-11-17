package hu.domparse.d2ovj9;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DOMQueryD2ovj9 {

	public static void printOwners(Document doc, int elementCount) {
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
	}
	
	public static void printLabels(Document doc, int elementCount) {
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
		
	}
	
	public static void printMusicians(Document doc, int elementCount) {
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
	}
	
	public static void main(String[] args) {
		try {
		
		//Fájl beolvasás
		File xmlData = new File("XMLD2ovj9.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.parse(xmlData);
		doc.getDocumentElement().normalize();
		int elementCount = 1;
		
		//Szûrési opció beolvasás
		Scanner scan = new Scanner(System.in);
		System.out.println("Szûrés a következõre: \n1.Tulaj\n2.Kiadó\n3.Zenész");
		String option = scan.nextLine();
		
		if(option.equals("1")) {
			printOwners(doc, elementCount);
		} else if(option.equals("2")) {
			printLabels(doc, elementCount);
		} else if(option.equals("3")) {
			printMusicians(doc, elementCount);
		}
		scan.close();
	} catch (Exception e){
		System.out.println(e);
	}

}
}