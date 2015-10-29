package edu.jsu.mcis;

import java.util.*;
import java.lang.Object.*;
import javax.xml.parsers.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.*;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class AddXMLArguments{

	public AddXMLArguments(){};

	public Library addArgumentsFromXMLFile(String fileName) throws ParserConfigurationException, SAXException, IOException{
		Library lib = new Library();
		
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			Document dom = db.parse(new File(fileName));
	
			//get the root element
			Element docEle = dom.getDocumentElement();

			//get a nodelist of elements
			NodeList nl = docEle.getElementsByTagName("positional");
		
			if(nl.getLength() > 0) {
			
				for(int i = 0 ; i < nl.getLength();i++) {
				 
					//get the argument element
					Element el = (Element)nl.item(i);
				
					NodeList nameNL = el.getElementsByTagName("name");
					Element nameEL = (Element)nameNL.item(0);
					String name = nameEL.getTextContent();
				
					NodeList typeNL = el.getElementsByTagName("type");
					Element typeEL = (Element)typeNL.item(0);
					String type = typeEL.getTextContent();
				
					NodeList positionNL = el.getElementsByTagName("position");
					Element positionEL = (Element)positionNL.item(0);
					String position = positionEL.getTextContent();
				
					Argument newArg = new Argument();
					Library.argType dataType;
					if(type.equals("integer")){
						dataType = Library.argType.INTEGER;
					}
					else if(type.equals("float")){
						dataType = Library.argType.FLOAT;
					}
					else if(type.equals("string")){
						dataType = Library.argType.STRING;
					}
					else if(type.equals("boolean")){
						dataType = Library.argType.BOOLEAN;
					}
					else{
						dataType = Library.argType.STRING;
					}
			
					newArg.addElements(name, dataType);
			
					lib.addArgument(newArg); 
				}
			}
		
			//get another nodelist of elements
			NodeList nlNamed = docEle.getElementsByTagName("named");
		
			if(nlNamed.getLength() > 0) {
			
				for(int i = 0 ; i < nlNamed.getLength();i++) {
				 
					//get the argument element
					Element el = (Element)nlNamed.item(i);
				
					NodeList nameNL = el.getElementsByTagName("name");
					Element nameEL = (Element)nameNL.item(0);
					String name = nameEL.getTextContent();
				
					NodeList typeNL = el.getElementsByTagName("type");
					Element typeEL = (Element)typeNL.item(0);
					String type = typeEL.getTextContent();
				
					NodeList shortnameNL = el.getElementsByTagName("shortname");
					Element shortnameEL = (Element)shortnameNL.item(0);
					String shortname = shortnameEL.getTextContent();
					char shortFormName = shortname.charAt(0);
				
					NodeList defaultNL = el.getElementsByTagName("default");
					Element defaultEL = (Element)defaultNL.item(0);
					String defaultValue = defaultEL.getTextContent();
				
					//Argument newArg = new Argument();
					Library.argType dataType;
					if(type.equals("integer")){
						dataType = Library.argType.INTEGER;
					}
					else if(type.equals("float")){
						dataType = Library.argType.FLOAT;
					}
					else if(type.equals("string")){
						dataType = Library.argType.STRING;
					}
					else if(type.equals("boolean")){
						dataType = Library.argType.BOOLEAN;
					}
					else{
						dataType = Library.argType.STRING;
					}
			
					//newArg.addElements(name, dataType);
					lib.addNamedArgument(new NamedArgument(name, defaultValue, dataType, shortFormName));
					//addArgument(newArg); 
				}
			}
		return lib;
	}
}