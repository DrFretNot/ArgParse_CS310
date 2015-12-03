/**
 @author Katie Wood
 @author Trent Ford 
 @author Andrew Green
 @author Sinh Nguyen
 @author Robert Warren
 @version 1.04 Build firebolt 9001 Nov 9, 2015.
 Argument Parser is a user-friendly library for taking in command line arguments
 and returning their user specified values. The user defines what arguments are 
 required. Then the program will parse command line info, and will automatically 
 genreate help, useage, and error messages when the program is given program 
 invalid arguments.
  
 */

package edu.jsu.mcis;

import java.util.*;
import java.lang.Object.*;
import java.io.*;


/**
 *
 *<h2> 
 *<span style="color:#4c6b87">
 
 *
 *</h2>
 *
 *<p>The ArgParse_CS310 module make it easy to write user-friendly 
 *command-line interfaces. The program defines what arguments is 
 *requires, and argparse will figure out how to parse those arguments. 
 *The argparse module also automatically generates help and 
 *usage messages and issues error codes when users 
 *give program invalid arguments.</p>
 *
 *@param  url  an absolute URL giving the base location of the image
 *@param  name the location of the image, relative to the url argument
 *
 */
public class ArgumentParser {
	
	private List<NamedArgument> namedArgumentList; //hashmap, key would be the name of the argument
	//if short form is given from CLI, need to search for the name then find it in the map
    private List<PositionalArgument> positionalArgumentList;
    private String programName = "";
    private String programDescription = "";
    private int posCount;
    
    
/**
  <pre>
 *<span style="color:#4c6b87">
 *Instantiates a new instance of the Argument Parser. 
 *
 *}
 *
 */    
    public ArgumentParser(){
		this.programName = "";
        this.programDescription = "";
        this.positionalArgumentList = new ArrayList<PositionalArgument>();
        this.namedArgumentList = new ArrayList<NamedArgument>(); 
		posCount = -1;
	}
	
    /**
     **<pre>
     *<span style="color:#4c6b87">
     *Takes an input string and sets it as the program name
     *@param inputProgramName the string to be set as the program name
     *
     *
     */ 
	public void addProgramName(String inputProgramName){
        programName = inputProgramName;       
    }
    
    /**
     *Takes an input string and sets it as the program description
     *@param inputProgramDescription the string to be set as the program description
     *
     *
     *
     *
    */
    public void addProgramDescription(String inputProgramDescription){
        programDescription = inputProgramDescription;       
    }
    
    /** 
     *Return the name of program that was specified by the user
     *@return programName the name of the program
     */
    public String getProgramName(){
        return programName;   
    }
    /**
     *Returns the description of the program set by the user
     *@return the specificed string description of the program
     */
    
    public String getProgramDescription(){
        return programDescription;   
    }
    
    /** 
     *Adds a new positional argument to be parsed from the command line
     *@param arg a new instance of a positional argument
     *If a positional argument is not supplied, the program should exit, and the usage information should be displayed along with the error stating the missing argument.
     *If an additional (i.e., one too many) positional argument is specified, then the program should exit, and the usage information should be displayed along with the error stating the additional argument.
     
     */
    public void addPositionalArgument(PositionalArgument arg){
    	posCount++;
    	arg.setPosition(posCount);
    	positionalArgumentList.add(arg);
    }
    
    /**
     *Adds a new named argument to be parsed from the command line
     *@param arg a new instance of a named argument
     *
     *
     */
    public void addNamedArgument(NamedArgument arg){ 
    	namedArgumentList.add(arg);
    }
    
    /** 
     *Returns the positional argument with the specified string name
     *@param argName the name of the positional argument to return
     *@return the positional argument with the specified name
     *
     *
     */
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
    
    /**
     *Returns the positional argument at the specified position where argPosition starts at 1
     *@Param argPosition the integer position of the positional argument to find 
     *@return the positional argument with the specified position, position starts at index 1
     *
     *
     */
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
    
    /**
     *Returns the named argument with the specified string name
     *@param argName the specified string name
     *@return the named argument with the specified string name
     */
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
    
