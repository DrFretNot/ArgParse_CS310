package edu.jsu.mcis;

public abstract class Argument
{
	protected String argName;
    protected String description;
    protected ArgType type;
    protected String value;
    public enum ArgType {INTEGER, FLOAT, STRING, BOOLEAN};
    
    public Argument(){
        argName = null;
        description = "";
        type = null;
        value = null;
        //position = -1;
    }
    
    public Argument(String name){
    	/*argName = name;
        description = "";
        type = ArgType.STRING;
        value = null;*/
        this(name, ArgType.STRING, "");
    }
    
    public Argument(String name, ArgType dataType){
    	/*argName = name;
        description = "";
        type = dataType;
        value = null;*/
        this(name, dataType, "");
    }
    
    public Argument(String name, String argDescription){
    	/*argName = name;
        description = argDescription;
        type = ArgType.STRING;
        value = null;*/
        this(name, ArgType.STRING, argDescription);
    }
    
    public Argument(String name, ArgType dataType, String argDescription){
    	argName = name;
        description = argDescription;
        type = dataType;
        value = null;
    }
    
    //public Argument(){};
    
}