package edu.jsu.mcis;

/**
 *
 *Argument is an abstract class that includes argument name, description, value set, value and argument type. If not specified, the type defaults to string and description defaults to an empty string. 
 *
 */
public abstract class Argument
{
	protected String argName;
    protected String description;
    protected ArgType type;
    protected String value;
    protected String[] valueSet = {""};
    
    public enum ArgType {INTEGER, FLOAT, STRING, BOOLEAN};
    
    /**
     *Initializes an argument object with the specified  <b>name</b>, <b>ArgType</b>, <b>dataType</b>, and <b>argDescription</b>
     *@param name  the name to be set for the argument object
     *@param dataType the dataType to be set for the argument object
     *@param argDescription the description for each argument object
     *
    */
    public Argument(String name, ArgType dataType, String argDescription){
    	argName = name;
        description = argDescription;
        type = dataType;
        
    }
    
     /**
     *Initializes an argument object with the specified <b>name</b>, <b>dataType</b>, and default desctiption. 
     *@param name  the name to be set for the argument object
     *@param dataType the dataType to be set for the argument object
     *
     *
    */
    public Argument(String name, ArgType dataType){
    	
        this(name, dataType, "");
    }
     /**
     *Initializes an argument object with the specified <b>name</b>, <b>argDescription</b> and the default type.
     *@param name  the name to be set for the argument object
     *@param argDescription the description for each argument object
     *
    */
    public Argument(String name, String argDescription){
    	
        this(name, ArgType.STRING, argDescription);
    }
    
     /**
     *Initializes an argument object with only the specified <b>name</b>.
     *@param name  the name to be set for the argument object
     *
    */
    public Argument(String name){
    	
        this(name, ArgType.STRING, "");
    }
    /**
     *
     *Returns the name of an argument object. 
     *
     *
    */
    public abstract String getName();
    
    /**
     *
     *Returns the type of an argument object.
     *
     *
    */
    public abstract String getType();
    
    /**
     *
     *Returns the description of an argument object.
     *
     *
    */
    public abstract String getDescription();
    
    /**
     *
     *Returns the value set of an argument object.
     *
     *
    */
    public abstract String[] getValueSet();
    
    
    /**
     *
     *Returns the value of an argument object.
     *
     *
    */
    public abstract <T> T getValue();
    
    
    /**
     *
     *Sets the value of an argument object.
     *@param argValue the string representation of the value to be set for the argument object
     *
    */
    public abstract void setValue(String argValue);
}