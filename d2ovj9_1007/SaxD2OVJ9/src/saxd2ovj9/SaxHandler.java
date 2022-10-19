package saxd2ovj9;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	
	public void startElement(String uri, String localName, String qName, Attributes att) {
		if(qName != "orarend") {
			tabCount++;
			tabulate();
		}
		System.out.println(qName + getAttributes(att) +  " start");
	}
	
	public void endElement(String uri, String localName, String qName) {
		tabulate();
		tabCount--;
		System.out.println(qName + " end");
	}
	
	public void characters(char ch[], int start, int length) {
		String content = new String(ch, start, length).trim();
		if(!content.isEmpty()) {
			tabCount++;
			tabulate();
			tabCount--;
			System.out.println(content);
		}
	}
	
	private String getAttributes(Attributes att) {
		if(att.getLength() == 0) {
			return "";
		} 
		
		StringBuilder attributeBuilder = new StringBuilder(", {");
		for(int i = 0; i < att.getLength(); i++) {
			attributeBuilder.append(att.getLocalName(i) + " = " + att.getValue(i));
			if(i < att.getLength() - 1) {
				attributeBuilder.append(", ");
			}
		}
		attributeBuilder.append("}");
		return attributeBuilder.toString();		
	}
	
	private int tabCount = 0;
	private void tabulate() {
		for(int i = 0; i < tabCount; i++) {
			System.out.print("\t");
		}
	}
}
