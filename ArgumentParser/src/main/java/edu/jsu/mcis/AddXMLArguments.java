package edu.jsu.mcis;

import java.util.*;
import java.lang.Object.*;
import javax.xml.parsers.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.xml.sax.SAXException; 
import java.io.File;
import java.io.IOException;


public class AddXMLArguments{

	private ArgumentParser lib;

	public AddXMLArguments(){
		lib = new ArgumentParser();
	}

	public ArgumentParser addArgumentsFromXMLFile(String fileName) throws ParserConfigurationException, SAXException, IOException{
		
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
				
					
					Argument.ArgType dataType;
					if(type.equals("integer")){
						dataType = Argument.ArgType.INTEGER;
					}
					else if(type.equals("float")){
						dataType = Argument.ArgType.FLOAT;
					}
					else if(type.equals("string")){
						dataType = Argument.ArgType.STRING;
					}
					else if(type.equals("boolean")){
						dataType = Argument.ArgType.BOOLEAN;
					}
					else{
						dataType = Argument.ArgType.STRING;
					}
					PositionalArgument newArg = new PositionalArgument(name, dataType);
					//newArg.addElements(name, dataType);
			
					lib.addPositionalArgument(newArg); 
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
					Argument.ArgType dataType;
					if(type.equals("integer")){
						dataType = Argument.ArgType.INTEGER;
					}
					else if(type.equals("float")){
						dataType = Argument.ArgType.FLOAT;
					}
					else if(type.equals("string")){
						dataType = Argument.ArgType.STRING;
					}
					else if(type.equals("boolean")){
						dataType = Argument.ArgType.BOOLEAN;
					}
					else{
						dataType = Argument.ArgType.STRING;
					}
			
					//newArg.addElements(name, dataType);
					lib.addNamedArgument(new NamedArgument(name, defaultValue, dataType, shortFormName));
					//addArgument(newArg); 
				}
			}
		return lib;
	}
}