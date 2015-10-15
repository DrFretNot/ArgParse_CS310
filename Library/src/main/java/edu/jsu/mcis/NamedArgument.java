package edu.jsu.mcis;

public class NamedArgument{
    
    private String argName;
    private String description;
    private Library.argType type;
    private String value;

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
    
	public String getName(){
		return argName;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getType(){
    	if(type == Library.argType.INTEGER){
    		return "integer";
    	}
    	else if(type == Library.argType.FLOAT){
    		return "float";
    	}
    	else if(type == Library.argType.STRING){
    		return "string";
    	}
    	else return "boolean";
	}
	
	public String getDescription(){
		return description;
	}


}