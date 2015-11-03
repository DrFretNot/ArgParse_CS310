/*
package edu.jsu.mcis;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ArgumentXML {
    
    public ArgumentXML() {
        
    }
    
    public static Library load(String file) {
          try {
              File fXmlFile = new File(file);
              Library lib = new Library();
              DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
              DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
              Document doc = dBuilder.parse(fXmlFile);  
              doc.getDocumentElement().normalize();
              NodeList nList = doc.getElementsByTagName("argument");
              
              for (int temp = 0; temp < nList.getLength(); temp++) {

		          Node nNode = nList.item(temp);
              }
          }
        catch (Exception e) {
	       e.printStackTrace();   
        }
        return Library;
        
    }
    
    





}

*/



