package edu.jsu.mcis;

import java.util.*;

public class Library {

	private List<String> argNameList;
	private List<String> argValueList;
	
	public Library(){
		argNameList = new ArrayList<String>();
		argValueList = new ArrayList<String>();
	}
	
	public void addArgName(String argName){
		argNameList.add(argName);
		argValueList.add("");
	}
    
   public String getArgValue(String argName){
   		int index = argNameList.indexOf(argName);
   		return argValueList.get(index);
   		//return "false";
   }
    
}












