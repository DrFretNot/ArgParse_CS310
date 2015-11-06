/**
*Argument Parser is a user-friendly library for taking in command line arguments
*and returning their user specified values. The user defines what arguments are 
*required. Then the program will parse command line info, and will automatically 
*genreate help, useage, and error messages when the program is given program 
*invalid arguments.
*
*
*/

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

/**
<h2> 
INTRO TO ArgParse! 
</h2>

<p>The ArgParse_CS310 module make it easy to write user-friendly 
command-line interfaces. The program defines what arguemtns is 
requires, and argparse will figure out how to parse those arguments. 
The argparse module also automatically generates help and 
usage messages and issues error codes when users 
give program invalid arguments.</p>

@param  url  an absolute URL giving the base location of the image
@param  name the location of the image, relative to the url argument
@return      the image at the specified URL
@see         Image
*/



public class ArgumentParser {
	
	private List<NamedArgument> namedArgumentList; //hashmap, key would be the name of the argument
	//if short form is given from CLI, need to search for the name then find it in the map
    private List<PositionalArgument> positionalArgumentList;
    private String programName = "";
    private String programDescription = "";
    private int posCount;
    
    
/**
the Argument Parser constructor this will instantiate a new instance of the Parser
<p>The constructor enters the blanks for the program name and the program description. 
Creates a new lists for positional and named arguments. These will be used to hold the 
arguments that are created by the user. </p>
*/    
    public ArgumentParser(){
		this.programName = "";
        this.programDescription = "";
        this.positionalArgumentList = new ArrayList<PositionalArgument>();
        this.namedArgumentList = new ArrayList<NamedArgument>(); 
		posCount = -1;
	}
	
/**
addProgramName


*/
    
    
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
    
    public void addPositionalArgument(PositionalArgument arg){
    	posCount++;
    	arg.setPosition(posCount);
    	positionalArgumentList.add(arg);
    }
    
    public void addNamedArgument(NamedArgument arg){ //needs to be added to a map
    	namedArgumentList.add(arg);
    }
    
    public PositionalArgument getPositionalArgument(String argName){
    	PositionalArgument returnArg = null;
    	for(int i = 0; i < positionalArgumentList.size(); i++){
    		PositionalArgument currentArg = positionalArgumentList.get(i);
    		if(currentArg.getName().equals(argName)){
    			returnArg = currentArg;
    		}
    	}
    	return returnArg;
    }
    
