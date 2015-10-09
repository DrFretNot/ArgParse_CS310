package edu.jsu.mcis;

import java.util.*;

public class Library {
	
	private List<Argument> argumentList;
	private List<String> argNameList;
	private List<String> argValueList;
    private List<Object> parsedValueList;
	private List<String> argDescriptionList;
    
    private String programName = "";
    private String programDescription = "";
    
    public enum argType {INTEGER, FLOAT, STRING, BOOLEAN};
    private HashMap<String, argType> hmap;
	
	public class HelpException extends Exception{
		public HelpException(){
			super();
		}
		public HelpException(String message){
			super(message);
		}
	}
	public class IncorrectNumberOfArgsException extends Exception{
		public IncorrectNumberOfArgsException(){
			super();
		}
		public IncorrectNumberOfArgsException(String message){
			super(message);
		}
	}
	public class IncorrectArgTypeException extends Exception{
		public IncorrectArgTypeException(){
			super();
		}
		public IncorrectArgTypeException(String message){
			super(message);
		}
	}
	
		
		
		
	 
	//constructor
	//Adds 3 ArrayLists to store the name of each argument given by the product owner,
	//the values given for each argument, and the description of each argument. 
  
    
	public Library(){
		argumentList = new ArrayList<Argument>(); 
		argNameList = new ArrayList<String>();
		argValueList = new ArrayList<String>();
		argDescriptionList = new ArrayList<String>();
		parsedValueList = new ArrayList<Object>();
        hmap = new HashMap<String, argType>();
	}
	
	//Stores the name of the program using the library
	//This name is given by the product owner
    //possibly change to setprogramname for readability
    
    public void addProgramName(String inputProgramName){
        programName = inputProgramName;       
    }
    
    public void addProgramDescription(String inputProgramDescription){
        programDescription = inputProgramDescription;       
    }
    //Returns the program name
    public String getProgramName(){
        return programName;   
    }
    
    public String getProgramDescription(){
        return programDescription;   
    }
    
    public void addArgument(Argument arg){
    	argumentList.add(arg);
    }
    //Adds the name of the argument given by the PO to the list of arg names
    //Adds the empty string as the value for each argument in list of arg values
    //Each value in argValueList corresponds to the arg name in argNameList because names 
    //and values are added in the same order
	public void addArgName(String argName){
		argNameList.add(argName);
		argValueList.add("");
	}
    
    public void addArgWithDataType(String argName, argType dataType)  {
        hmap.put(argName, dataType);
        argNameList.add(argName);
        argValueList.add("");
    }
	
	public void addArgDescription(String argDescription){
		argDescriptionList.add(argDescription);
	}
    
    
    //Returns the value corresponding to the arg name passed to the function
    public String getArgValue(String argName){
   		int index = argNameList.indexOf(argName);
   		return argValueList.get(index);
    }

   
    public Object getParsedArgValue(String argName){
   		int index = argNameList.indexOf(argName);    
   		return parsedValueList.get(index);
    }
   
    //Takes the array of strings from the command line and matches each value with the 
    //correct argument
    public void addArgsFromCLI(String[] args){
   		for(int i = 0; i < args.length; i++){
   			argValueList.add(i, args[i]);
   		}
    }
    
    public String parseDataType(String[] args){
        String errorMessage = "";
        int indexHolder = 0;
        String currentTypeError = "";
        try{
        	for (int index = 0; index < args.length; index++){
        		indexHolder = index;
        		Object currentArgument = args[index];
        		argType currentArgType = hmap.get(argNameList.get(index));
        		if (currentArgType == argType.INTEGER){
        			currentTypeError = "integer";
        			currentArgument = Integer.parseInt(args[index]);
        			parsedValueList.add(currentArgument);
        			//return errorMessage;
        		}
        		else if (currentArgType == argType.FLOAT){
        			currentTypeError = "float";
        			currentArgument = Float.parseFloat(args[index]);
        			parsedValueList.add(currentArgument);
        			//return errorMessage;
        		}
        		else if (currentArgType == argType.STRING){
        			parsedValueList.add(currentArgument);
        			//return errorMessage;
        		}
        		//boolean
        		else{
        			currentTypeError = "boolean";
        			currentArgument = Boolean.parseBoolean(args[index]);
        			parsedValueList.add(currentArgument);
        			//return errorMessage;
        		}
        		//else return "Error\n"
        	}
        }
        catch(NumberFormatException e){
			errorMessage = "usage: java " + programName;
			for(int i = 0; i < argNameList.size(); i++) {
                errorMessage += " " + argNameList.get(i);   
            } 
            errorMessage += "\n" + programName + ".java: error: argument " + argNameList.get(indexHolder) + ": invalid ";
            errorMessage += currentTypeError + " value: " + args[indexHolder];
            //return errorMessage;       	
        }
        /*catch(IllegalArgumentException e){
            errorMessage = "usage: java " + programName;
			for(int i = 0; i < argNameList.size(); i++) {
                errorMessage += " " + argNameList.get(i);   
            } 
            errorMessage += "\n" + programName + ".java: error: argument " + argNameList.get(indexHolder) + ": invalid ";
            errorMessage += currentTypeError + " value: " + args[indexHolder];
        
        
        }*/
        //	There exists no method to test whether a String encodes a Boolean; 
        //	for all practical effects, any non-"true"-String is false
        return errorMessage;
    }
    
