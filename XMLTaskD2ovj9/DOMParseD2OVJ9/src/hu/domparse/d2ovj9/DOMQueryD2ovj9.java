package hu.domparse.d2ovj9;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


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
				String name = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("telephely").item(0);
				String location = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("email").item(0);
				String email = node3.getTextContent();
				
				System.out.println("ID: "+ uid);
				System.out.println("Tulajdonos ID: " + fkeyOwner);
				System.out.println("Név: " + name);
				System.out.println("Telephely: " + location);
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
				String fkeyBand = elem.getAttribute("zenekar_ID");
				
				Node node1 = elem.getElementsByTagName("vezeteknev").item(0);
				String fname = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("keresztnev").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("szuletett").item(0);
				String born = node3.getTextContent();
				
				Node node4 = elem.getElementsByTagName("nem").item(0);
				String gender = node4.getTextContent();
				
				System.out.println("ID: "+ uid);
				System.out.println("Zenekar ID: " + fkeyBand);
				System.out.println("Vezetéknév: " + fname);
				System.out.println("Keresztnév: " + lname);
				System.out.println("Született: " + born);
				System.out.println("Nem: " + gender);
				System.out.println("===============================================");
				elementCount++;
			}
		}
	}
	
	public static void getEmail(Document doc ,String id) throws XPathExpressionException {
		//XPath keresés
				XPathFactory xpathFactory = XPathFactory.newInstance();
				XPath xpath = xpathFactory.newXPath();
				XPathExpression expr = xpath.compile("//tulajdonos[@ID='"+ id +"']/email/text()");
				Object result = expr.evaluate(doc, XPathConstants.NODESET);
			    NodeList nodes = (NodeList) result;
			    for (int i = 0; i < nodes.getLength(); i++) {
			      System.out.println(nodes.item(i).getNodeValue());
			    }
				
	}
	
	public static void getGenre(Document doc, String band) throws XPathExpressionException {
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile("//zenekar[nev='"+ band +"']/mufaj/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
	    for (int i = 0; i < nodes.getLength(); i++) {
	      System.out.println(nodes.item(i).getNodeValue());
	    }
	}
	
	public static String getQueryOption(Scanner scan) {
		System.out.println("Szûrés a következõre: \n1.Tulaj\n2.Kiadó\n3.Zenész\n4.Tulajdonos e-mail címe\n5.Zenekar mûfaja\n0.Kilépés");
		String option =  Integer.toString(readInt(scan, 0, 5));
		return option;
	}
	
	public static String getQueryID(Scanner scan) {
		System.out.println("Adja meg a tulajdonos ID-jét");
		scan.nextLine();	//A readInt nextInt-je miatt kell!
		String id = scan.nextLine();
		return id;
	}
	
	public static String getBandName(Scanner scan) {
		System.out.println("Adja meg a zenekar nevét");
		scan.nextLine();	//A readInt nextInt-je miatt kell!
		String id = scan.nextLine();
		return id;
	}
	
	public static Document createDocument() throws ParserConfigurationException, SAXException, IOException {
		//Fájl beolvasás
		File xmlData = new File("XMLD2ovj9.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.parse(xmlData);
		doc.getDocumentElement().normalize();

		return doc;
	}
	
	public static int readInt(Scanner scan, int minLimit, int maxLimit) {

		int number;
		do {
			System.out.println("Adj meg egy opciót " + minLimit + " és " + maxLimit + " között!");
		    while (!scan.hasNextInt()) {
		        System.out.println("Ilyen opció nincs! Próbálkozz újra!");
		        scan.next(); 
		    }
		    number = scan.nextInt();
		} while (number < minLimit || number > maxLimit);
		
		return number;
	}
	
	public static void main(String[] args) {
		try {
		
		Document doc = createDocument();
		int elementCount = 1;	
				
		//Szûrési opció beolvasás
		Scanner scan = new Scanner(System.in);
		String option = getQueryOption(scan);
		
		if(option.equals("1")) {
			printOwners(doc, elementCount);
		} else if(option.equals("2")) {
			printLabels(doc, elementCount);
		} else if(option.equals("3")) {
			printMusicians(doc, elementCount);
		} else if(option.equals("4")) {
			String id = getQueryID(scan);
			getEmail(doc, id);
		} else if(option.equals("5")) {
			String band = getBandName(scan);
			getGenre(doc, band);
		} else if (option.equals("0")) {
			System.exit(1);
			scan.close();
		}
		scan.close();
	} catch (Exception e){
		System.out.println(e);
	}

}
}