    public PositionalArgument getPositionalArgument(int argPosition){
    	PositionalArgument returnArg = null;
    	for(int i = 0; i < positionalArgumentList.size(); i++){
    		PositionalArgument currentArg = positionalArgumentList.get(i);
    		if(currentArg.getPosition() == argPosition - 1){
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
    
    public NamedArgument getNamedArgument(char argShortFormName){
    	NamedArgument returnArg = null;
    	for(int i = 0; i < namedArgumentList.size(); i++){
    		NamedArgument currentArg = namedArgumentList.get(i);
    		if(currentArg.getShortFormName() == argShortFormName){
    			returnArg = currentArg;
    		}
    	}
    	return returnArg;
    }
 
    int incorrectDataTypeIndex; //used in parseDataType and incorrectDataTypeMessage
    String incorrectArgumentType; //used in parseDataType and incorrectDataTypeMessage
    
    private void parseDataType(ArrayList<String> argList) throws NumberFormatException{
        
        //checking positional args
		for (int index = 0; index < argList.size(); index++){
			incorrectDataTypeIndex = index;
			incorrectArgumentType = "positional";
			PositionalArgument currentArg = positionalArgumentList.get(index);
			if (currentArg.getType().equals("integer")){
				int argValue = Integer.parseInt(argList.get(index));
				currentArg.setValue(String.valueOf(argValue));
				//currentArg.setValue(argValue);
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
		
		//checking named args
		for (int index = 0; index < namedArgumentList.size(); index++){
			incorrectDataTypeIndex = index;
			incorrectArgumentType = "named";
			NamedArgument currentArg = namedArgumentList.get(index);
			if (currentArg.getType().equals("integer")){
				int argValue = Integer.parseInt(currentArg.getValue());
				currentArg.setValue(String.valueOf(argValue));
			}
            
			else if (currentArg.getType().equals("float")){
				float argValue = Float.parseFloat(currentArg.getValue());
				currentArg.setValue(String.valueOf(argValue));
			}
            
			else if (currentArg.getType().equals("string")){
				String argValue = currentArg.getValue();
				currentArg.setValue(argValue);
			}
			
			else{
				Boolean argValue = Boolean.parseBoolean(currentArg.getValue());
				currentArg.setValue(String.valueOf(argValue));
			}
		}
    }
    
    private String incorrectDataTypeMessage(ArrayList<String> argList){
		if (incorrectArgumentType.equals("positional")){
			String errorMessage = "usage: java " + programName;
			for(int i = 0; i < positionalArgumentList.size(); i++) {
				PositionalArgument currentArg = positionalArgumentList.get(i);
				errorMessage += " " + currentArg.getName();   
			}
			
			PositionalArgument currentArg = positionalArgumentList.get(incorrectDataTypeIndex); 
			errorMessage += "\n" + programName + ".java: error: argument " + currentArg.getName() + ": invalid "+ currentArg.getType() + " value: " + argList.get(incorrectDataTypeIndex);
			return errorMessage;  
		}
		
		else {
			String errorMessage = "usage: java " + programName;
			for(int i = 0; i < namedArgumentList.size(); i++) {
				NamedArgument currentArg = namedArgumentList.get(i);
				errorMessage += " " + currentArg.getName();   
			}
			
			NamedArgument currentArg = namedArgumentList.get(incorrectDataTypeIndex); 
			errorMessage += "\n" + programName + ".java: error: argument " + currentArg.getName() + ": invalid "+ currentArg.getType() + " value: " + currentArg.getValue();
			return errorMessage; 
		}  	
    }
   
   private String incorrectNumberOfArgsMessage(ArrayList<String> argList){
   		int numOfArgs = positionalArgumentList.size();
   		if(argList.size() < numOfArgs){
            String message = "usage: java " + programName;
            for(int i = 0; i < positionalArgumentList.size(); i++) {
            	PositionalArgument currentArg = positionalArgumentList.get(i);
                message += " " + currentArg.getName();   
            }
            
            message += "\n" + programName + ".java: error: the following arguments are required:";
            //int numOfArgsMissing = numOfArgs - args.length;
            
            for(int j = argList.size(); j < numOfArgs; j++){
            	PositionalArgument currentArg = positionalArgumentList.get(j);
            	message += " " + currentArg.getName();
            }
            
   			return message;
   		}
        
   		else {
   			String message = "usage: java " + programName;
            for(int i = 0; i < positionalArgumentList.size(); i++) {
            	PositionalArgument currentArg = positionalArgumentList.get(i);
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
    
    private String helpMessage(){ //update the help message to print out all options, not just positional
		String helpMessage = "usage: java " + programName;
		for(int i = 0; i < positionalArgumentList.size(); i++) {
			PositionalArgument currentArg = positionalArgumentList.get(i);
			helpMessage += " " + currentArg.getName();   
		}
        
		helpMessage += "\n" + programDescription + "\npositional arguments:";
		
        for(int i = 0; i < positionalArgumentList.size(); i++) {
			PositionalArgument currentArg = positionalArgumentList.get(i);
			helpMessage += "\n" + currentArg.getName() + " " + currentArg.getDescription();   
		}

		return helpMessage;
    }
    
   
    
    private ArrayList<String> getPositionalArgs(String[] args){
    	ArrayList<String> posArgList = new ArrayList<String>(); 
    	for(int i = 0; i < args.length; i++){ //going through args from CLI
    		if(!args[i].startsWith("-") && i == 0){ //test if the first arg is a positional arg
    			posArgList.add(args[i]);
    		}
    		else if(!args[i].startsWith("-")){ //arg from CLI doesn't have a dash
    			if(!args[i-1].startsWith("-")){ //if the one before it doesn't have a dash, then it's a pos arg
    				posArgList.add(args[i]);
    			}
    			else{ //the arg before it has a dash
    				String[] tempNamedArg = new String[2];
    				if(args[i-1].startsWith("--")){ //arg before it is in long form
    					tempNamedArg = args[i-1].split("--");
    					for(int j = 0; j < namedArgumentList.size(); j++){ //go through all named args
    						NamedArgument currentNamedArg = namedArgumentList.get(j);
    						if(currentNamedArg.getName().equals(tempNamedArg[1])) {
								if(currentNamedArg.getType().equals("boolean")){ //if long form arg is boolean, still need to add arg after to pos args
									posArgList.add(args[i]);
								}
							}
    					}
    				}
    				else{ //arg before it is in short form
    					tempNamedArg = args[i-1].split("-");
						if(tempNamedArg[1].length() == 1){ //single char
							for(int j = 0; j < namedArgumentList.size(); j++){ //go through all named args
								NamedArgument currentNamedArg = namedArgumentList.get(j);
								if(Character.toString(currentNamedArg.getShortFormName()).equals(tempNamedArg[1])) {
									if(currentNamedArg.getType().equals("boolean")){ //if short form arg is boolean, still need to add arg after to pos args
										posArgList.add(args[i]);
									}
								}
							}
						}
						else{ //multiple flags in one specification, must be boolean so add arg after it to pos args
							posArgList.add(args[i]);
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
					NamedArgument currentNamedArg = namedArgumentList.get(k);
					if(tempNamedArg[1].length() == 1){ //single char
						if(Character.toString(currentNamedArg.getShortFormName()).equals(tempNamedArg[1])){
							if(!currentNamedArg.getType().equals("boolean")){
								currentNamedArg.setValue(args[i+1]);
							}
							else{
								currentNamedArg.setValue("true");
							}
						}
					}
					else{ //multiple flags in one specification
						for(int j = 0; j < tempNamedArg[1].length(); j++){
							if(currentNamedArg.getShortFormName() == tempNamedArg[1].charAt(j)){
								currentNamedArg.setValue("true");
							}
						}
					}
				}
			}
		}
	}
	String invalidNamedArgument = ""; //used in invalidNamedArgument and argumentDoesNotExistMessage
	
	private void invalidNamedArgument(String[] args) throws ArgumentDoesNotExistException{
		for(int i = 0; i < args.length; i++){
			if(args[i].startsWith("--")){
				String[] splitLongNamedArg = new String[2];
				splitLongNamedArg = args[i].split("--");
				NamedArgument tempArg = getNamedArgument(splitLongNamedArg[1]);
				if(tempArg == null){
					invalidNamedArgument = splitLongNamedArg[1];
					throw new ArgumentDoesNotExistException(argumentDoesNotExistMessage(invalidNamedArgument));
				}
			}
			else if(args[i].startsWith("-")){
				String[] splitShortNamedArg = new String[2];
				splitShortNamedArg = args[i].split("-");
				if(splitShortNamedArg[1].length() == 1){ //single char
					NamedArgument tempArg = getNamedArgument(splitShortNamedArg[1].charAt(0));
					if(tempArg == null){
						invalidNamedArgument = splitShortNamedArg[1];
						throw new ArgumentDoesNotExistException(argumentDoesNotExistMessage(invalidNamedArgument));
					}
				}
				else{ //multiple flags in one specification
					for(int k = 0; k < splitShortNamedArg[1].length(); k++){
						NamedArgument tempArg = getNamedArgument(splitShortNamedArg[1].charAt(k));
						if(tempArg == null){
							invalidNamedArgument = Character.toString(splitShortNamedArg[1].charAt(k));
							throw new ArgumentDoesNotExistException(argumentDoesNotExistMessage(invalidNamedArgument));
						}
					}
				}
			}
		}
	}
	
	private String argumentDoesNotExistMessage(String invalidNamedArgument){
		String message = "usage: java " + programName;
		for(int i = 0; i < positionalArgumentList.size(); i++) {
			PositionalArgument currentArg = positionalArgumentList.get(i);
            message += " " + currentArg.getName();   
        }
        
        message += "\n" + programName + ".java: error: argument " + invalidNamedArgument + " does not exist";
        
    	return message;
	}
	
	public void parse(String[] args) throws HelpException, IncorrectNumberOfArgsException, IncorrectArgTypeException, ArgumentDoesNotExistException{
		ArrayList<String> tempPositionalArgList = getPositionalArgs(args);
		
		setLongFormNamedArgValues(args);
		setShortFormNamedArgValues(args);
		invalidNamedArgument(args); //throws ArgumentDoesNotExistException
		
        NamedArgument helpArgument = getNamedArgument("help");
        if (helpArgument != null){
			String helpArgValue = helpArgument.getValue();
			if (helpArgValue.equals("true")){
				throw new HelpException(helpMessage());
			}
        }
        
		if (positionalArgumentList.size() != tempPositionalArgList.size()){
				throw new IncorrectNumberOfArgsException(incorrectNumberOfArgsMessage(tempPositionalArgList));
		}
		else if (positionalArgumentList.size() == tempPositionalArgList.size()){
			for(int i = 0; i < tempPositionalArgList.size(); i++){
   				PositionalArgument currentArg = positionalArgumentList.get(i);
   				currentArg.setValue(tempPositionalArgList.get(i));
   			}
			try{
				parseDataType(tempPositionalArgList);
			}
			catch (Exception e){
				throw new IncorrectArgTypeException(incorrectDataTypeMessage(tempPositionalArgList));
			}
		}	
	}
}










