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
     *
     *@param Argument Initializes an argument object with the specified  <b>name</b>, <b>ArgType</b>, <b>dataType</b>, and <b>argDescription</b> 
     *
     *
    */
    public Argument(String name, ArgType dataType, String argDescription){
    	argName = name;
        description = argDescription;
        type = dataType;
        
    }
    
     /**
     *
     *@param Argument Initializes an argument object with the specified <b>name</b>, <b>dataType</b>, and default desctiption.  
     *
     *
    */
    public Argument(String name, ArgType dataType){
    	
        this(name, dataType, "");
    }
     /**
     *
     *@param Argument Initializes an argument object with the specified <b>name</b>, <b>argDescription</b> and the default type.
     *
     *
    */
    public Argument(String name, String argDescription){
    	
        this(name, ArgType.STRING, argDescription);
    }
    
     /**
     *
     *@param Argument Initializes an argument object with only the specified <b>name</b>.
     *
     *
    */
    public Argument(String name){
    	
        this(name, ArgType.STRING, "");
    }
    /**
     *
     *@param getName Returns the name of an argument object. 
     *
     *
    */
    public abstract String getName();
    
    /**
     *
     *@param getType Returns the type of an argument object.
     *
     *
    */
    public abstract String getType();
    
    /**
     *
     *@param getDescription Returns the description of an argument object.
     *
     *
    */
    public abstract String getDescription();
    
    /**
     *
     *@param getValueSet Returns the value set of an argument object.
     *
     *
    */
    public abstract String[] getValueSet();
    
    
    /**
     *
     *@param getValue Returns the value of an argument object.
     *
     *
    */
    public abstract <T> T getValue();
    
    
    /**
     *
     *@param setValue Sets the value of an argument object.
     *
     *
    */
    public abstract void setValue(String argValue);
}