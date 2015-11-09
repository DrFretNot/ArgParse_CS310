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


public class XMLReader{

	private ArgumentParser lib;

	public XMLReader(){
		lib = new ArgumentParser();
	}

	public ArgumentParser addArgumentsFromXMLFile(String fileName) throws ParserConfigurationException, SAXException, IOException{
		
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			Document dom = db.parse(new File(fileName));
	
			//get the root element
			Element program = dom.getDocumentElement();

			//get a nodelist of elements
			NodeList nlName = program.getElementsByTagName("name");
			Element programNameEl = (Element)nlName.item(0);
			String programName = programNameEl.getTextContent();
			lib.addProgramName(programName);
			
			//get a nodelist of elements
			NodeList programDescriptionNL = program.getElementsByTagName("description");
			Element programDescriptionEl = (Element)programDescriptionNL.item(0);
			String programDescription = programDescriptionEl.getTextContent();
			lib.addProgramDescription(programDescription);
			
			//get a nodelist of elements
			NodeList argumentsNL = program.getElementsByTagName("arguments");
			Element arguments = (Element)argumentsNL.item(0);
			//Element argumentsEl = (Element)arguments.item(0);
			
			NodeList positional = arguments.getElementsByTagName("positional");
			
		
			if(positional.getLength() > 0) {
			
				for(int i = 0 ; i < positional.getLength();i++) {
				 	//need to read in description for each argument
				 	
					//get the argument element
					Element el = (Element)positional.item(i);
				
					NodeList nameNL = el.getElementsByTagName("name");
					Element nameEL = (Element)nameNL.item(0);
					String name = nameEL.getTextContent();
				
					NodeList typeNL = el.getElementsByTagName("type");
					Element typeEL = (Element)typeNL.item(0);
					String type = typeEL.getTextContent();
					
					NodeList descriptionNL = el.getElementsByTagName("description");
					Element descriptionEL = (Element)descriptionNL.item(0);
					String description = descriptionEL.getTextContent();
				
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
					PositionalArgument newArg = new PositionalArgument(name, dataType, description);
					//newArg.addElements(name, dataType);
			
					lib.addPositionalArgument(newArg); 
				}
			}
		
			//get another nodelist of elements
			NodeList nlNamed = arguments.getElementsByTagName("named");
		
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