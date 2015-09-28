package edu.jsu.mcis;

import java.util.*;

public class Library {

	private List<String> argNameList;
	private List<String> argValueList;
    private String programName = "";
	
	//constructor
	//Adds 2 ArrayLists to store the name of each argument given by the product owner
	//and the values given for each argument 
	public Library(){ 
		argNameList = new ArrayList<String>();
		argValueList = new ArrayList<String>();
	}
	
	//Stores the name of the program using the library
	//This name is given by the product owner.
    public void addProgramName(String inputProgramName){
        programName = inputProgramName;       
    }
    
    //Returns the program name
    public String getProgramName(){
        return programName;   
    }
    
    //Adds the name of the argument given by the PO to the list of arg names
    //Adds the empty string as the value for each argument in list of arg values
    //Each value in argValueList corresponds to the arg name in argNameList because names 
    //and values are added in the same order
	public void addArgName(String argName){
		argNameList.add(argName);
		argValueList.add("");
	}
    
    //Returns the value corresponding to the arg name passed to the function
   public String getArgValue(String argName){
   		int index = argNameList.indexOf(argName);
   		return argValueList.get(index);
   }
   
   //Takes the array of strings from the command line and matches each value with the 
   //correct argument
   public void addArgsFromCLI(String[] args){
   		for(int i = 0; i < args.length; i++){
   			argValueList.add(i, args[i]);
   		}
   }
   
   //Checks if the number of arguments given from the command line matches the number of 
   //arguments expected
   //Returns an error message when incorrect arguments are given
   public String checkNumOfArgs(String[] args){
   		int numOfArgNames = argNameList.size();
   		if(args.length < numOfArgNames){
            String message = "usage: java " + programName + " ";
            for(int i = 0; i < argNameList.size(); i++) {
                message += argNameList.get(i) + " ";   
            }
            message += "\n" + programName + ".java: error: the following arguments are required: ";
            int numOfArgsMissing = numOfArgNames - args.length;
            for(int j = args.length; j < numOfArgNames; j++){
            	message += argNameList.get(j) + " ";
            }
   			return message;
   		}
   		else if(args.length > numOfArgNames){
   			String message = "usage: java " + programName + " ";
            for(int i = 0; i < argNameList.size(); i++) {
                message += argNameList.get(i) + " ";   
            }
            message += "\n" + programName + ".java: error: unrecognized arguments: ";
            int numOfArgsUnrecognized = args.length - numOfArgNames;
            for(int j = numOfArgNames; j < args.length; j++){
            	message += args[j] + " ";
            }
   			return message;
   		}
   		else return "";
   }
    
    public String checkForHelpArg(String args){
        if(args == "-h"){
            return "usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\n    length the length of the box\n    width the width of the box\n    height the height of the box\n"; 
        }
        
        else{
            return "-bash:" + args + " command not found";   
        }
    }
    
   
    
}












