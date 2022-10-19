package saxd2ovj9;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

public class SaxD2ovj9 {

	public static void main(String[] args) {

		try {
			
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			SaxHandler handler = new SaxHandler();
			sp.parse(new File("./src/saxd2ovj9/HAL_orarend.xml"), handler);
			
		} catch(ParserConfigurationException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
