package com.solvd.university;

import java.io.*;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class STaXWriter {

	private static final Logger log = LogManager.getLogger(STaXWriter.class.getName());

	public static void WriteFile() {
		try {
			XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
			XMLStreamWriter xmlStreamWriter = xmlOutputFactory
					.createXMLStreamWriter(new FileOutputStream("src/src/main/resources/UserSTAX.xml"));
			xmlStreamWriter.writeStartDocument("1.0");
			// create user element
			xmlStreamWriter.writeStartElement("user");

			xmlStreamWriter.writeStartElement("id");
			xmlStreamWriter.writeCharacters("1");
			// end id elements
			xmlStreamWriter.writeEndElement();

			xmlStreamWriter.writeStartElement("fullname");

			xmlStreamWriter.writeStartElement("fName");
			xmlStreamWriter.writeCharacters("Tom");
			// end fName elements
			xmlStreamWriter.writeEndElement();

			xmlStreamWriter.writeStartElement("mName");
			xmlStreamWriter.writeCharacters("Robert");
			// end mName elements
			xmlStreamWriter.writeEndElement();

			xmlStreamWriter.writeStartElement("lName");
			xmlStreamWriter.writeCharacters("Smith");
			// end lName elements
			xmlStreamWriter.writeEndElement();

			// end fullname
			xmlStreamWriter.writeEndElement();

			xmlStreamWriter.writeStartElement("email");
			xmlStreamWriter.writeCharacters("Tom.Smith@email.com");
			// end email elements
			xmlStreamWriter.writeEndElement();

			xmlStreamWriter.writeStartElement("birthDate");

			xmlStreamWriter.writeStartElement("month");
			xmlStreamWriter.writeCharacters("January");
			// end Month elements
			xmlStreamWriter.writeEndElement();

			xmlStreamWriter.writeStartElement("Day");
			xmlStreamWriter.writeCharacters("27");
			// end day elements
			xmlStreamWriter.writeEndElement();

			xmlStreamWriter.writeStartElement("Year");
			xmlStreamWriter.writeCharacters("1927");
			// end year elements
			xmlStreamWriter.writeEndElement();

			// end birthday
			xmlStreamWriter.writeEndElement();

			// end user elements
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.flush();
			xmlStreamWriter.close();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