    /**
     *
     *<h2> 
     *Use Cases: 
     *</h2>
     **<pre>
     *<span style="color:#4c6b87">
     *{@code
     *public NamedArgument getNamedArgument(char argShortFormName){
    	NamedArgument returnArg = null;
    	for(int i = 0; i < namedArgumentList.size(); i++){
    		NamedArgument currentArg = namedArgumentList.get(i);
    		if(currentArg.getShortFormName() == argShortFormName){
    			returnArg = currentArg;
    		}
    	} 
     
     *}
     *</pre>
     *Returns the named argument with the specified character short form name
     *@param argShortFormName the specified character short form name
     *@return the named argument with the specified char short form name
     */
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
    
    //used in parseDataType 
    private Boolean parseBool(String arg) throws NumberFormatException{
    	String newArg = arg.toLowerCase();
    	if(newArg.equals("true")){
    		return true;
    	}
    	else if(newArg.equals("false")){
    		return false;
    	}
    	else{
    		throw new NumberFormatException();
    	}
    }
    
    private String usageMessage(){
    	String message = "usage: java " + programName + " required:";
		for(int i = 0; i < positionalArgumentList.size(); i++) {
			PositionalArgument currentArg = positionalArgumentList.get(i);
			message += " " + currentArg.getName();   
		}
		return message;
    }
    
 	//used in parseDataType, setLongFormNamedArgValues, setShortFormNamedArgValues, and incorrectDataTypeMessage
    int incorrectDataTypeIndex;
    String incorrectArgumentType; 
    
    private void parseDataType(ArrayList<String> argList) throws NumberFormatException{
        
        //checking positional args
		for (int index = 0; index < argList.size(); index++){
			incorrectDataTypeIndex = index;
			incorrectArgumentType = "positional";
			PositionalArgument currentArg = positionalArgumentList.get(index);
			if (currentArg.getType().equals("integer")){
				int argValue = Integer.parseInt(argList.get(index));
				currentArg.setValue(argList.get(index));
				//currentArg.setValue(argValue);
			}
            
			else if (currentArg.getType().equals("float")){
				float argValue = Float.parseFloat(argList.get(index));
				currentArg.setValue(argList.get(index));
			}
            
			else if (currentArg.getType().equals("string")){
				String argValue = argList.get(index);
				currentArg.setValue(argValue);
			}
			
			else{
				Boolean argValue = parseBool(argList.get(index));
				currentArg.setValue(argList.get(index));
			}
		}
    }
    
    private String incorrectDataTypeMessage(ArrayList<String> argList){
		String errorMessage = this.usageMessage();
		
		if (incorrectArgumentType.equals("positional")){
			PositionalArgument currentArg = positionalArgumentList.get(incorrectDataTypeIndex); 
			errorMessage += "\n" + programName + ".java: error: argument " + currentArg.getName() + ": invalid "+ currentArg.getType() + " value: " + argList.get(incorrectDataTypeIndex);
			return errorMessage;  
		}
		else {
			NamedArgument currentArg = namedArgumentList.get(incorrectDataTypeIndex); 
			errorMessage += "\n" + programName + ".java: error: argument " + currentArg.getName() + ": invalid "+ currentArg.getType() + " value: " + incorrectArgValueForSpecifiedDataType;
			return errorMessage; 
		}  	
    }
   
   private String incorrectNumberOfArgsMessage(ArrayList<String> argList){
   		int numOfArgs = positionalArgumentList.size();
   		if(argList.size() < numOfArgs){
            String message = this.usageMessage();
            
            message += "\n" + programName + ".java: error: the following arguments are required:";
            
            for(int j = argList.size(); j < numOfArgs; j++){
            	PositionalArgument currentArg = positionalArgumentList.get(j);
            	message += " " + currentArg.getName();
            }
            
   			return message;
   		}
        
   		else {
            String message = this.usageMessage();
            
            message += "\n" + programName + ".java: error: unrecognized arguments:";
            
            for(int j = numOfArgs; j < argList.size(); j++){
            	message += " " + argList.get(j);
            }
   			return message;
   		}
   }
    
