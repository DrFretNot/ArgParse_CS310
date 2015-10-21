package edu.jsu.mcis;

public class NamedArgument extends Argument{
    
   private char shortFormName;

	/*
	constructors
	
	HAVE
	name
	name	defaultValue
	name	dataType
	name	defaultValue	dataType
	name	defaultValue	argDescription
	name	dataType		argDescription
	name	defaultValue	dataType 		argDescription
	name	shortForm
	
	NEED(?)
	name	argDescription
	name	defaultValue	shortForm
	name	dataType		shortForm
	name	defaultValue	dataType		shortForm
	name	defaultValue	argDescription	shortForm
	name	dataType		argDescription	shortForm
	name	defaultValue	dataType 		argDescription	shortForm
	
	*/

    public NamedArgument(String name){
        argName = name;
        description = "";
        type = Library.argType.STRING;
        value = null;  
    }  
    public NamedArgument(String name, String defaultValue){
        argName = name;
        description = "";
        type = Library.argType.STRING;
        value = defaultValue;  
    }              
	public NamedArgument(String name, Library.argType dataType){
        argName = name;
        description = "";
        type = dataType;
        value = null;  
    }  
    public NamedArgument(String name, String defaultValue, Library.argType dataType){
        argName = name;
        description = "";
        type = dataType;
        value = defaultValue;  
    }  
    public NamedArgument(String name, String defaultValue, String argDescription){
        argName = name;
        description = argDescription;
        type = Library.argType.STRING;
        value = defaultValue;  
    }    	
	public NamedArgument(String name, Library.argType dataType, String argDescription){
        argName = name;
        description = argDescription;
        type = dataType;
        value = null;  
    }
    public NamedArgument(String name, String defaultValue, Library.argType dataType, String argDescription){
        argName = name;
        description = argDescription;
        type = dataType;
        value = defaultValue;  
    }
    
	public  NamedArgument(String name, char shortForm){
		argName = name;
        description = "";
        type = Library.argType.STRING;
        value = null;
        shortFormName = shortForm;
	}	





	public char getShortForm(){
		return shortFormName;
	}


}