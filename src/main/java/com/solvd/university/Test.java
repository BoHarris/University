package com.solvd.university;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
	private static final Logger log = LogManager.getLogger(Test.class.getName());

	public static void main(String[] args) throws InterruptedException {
		try {

			log.debug(transformXML(4, (new StAXHandler()).processXMLFile(new File("resources/User.xml")).toString()));
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException" + e.getMessage());
		} catch (XMLStreamException e) {
			log.error("XMLStreamException: " + e.getMessage());
		} catch (FactoryConfigurationError e) {
			log.error("FactoryConfigurationError: " + e.getMessage());
		} catch (TransformerException e) {
			log.error("Transformer Error: " + e.getMessage());
		}
	}

	public static String transformXML(int indentation, String rawXML) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		transformerFactory.setAttribute("indent-number", indentation);
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StreamResult streamResult = new StreamResult(new StringWriter());
		transformer.transform(new StreamSource(rawXML), streamResult);
		return streamResult.getWriter().toString();
	}
}
