package test;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@WebServlet("/search2")
public class search2{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		System.out.println("test");
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//		Document document = documentBuilder.parse("WebContent/white.xhtml");		
	}
}
