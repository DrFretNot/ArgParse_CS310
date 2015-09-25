package edu.jsu.mcis;

import java.util.*;

public class Library {

	private List<String> argNameList;
	private List<String> argValueList;
    private String programName;
	
    
    
	public Library(){ 
		argNameList = new ArrayList<String>();
		argValueList = new ArrayList<String>();
	}
	
    //
	public void addArgName(String argName){
		argNameList.add(argName);
		argValueList.add("");
	}
    
   public String getArgValue(String argName){
   		int index = argNameList.indexOf(argName);
   		return argValueList.get(index);
   }
   
   public void addArgsFromCLI(String[] args){
   		for(int i = 0; i < args.length; i++){
   			argValueList.add(i, args[i]);
   		}
   }
   
   public String checkNumOfArgs(String[] args){
   		int numOfArgNames = argNameList.size();
   		if(args.length < numOfArgNames){
            String s = "usage: java " + programName + " ";
            for(llll) {
                s += argname + " ";   
            }
            s += "\n" + progname + ...
   			return "usage: Java" + programName + "length width height\nVolumeCalculator.java: error: the following                     arguments are required: height"; //find what is missing between numOfArgsNames and                                                                 // the arguments from CLI. 
   		}
   		else if(args.length > numOfArgNames){
   			return "Error";
   		}
   		else return "";
   }
    
    public void addProgramName(String inputProgramName){
        
        programName = inputProgramName;
        
           
    }
    
    public String getProgramName(){
        return programName;   
    }
    
    
    
}