    private String helpMessage(){
		String helpMessage = this.usageMessage();
		
        /*for(int i = 0; i < namedArgumentList.size(); i++){
        	NamedArgument namedArg = namedArgumentList.get(i);
        	helpMessage += " [" + namedArg.getName() + "]";
        }*/
		helpMessage += "\n" + programDescription + "\npositional arguments:";
		
        for(int i = 0; i < positionalArgumentList.size(); i++) {
			PositionalArgument currentArg = positionalArgumentList.get(i);
			helpMessage += "\n[" + currentArg.getName() + "] (" + currentArg.getType() + ") " + currentArg.getDescription();   
		}
		
		helpMessage += "\nnamed arguments:";
		
		for(int i = 0; i < namedArgumentList.size(); i++) {
			NamedArgument currentArg = namedArgumentList.get(i);
			helpMessage += "\n[--" + currentArg.getName() + "] [-" + currentArg.getShortFormName() + "] (" + currentArg.getType() + ") " + currentArg.getDescription() + " (optional)";   
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
    			else{ 
    				String[] tempNamedArg = new String[2];
    				if(args[i-1].startsWith("--")){ 
    					tempNamedArg = args[i-1].split("--");
    					for(int j = 0; j < namedArgumentList.size(); j++){ //g
    						NamedArgument currentNamedArg = namedArgumentList.get(j);
    						if(currentNamedArg.getName().equals(tempNamedArg[1])) {
								if(currentNamedArg.getType().equals("boolean")){  //to pos args
									posArgList.add(args[i]);
								}
							}
    					}
    				}
    				else{ 
    					tempNamedArg = args[i-1].split("-");
						if(tempNamedArg[1].length() == 1){ 
							for(int j = 0; j < namedArgumentList.size(); j++){ 
								NamedArgument currentNamedArg = namedArgumentList.get(j);
								if(Character.toString(currentNamedArg.getShortFormName()).equals(tempNamedArg[1])) {
									if(currentNamedArg.getType().equals("boolean")){ 
										posArgList.add(args[i]);
									}
								}
							}
						}
						else{
							posArgList.add(args[i]);
						}
    				}
    			}
    		}
    	}
    	return posArgList;
    }
    
    //used in incorrectDataTypeMessage
    String incorrectArgValueForSpecifiedDataType;
    
    private void setLongFormNamedArgValues(String[] args) throws NumberFormatException{
    	for(int i = 0; i < args.length; i++){
    		String[] tempNamedArg = new String[2];
    		if(args[i].startsWith("--")){
    			tempNamedArg = args[i].split("--");
    			for(int j = 0; j < namedArgumentList.size(); j++){
    				incorrectDataTypeIndex = j;
    				incorrectArgumentType = "named";
    				NamedArgument currentArg = namedArgumentList.get(j);
    				if(currentArg.getName().equals(tempNamedArg[1])){
    					if(!currentArg.getType().equals("boolean")){
    						incorrectArgValueForSpecifiedDataType = args[i+1];
    						if (currentArg.getType().equals("integer")){
								int argValue = Integer.parseInt(args[i+1]);
								currentArg.setValue(args[i+1]);
							}
			
							else if (currentArg.getType().equals("float")){
								float argValue = Float.parseFloat(args[i+1]);
								currentArg.setValue(args[i+1]);
							}
			
							else if (currentArg.getType().equals("string")){
								currentArg.setValue(args[i+1]);
							}
    					}
    					else{
    						currentArg.setValue("true");
    					}
    				}
    			}
    		}
    	}
    }
    private void setShortFormNamedArgValues(String[] args) throws NumberFormatException{
		for(int i = 0; i < args.length; i++){
			String[] tempNamedArg = new String[2];
			if(args[i].startsWith("-")){
				tempNamedArg = args[i].split("-");
				for(int k = 0; k < namedArgumentList.size(); k++){
					incorrectDataTypeIndex = k;
					incorrectArgumentType = "named";
					NamedArgument currentNamedArg = namedArgumentList.get(k);
					if(tempNamedArg[1].length() == 1){ //single char
						if(Character.toString(currentNamedArg.getShortFormName()).equals(tempNamedArg[1])){
							if(!currentNamedArg.getType().equals("boolean")){
								incorrectArgValueForSpecifiedDataType = args[i+1];	
								if (currentNamedArg.getType().equals("integer")){
									int argValue = Integer.parseInt(args[i+1]);
									currentNamedArg.setValue(args[i+1]);
								}
			
								else if (currentNamedArg.getType().equals("float")){
									float argValue = Float.parseFloat(args[i+1]);
									currentNamedArg.setValue(args[i+1]);
								}
			
								else if (currentNamedArg.getType().equals("string")){
									currentNamedArg.setValue(args[i+1]);
								}
    					
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
	String invalidNamedArgument = "";
	
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
				else{
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
	
	
	private void parseNamedArgumentValues(List<NamedArgument> namedArgList) throws IncorrectArgumentValueException{
		for(int i = 0; i < namedArgList.size(); i++){
			NamedArgument currentArg = namedArgList.get(i);
			String errorArg = currentArg.getName();
			String[] valueSet = currentArg.getValueSet();
			if(!valueSet[0].equals("")){
				Boolean valueSetContainsArgValue = false;
				String errorValue = "";
				for(int j = 0; j < valueSet.length; j++){
					if(currentArg.getType().equals("integer")){
						int intValue = (Integer)currentArg.getValue();
						if(valueSet[j].equals(Integer.toString(intValue))){
							valueSetContainsArgValue = true;
						}
						errorValue = Integer.toString(intValue);
					}
					else if(currentArg.getType().equals("float")){
						float floatValue = (Float)currentArg.getValue();
						if(valueSet[j].equals(Float.toString(floatValue))){
							valueSetContainsArgValue = true;
						}
						errorValue = Float.toString(floatValue);
					}
					else if(currentArg.getType().equals("string")){
						String stringValue = (String)currentArg.getValue();
						if(valueSet[j].equals(stringValue)){
							valueSetContainsArgValue = true;
						}
						errorValue = stringValue;
					}
					/*else{
						Boolean boolValue = (Boolean)currentArg.getValue();
						if(valueSet[j].equals(boolValue)){
							valueSetContainsArgValue = true;
						}
						errorValue = Boolean.toString(boolValue);
					}*/
				}
				if(!valueSetContainsArgValue){
					throw new IncorrectArgumentValueException(incorrectArgumentValueMessage(errorArg, errorValue));
				}
			}
		}
	}
	
	private void parsePositionalArgumentValues(List<PositionalArgument> posArgList) throws IncorrectArgumentValueException{
		for(int i = 0; i < posArgList.size(); i++){
			PositionalArgument currentArg = posArgList.get(i);
			String errorArg = currentArg.getName();
			String[] valueSet = currentArg.getValueSet();
			if(!valueSet[0].equals("")){
				Boolean valueSetContainsArgValue = false;
				String errorValue = "";
				for(int j = 0; j < valueSet.length; j++){
					if(currentArg.getType().equals("integer")){
						int intValue = (Integer)currentArg.getValue();
						if(valueSet[j].equals(Integer.toString(intValue))){
							valueSetContainsArgValue = true;
						}
						errorValue = Integer.toString(intValue);
					}
					else if(currentArg.getType().equals("float")){
						float floatValue = (Float)currentArg.getValue();
						if(valueSet[j].equals(Float.toString(floatValue))){
							valueSetContainsArgValue = true;
						}
						errorValue = Float.toString(floatValue);
					}
					else if(currentArg.getType().equals("string")){
						String stringValue = (String)currentArg.getValue();
						if(valueSet[j].equals(stringValue)){
							valueSetContainsArgValue = true;
						}
						errorValue = stringValue;
					}
					/*else{
						Boolean boolValue = (Boolean)currentArg.getValue();
						if(valueSet[j].equals(Boolean.toString(boolValue))){
							valueSetContainsArgValue = true;
						}
						errorValue = Boolean.toString(boolValue);
					}*/
					
				}
				if(!valueSetContainsArgValue){
					throw new IncorrectArgumentValueException(incorrectArgumentValueMessage(errorArg, errorValue));
				}
			}
		}
	}
	
	private String incorrectArgumentValueMessage(String argName, String argValue){
		String message = this.usageMessage();
		
		message += "\n" + programName + ".java: error: argument " + argName + ": invalid value: " + argValue;
		return message;
	}
	
	private String argumentDoesNotExistMessage(String invalidNamedArgument){
        String message = this.usageMessage();
        
        message += "\n" + programName + ".java: error: argument " + invalidNamedArgument + " does not exist";
        
    	return message;
	}
    
	/**
     *
     *<span style="color:#4c6b87">
     *{@code
     *if (helpArgValue.equals("true")){
				throw new HelpException(helpMessage());
			}
     *
     *}
     
     *</pre>
     *Parses input data from the command line and throws the correct exceptions if tinput data is an incorrect format
     *@param args the input data from the command line
     *@throws HelpException if the help argument is given in the input data 
     *@throws IncorrectNumberOfArgsException if an incorrect number of positional arguments is given in the input data
     *@throws IncorrectArgTypeException if an input argument is given as the wrong dataType specified by the user
     *@throws ArgumentDoesNotExistException if a named argument is given in the input data that has not been created by the user
     *@throws IncorrectArgumentValueException if the input data is not a possible value for a specified argument
     */
    
	public void parse(String[] args) throws HelpException, IncorrectNumberOfArgsException, IncorrectArgTypeException, ArgumentDoesNotExistException, IncorrectArgumentValueException{
		ArrayList<String> tempPositionalArgList = getPositionalArgs(args);
		
		try{
			setLongFormNamedArgValues(args);
			setShortFormNamedArgValues(args);
		}
		catch(Exception e){
			throw new IncorrectArgTypeException(incorrectDataTypeMessage(tempPositionalArgList));
		}
		
		invalidNamedArgument(args); //throws ArgumentDoesNotExistException
		
        NamedArgument helpArgument = getNamedArgument("help");
        if (helpArgument != null){
			Boolean helpArgValue = (Boolean)helpArgument.getValue();
			if (helpArgValue){
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
			parseNamedArgumentValues(namedArgumentList); //throws IncorrectArgumentValueException
			parsePositionalArgumentValues(positionalArgumentList); //throws IncorrectArgumentValueException
		}	
	}
    
    /**
     *Writes argument parser information to the specified XML file. The program name, program description, positional arguments, and named arguments 
     *are saved in the file in standard XML format. It also saves each aspect of the arguments such as argument name, description, dataType, defaultValue, and possible value set.
     *@param fileName the XML file to which all information will be written
     *<pre>
     *<h2>
     * Use Cases:
     *</h2>
     *Assume VolumeCalculator.java allows for three positional arguments, named <b><font color = "#4c6b87">length</font></b>, <b><font color= 
     *"#4c6b87">width</font></b>, and <b><font color = "#4c6b87">height</font></b>, respectively, 
     *each representing float values. Assume that it also allows two optional named arguments: type, 
     *a string that defaults to "box" with short-form t, and digits, an integer that defaults to 4 
     *with short-form d.
     *
     *
     </pre>
     *
     */
	
	public void writeToXMLFile(String fileName){
		File outputFile = new File(fileName);
		try{
			PrintWriter outputFileWriter = new PrintWriter(outputFile);
			outputFileWriter.println("<?xml version=" + "\"1.0\"?>");
			outputFileWriter.println("<program>");
				outputFileWriter.println("<name>" + getProgramName() + "</name>");
				outputFileWriter.println("<description>" + getProgramDescription() + "</description>");
				outputFileWriter.println("<arguments>");
			
				for(int i = 0; i < positionalArgumentList.size(); i++){
					PositionalArgument posArg = positionalArgumentList.get(i);
					outputFileWriter.println("<positional>");
						outputFileWriter.println("<name>" + posArg.getName() + "</name>");
						outputFileWriter.println("<type>" + posArg.getType() + "</type>");
						outputFileWriter.println("<description>" + posArg.getDescription() + "</description>");
						outputFileWriter.println("<position>" + (posArg.getPosition() + 1) + "</position>"); //prints position starting at 1
						String[] valueSet = posArg.getValueSet();
						if(!valueSet[0].equals("")){
							String line = "<valueset>";
							
							line += valueSet[0];
							for(int j = 1; j < valueSet.length; j++){
								line += "," + valueSet[j];
							}
							line += "</valueset>";	
							outputFileWriter.println(line);
						}
						//outputFileWriter.println(line);
					outputFileWriter.println("</positional>");
				}
				
				for (int j = 0; j < namedArgumentList.size(); j++){
					NamedArgument namedArg = namedArgumentList.get(j);
					outputFileWriter.println("<named>");
						outputFileWriter.println("<name>" + namedArg.getName() + "</name>");
						outputFileWriter.println("<shortname>" + namedArg.getShortFormName() + "</shortname>");
						outputFileWriter.println("<type>" + namedArg.getType() + "</type>");
						outputFileWriter.println("<description>" + namedArg.getDescription() + "</description>");
						outputFileWriter.println("<default>" + namedArg.getDefaultValue() + "</default>");
						String[] valueSet = namedArg.getValueSet();
						if(!valueSet[0].equals("")){
							String line = "<valueset>";
							line += valueSet[0];
							for(int k = 1; k < valueSet.length; k++){
								line += "," + valueSet[k];
							}
							line += "</valueset>";	
							outputFileWriter.println(line);
						}
					outputFileWriter.println("</named>");
				}
				
				outputFileWriter.println("</arguments>");
			outputFileWriter.println("</program>");
			
			outputFileWriter.close();
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		}
	}
}










