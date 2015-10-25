package edu.jsu.mcis;

import java.util.*;

public class Library {
	
	private List<NamedArgument> namedArgumentList;
    private List<Argument> argumentList;
    private String programName = "";
    private String programDescription = "";
    private int posCount;
    public enum argType {INTEGER, FLOAT, STRING, BOOLEAN};
    
    public Library(){
		this.programName = "";
        this.programDescription = "";
        this.argumentList = new ArrayList<Argument>();
        this.namedArgumentList = new ArrayList<NamedArgument>(); 
		posCount = -1;
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
    	posCount++;
    	arg.setPosition(posCount);
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
    
   
    
    private ArrayList<String> getPositionalArgs(String[] args){
    	ArrayList<String> posArgList = new ArrayList<String>(); 
    	for(int i = 0; i < args.length; i++){
    		if(!args[i].startsWith("-") && i == 0){
    			posArgList.add(args[i]);
    		}
    		else if(!args[i].startsWith("-")){
    			if(!args[i-1].startsWith("-")){
    				posArgList.add(args[i]);
    			}
    			else{
    				String[] tempNamedArg = new String[2];
					for(int j = 0; j < namedArgumentList.size(); j++){
    					NamedArgument currentArg = namedArgumentList.get(j);
    					if(args[i-1].startsWith("--")){
							tempNamedArg = args[i-1].split("--");
							if(currentArg.getName().equals(tempNamedArg[1])) {
								if(currentArg.getType().equals("boolean")){
									posArgList.add(args[i]);
								}
							}
						}
						else{
							tempNamedArg = args[i-1].split("-");
							if(Character.toString(currentArg.getShortFormName()).equals(tempNamedArg[1])) {
								if(currentArg.getType().equals("boolean")){
									posArgList.add(args[i]);
								}
							}
						}   			
    				}
    			}
    		}
    	}
    	return posArgList;
    }
    
    private void setLongFormNamedArgValues(String[] args){
    	for(int i = 0; i < args.length; i++){
    		String[] tempNamedArg = new String[2];
    		if(args[i].startsWith("--")){
    			tempNamedArg = args[i].split("--");
    			for(int j = 0; j < namedArgumentList.size(); j++){
    				NamedArgument currentArg = namedArgumentList.get(j);
    				if(currentArg.getName().equals(tempNamedArg[1])){
    					if(!currentArg.getType().equals("boolean")){
    						currentArg.setValue(args[i+1]);
    					}
    					else{
    						currentArg.setValue("true");
    					}
    				}
    			}
    		}
    	}
    }
    private void setShortFormNamedArgValues(String[] args){
		for(int i = 0; i < args.length; i++){
			String[] tempNamedArg = new String[2];
			if(args[i].startsWith("-")){
				tempNamedArg = args[i].split("-");
				for(int k = 0; k < namedArgumentList.size(); k++){
					NamedArgument currentArg = namedArgumentList.get(k);
					if(Character.toString(currentArg.getShortFormName()).equals(tempNamedArg[1])){
						if(!currentArg.getType().equals("boolean")){
							currentArg.setValue(args[i+1]);
						}
						else{
							currentArg.setValue("true");
						}
					}
				}
			}
		}
	}
	public void parse(String[] args) throws HelpException, IncorrectNumberOfArgsException, IncorrectArgTypeException{
		if (args[0].startsWith("-h")) {
            throw new HelpException(helpMessage());
		}
		ArrayList<String> tempPositionalArgList = getPositionalArgs(args);
		setLongFormNamedArgValues(args);
		setShortFormNamedArgValues(args);
        NamedArgument helpArgument = getNamedArgument("help");
        if (helpArgument != null){
			String helpArgValue = helpArgument.getValue();
			if (helpArgValue.equals("true")){
				throw new HelpException(helpMessage());
			}
        }
        
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