    int incorrectDataTypeIndex; //used in parseDataType and incorrectDataTypeMessage
    
    private void parseDataTypeWithArgClass(String[] args) throws NumberFormatException{
        String errorMessage = "";
        //int indexHolder = 0;
        String currentTypeError = "";
        
		for (int index = 0; index < args.length; index++){
			incorrectDataTypeIndex = index;
			//Object currentArgument = args[index];
			//argType currentArgType = hmap.get(argNameList.get(index));
			Argument currentArg = argumentList.get(index);
			if (currentArg.getType() == argType.INTEGER){
				//currentTypeError = "integer";
				//currentArgument = Integer.parseInt(args[index]);
				//parsedValueList.add(currentArgument);
				//return errorMessage;
				int argValue = Integer.parseInt(args[index]);
				currentArg.setValue(argValue);
			}
			else if (currentArg.getType() == argType.FLOAT){
				//currentTypeError = "float";
				//currentArgument = Float.parseFloat(args[index]);
				//parsedValueList.add(currentArgument);
				//return errorMessage;
				float argValue = Float.parseFloat(args[index]);
				currentArg.setValue(argValue);
			}
			else if (currentArg.getType() == argType.STRING){
				//parsedValueList.add(currentArgument);
				//return errorMessage;
				String argValue = args[index];
				currentArg.setValue(argValue);
			}
			//boolean
			else{
				//currentTypeError = "boolean";
				//currentArgument = Boolean.parseBoolean(args[index]);
				//parsedValueList.add(currentArgument);
				//return errorMessage;
				Boolean argValue = Boolean.parseBoolean(args[index]);
				currentArg.setValue(argValue);
			}
			//else return "Error\n"
		}
    }
    
    private String incorrectDataTypeMessage(String[] args){
			String errorMessage = "usage: java " + programName;
			for(int i = 0; i < argumentList.size(); i++) {
				Argument currentArg = argumentList.get(i);
                errorMessage += " " + currentArg.getName();   
            }
            Argument currentArg = argumentList.get(incorrectDataTypeIndex); 
            errorMessage += "\n" + programName + ".java: error: argument " + currentArg.getName() + ": invalid "+ currentArg.getType() + " value: " + args[incorrectDataTypeIndex];
            //maybe matching each enum to a lowercase string value
            //errorMessage += currentArg.getType() + " value: " + args[incorrectDataTypeIndex];
            return errorMessage;
            //return errorMessage;
            //String message = "usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: argument width: invalid float value: something";
            //return message;       	
    }
   
    //Checks if the number of arguments given from the command line matches the number of 
    //arguments expected
    //Returns an error message when incorrect arguments are given
    public String checkNumOfArgs(String[] args){
   		int numOfArgNames = argNameList.size();
   		if(args.length < numOfArgNames){
            String message = "usage: java " + programName;
            for(int i = 0; i < argNameList.size(); i++) {
                message += " " + argNameList.get(i);   
            }
            message += "\n" + programName + ".java: error: the following arguments are required:";
            int numOfArgsMissing = numOfArgNames - args.length;
            for(int j = args.length; j < numOfArgNames; j++){
            	message += " " + argNameList.get(j);
            }
   			return message;
   		}
   		else if(args.length > numOfArgNames){
   			String message = "usage: java " + programName;
            for(int i = 0; i < argNameList.size(); i++) {
                message += " " + argNameList.get(i);   
            }
            message += "\n" + programName + ".java: error: unrecognized arguments:";
            int numOfArgsUnrecognized = args.length - numOfArgNames;
            for(int j = numOfArgNames; j < args.length; j++){
            	message += " " + args[j];
            }
   			return message;
   		}
   		else return "";
   }
   
