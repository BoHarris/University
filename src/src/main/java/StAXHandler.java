
package src.main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXHandler {
	public StringBuffer processXMLFile(File xMLFile)
			throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		XMLEvent xMLEvent = null;
		Characters characters = null;
		StringBuffer rawXML = new StringBuffer();
		XMLEventReader xmlEventReader = XMLInputFactory.newInstance()
				.createXMLEventReader(new FileInputStream(xMLFile));
		while (xmlEventReader.hasNext()) {
			xMLEvent = xmlEventReader.nextEvent();
			switch (xMLEvent.getEventType()) {
			case XMLStreamConstants.START_ELEMENT:
				rawXML.append("<" + (((StartElement) xMLEvent).getName()).getLocalPart() + ">");
				break;
			case XMLStreamConstants.CHARACTERS:
				characters = (Characters) xMLEvent;
				if (!(characters.isWhiteSpace() || characters.isIgnorableWhiteSpace()))
					rawXML.append(characters.getData());
				break;
			case XMLStreamConstants.END_ELEMENT:
				rawXML.append("</" + ((EndElement) xMLEvent).getName().getLocalPart() + ">");
				break;

			}

		}
		return rawXML;
	}
}
