package com.harsh;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLXSLTTranformation {

	public static void main(String[] args) throws Exception {
		
		File xml = new File("Order.xml");
	    File xsl = new File("Order.xsl");
	    
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(xml);
	 
	    // Use a Transformer for output
		
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    StreamSource style = new StreamSource(xsl); 
	    Transformer transformer = transformerFactory.newTransformer(style);
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");

	    DOMSource source = new DOMSource(document); 
	    StreamResult result = new StreamResult(System.out); 
	    transformer.transform(source, result);
	    
		 
	    
//	    Element dataTag = document.getDocumentElement();
//	    Element rootNode = (Element) dataTag.getElementsByTagName("Order").item(0);
	    
	    System.out.println("Transformation done.!!");
	}
}
