package edu.jsu.mcis;

import java.util.*;

public class Library {
	
    //protected Map<String, Argument> positionalArguments;
	private ArrayList<NamedArgument> namedArgumentList;
    private ArrayList<Argument> argumentList;
    private String programName = "";
    private String programDescription = "";
    public enum argType {INTEGER, FLOAT, STRING, BOOLEAN};
    
    public Library(){
		this.programName = "";
        this.programDescription = "";
        this.argumentList = new ArrayList<>();
        this.namedArgumentList = new ArrayList<>(); 

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
    
    public void addNamedArgument(NamedArgument arg){
    	namedArgumentList.add(arg);
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
    
    public NamedArgument getNamedArgument(String argName){
    	NamedArgument returnArg = null;
    	for(int i = 0; i < namedArgumentList.size(); i++){
    		NamedArgument currentArg = namedArgumentList.get(i);
    		if(currentArg.getName().equals(argName)){
    			returnArg = currentArg;
    		}
    	}
    	return returnArg;
    }
    
    int incorrectDataTypeIndex; //used in parseDataType and incorrectDataTypeMessage
    
    private void parseDataTypeWithArgClass(ArrayList<String> argList) throws NumberFormatException{
        String errorMessage = "";
        String currentTypeError = "";
        
		for (int index = 0; index < argList.size(); index++){
			incorrectDataTypeIndex = index;
			Argument currentArg = argumentList.get(index);
			if (currentArg.getType().equals("integer")){
				int argValue = Integer.parseInt(argList.get(index));
				currentArg.setValue(String.valueOf(argValue));
			}
            
			else if (currentArg.getType().equals("float")){
				float argValue = Float.parseFloat(argList.get(index));
				currentArg.setValue(String.valueOf(argValue));
			}
            
			else if (currentArg.getType().equals("string")){
				String argValue = argList.get(index);
				currentArg.setValue(argValue);
			}
			
			else{
				Boolean argValue = Boolean.parseBoolean(argList.get(index));
				currentArg.setValue(String.valueOf(argValue));
			}
		}
    }
    
    private String incorrectDataTypeMessage(ArrayList<String> argList){
		String errorMessage = "usage: java " + programName;
		for(int i = 0; i < argumentList.size(); i++) {
			Argument currentArg = argumentList.get(i);
            errorMessage += " " + currentArg.getName();   
        }
            
        Argument currentArg = argumentList.get(incorrectDataTypeIndex); 
        errorMessage += "\n" + programName + ".java: error: argument " + currentArg.getName() + ": invalid "+ currentArg.getType() + " value: " + argList.get(incorrectDataTypeIndex);
        return errorMessage;    	
    }
   
   private String incorrectNumberOfArgsMessage(ArrayList<String> argList){
   		int numOfArgs = argumentList.size();
   		if(argList.size() < numOfArgs){
            String message = "usage: java " + programName;
            for(int i = 0; i < argumentList.size(); i++) {
            	Argument currentArg = argumentList.get(i);
                message += " " + currentArg.getName();   
            }
            
            message += "\n" + programName + ".java: error: the following arguments are required:";
            //int numOfArgsMissing = numOfArgs - args.length;
            
            for(int j = argList.size(); j < numOfArgs; j++){
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
            //int numOfArgsUnrecognized = args.length - numOfArgs;
            
            for(int j = numOfArgs; j < argList.size(); j++){
            	message += " " + argList.get(j);
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
        String temp = "";
        for (int i = 0; i < args.length; i++){
            if(args[i].startsWith("--")){
                temp = args[i];
                temp = temp.replace("--","");
            }
        
        }
        return temp;
    }
    
     /*private boolean longFormArgCheck(String[] args){
     // Go through the args coming in and check for the string "--" 
    // whatever is immediately following will be the name of our long form argument.
        boolean tempOne = false; 
        for (int i = 0; i < args.length; i++){
            if(args[i].startsWith("--")){
               tempOne = true;
                //return true;
            }
        
        }
        return tempOne;
        
    }*/
    
    private ArrayList<String> getPositionalArgs(String[] args){
    	ArrayList<String> posArgList = new ArrayList<>(); 
    	for(int i = 0; i < args.length; i++){
    		if(!args[i].startsWith("--") && i == 0){
    			posArgList.add(args[i]);
    		}
    		else if(!args[i].startsWith("--") && !args[i-1].startsWith("--")){
    			posArgList.add(args[i]);
    		}
    	}
    	return posArgList;
    }
	
	public void parse(String[] args) throws HelpException, IncorrectNumberOfArgsException, IncorrectArgTypeException{
		if (args[0].startsWith("-h")) {
            throw new HelpException(helpMessage());
		}
		ArrayList<String> tempPositionalArgList = getPositionalArgs(args);
        /*else if (longFormArgCheck(args)){
            String temp = longFormArg(args);
            if (temp == "help"){
                throw new HelpException(helpMessage());
            }
        }*/
		if (argumentList.size() != tempPositionalArgList.size()){
				throw new IncorrectNumberOfArgsException(incorrectNumberOfArgsMessage(tempPositionalArgList));
		}
		else if (argumentList.size() == tempPositionalArgList.size()){
			for(int i = 0; i < tempPositionalArgList.size(); i++){
   				Argument currentArg = argumentList.get(i);
   				currentArg.setValue(tempPositionalArgList.get(i));
   			}
			try{
				parseDataTypeWithArgClass(tempPositionalArgList);
			}
			catch (Exception e){
				throw new IncorrectArgTypeException(incorrectDataTypeMessage(tempPositionalArgList));
			}
		}	
	}
}


//Katie and Andrew: possibly test if startswith -- in the for loop to add the values from the CLI
//then call a method that handles the named argument  









