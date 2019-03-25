package com.harsh;

import java.io.File;
import java.util.Base64;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.value.Base64BinaryValue;

public class HelloWorldHTML {

	public static void main(String[] args) throws Exception {
		
		//Source xml = new StreamSource(new File("HelloWorld.xml"));
		Source xsl = new StreamSource(new File("HelloWorld.xsl"));
		
		//StringWriter sw = new StringWriter();
		//FileWriter fw = new FileWriter("HelloWorldOutput.xml");
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer trasform = tFactory.newTransformer(xsl);
		
		//System.out.println(new String(Base64.getEncoder().encode("SAMPLE".getBytes())));
		
		byte[] input = "SAMPLE".getBytes();
		for(int i=0;i<5;i++) {
			trasform.setParameter("attachmentBytes", new Base64BinaryValue(input));
			trasform.setOutputProperty("omit-xml-declaration", "yes");
			trasform.transform(new StreamSource(new File("HelloWorld.xsl")),new StreamResult(System.out));
			System.out.println();
		}
		//fw.write(sw.toString());
		//fw.close();
		//System.out.println("Conversion done!!!");
	}
}
