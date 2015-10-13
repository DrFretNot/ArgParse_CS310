package edu.jsu.mcis;

import java.util.*;

public class Library {
	
    protected Map<String, Argument> positionalArguments;
	protected Map<String, NamedArgument> namedArgument;
    private ArrayList<Argument> argumentList;
    private String programName = "";
    private String programDescription = "";
    public enum argType {INTEGER, FLOAT, STRING, BOOLEAN};
    
    public Library(){
		this.programName = "";
        this.programDescription = "";
        this.argumentList = new ArrayList<>(); 

	}
	
	public class HelpException extends Exception{
		public HelpException(String message){
			super(message);
		}
	}
    
	public class IncorrectNumberOfArgsException extends Exception{
		public IncorrectNumberOfArgsException(String message){
			super(message);
		}
	}
    
	public class IncorrectArgTypeException extends Exception{
		public IncorrectArgTypeException(String message){
			super(message);
		}
	}
    
    public void addProgramName(String inputProgramName){
        programName = inputProgramName;       
    }
    
    public void addProgramDescription(String inputProgramDescription){
        programDescription = inputProgramDescription;       
    }
    
    public String getProgramName(){
        return programName;   
    }
    
    public String getProgramDescription(){
        return programDescription;   
    }
    
    public void addArgument(Argument arg){
    	argumentList.add(arg);
    }
    
    public Argument getArgument(String argName){
    	Argument returnArg = null;
    	for(int i = 0; i < argumentList.size(); i++){
    		Argument currentArg = argumentList.get(i);
    		if(currentArg.getName().equals(argName)){
    			returnArg = currentArg;
    		}
    	}
    	return returnArg;
    }
    
    int incorrectDataTypeIndex; //used in parseDataType and incorrectDataTypeMessage
    
    private void parseDataTypeWithArgClass(String[] args) throws NumberFormatException{
        String errorMessage = "";
        String currentTypeError = "";
        
		for (int index = 0; index < args.length; index++){
			incorrectDataTypeIndex = index;
			Argument currentArg = argumentList.get(index);
			if (currentArg.getType().equals("integer")){
				int argValue = Integer.parseInt(args[index]);
				currentArg.setValue(String.valueOf(argValue));
			}
            
			else if (currentArg.getType().equals("float")){
				float argValue = Float.parseFloat(args[index]);
				currentArg.setValue(String.valueOf(argValue));
			}
            
			else if (currentArg.getType().equals("string")){
				String argValue = args[index];
				currentArg.setValue(argValue);
			}
			
			else{
				Boolean argValue = Boolean.parseBoolean(args[index]);
				currentArg.setValue(String.valueOf(argValue));
			}
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
        return errorMessage;    	
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
    
    private String longFormArg(String[] args){
     // Go through the args coming in and check for the string "--" 
    // whatever is immediately following will be the name of our long form argument.
        
        for (int i = 0; i < argumentList.size(); i++){
            if(args[i].startsWith("--")){
                String temp = args[i];
                temp = temp.replace("--","");
            }
        
        }
        return temp;
    }
    
     private boolean longFormArgCheck(String[] args){
     // Go through the args coming in and check for the string "--" 
    // whatever is immediately following will be the name of our long form argument.
        boolean tempOne = false; 
        for (int i = 0; i < argumentList.size(); i++){
            if(args[i].startsWith("--")){
               //temp = true;
                return true;
            }
        
        }
        return tempOne;
        
    }
	
	public void parse(String[] args) throws HelpException, IncorrectNumberOfArgsException, IncorrectArgTypeException{
		if (args[0].startsWith("-h")) {
            throw new HelpException(helpMessage());
		}
        else if (longFormArgCheck(args) == true){
            String temp = longFormArg(args);
            if (temp == "help"){
                throw new HelpException(helpMessage());
            }
        }
		else if (argumentList.size() != args.length){
				throw new IncorrectNumberOfArgsException(incorrectNumberOfArgsMessage(args));
		}
		else if (argumentList.size() == args.length){
			for(int i = 0; i < args.length; i++){
   				Argument currentArg = argumentList.get(i);
   				currentArg.setValue(args[i]);
   			}
			try{
				parseDataTypeWithArgClass(args);
			}
			catch (Exception e){
				throw new IncorrectArgTypeException(incorrectDataTypeMessage(args));
			}
		}	
	}
}