   private String incorrectNumberOfArgsMessage(String[] args){
   		int numOfArgs = argumentList.size();
   		if(args.length < numOfArgs){
            String message = "usage: java " + programName;
            for(int i = 0; i < argumentList.size(); i++) {
            	Argument currentArg = argumentList.get(i);
                message += " " + currentArg.getName();   
            }
            message += "\n" + programName + ".java: error: the following arguments are required:";
            int numOfArgsMissing = numOfArgs - args.length;
            for(int j = args.length; j < numOfArgs; j++){
            	Argument currentArg = argumentList.get(j);
            	message += " " + currentArg.getName();
            }
   			return message;
   		}
   		else {
   			String message = "usage: java " + programName;
            for(int i = 0; i < argumentList.size(); i++) {
            	Argument currentArg = argumentList.get(i);
                message += " " + currentArg.getName();;   
            }
            message += "\n" + programName + ".java: error: unrecognized arguments:";
            int numOfArgsUnrecognized = args.length - numOfArgs;
            for(int j = numOfArgs; j < args.length; j++){
            	message += " " + args[j];
            }
   			return message;
   		}
   }
    
    public String checkForHelpArg(){
        if(argValueList.get(0).equals("-h")){
        	String helpMessage = "usage: java " + programName;
        	for(int i = 0; i < argNameList.size(); i++) {
                helpMessage += " " + argNameList.get(i);   
            }
            helpMessage += "\n" + programDescription + "\npositional arguments:";
            for(int i = 0; i < argNameList.size(); i++) {
                helpMessage += "\n" + argNameList.get(i) + " " + argDescriptionList.get(i);   
            }
            return helpMessage;
        }
        
        else{
        	/*String errorMessage = "-bash: ";
        	for(int i = 0; i < args.length; i++){
        		errorMessage += args[i];
        	}
        	errorMessage += ": command not found";
            return errorMessage; */
            return argValueList.get(0); 
        }
    }
    
    private String helpMessage(){
		String helpMessage = "usage: java " + programName;
		for(int i = 0; i < argumentList.size(); i++) {
			Argument currentArg = argumentList.get(i);
			helpMessage += " " + currentArg.getName();   
		}
		helpMessage += "\n" + programDescription + "\npositional arguments:";
		for(int i = 0; i < argumentList.size(); i++) {
			Argument currentArg = argumentList.get(i);
			helpMessage += "\n" + currentArg.getName() + " " + currentArg.getDescription();   
		}
		return helpMessage;
    }
	
	public argType getArgDataType(String arg){
		return hmap.get(arg);
	}
	
	public String argMultiUseChecker(String[] args){
		if (args[0].equals("-h")){
			return checkForHelpArg();
		}
		else{
			if (!checkNumOfArgs(args).equals("")){
				return checkNumOfArgs(args);	
			}
			else return parseDataType(args);
		}
		//return "false";
	}

	
	public void parse(String[] args) throws HelpException, IncorrectNumberOfArgsException, IncorrectArgTypeException{
		if (args[0].equals("-h")){
			throw new HelpException(helpMessage());
		}
		else if (argumentList.size() != args.length){
				throw new IncorrectNumberOfArgsException(incorrectNumberOfArgsMessage(args));
		}
		else if (argumentList.size() == args.length){
			for(int i = 0; i < args.length; i++){
   				Argument currentArg = argumentList.get(i);
   				currentArg.setValue(args[i]);
   			}
   			/*if (!parseDataType(args).equals("")){
				throw new IncorrectArgTypeException(parseDataType(args));
			}*/
			try{
				parseDataTypeWithArgClass(args);
			}
			catch (Exception e){
				throw new IncorrectArgTypeException(incorrectDataTypeMessage(args));
			}
		}	
		/*if (!checkNumOfArgs(args).equals("")){
			throw new IncorrectNumberOfArgsException(checkNumOfArgs(args));	
		}*/
		
		
	}
   

}












