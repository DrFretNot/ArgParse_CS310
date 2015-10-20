package edu.jsu.mcis;

public class NamedArgument extends Argument{
    
   

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
    
	


}