package edu.jsu.mcis;

/**
 *
 *Argument This is a parent class to the argument name, description, type value set, and argument type
 *
 */
public abstract class Argument
{
	protected String argName;
    protected String description;
    protected ArgType type;
    protected String[] valueSet = {""};
    
    public enum ArgType {INTEGER, FLOAT, STRING, BOOLEAN};
    
    /**
     *
     *@param Argument initiates argName, description, and type. 
     *
     */
    /*public Argument(){
        argName = null;
        description = "";
        type = null;
        
    }*/
    
    /**
     *
     *@param Argument Contructor for different combinations such as <b>name</b>, <b>ArgType</b>, <b>dataType</b>, and <b>argDescription</b> 
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
     *@param Argument Contructor for different combinations such as <b>name</b>, <b>ArgType</b>, <b>dataType</b>, and <b>argDescription</b> 
     *
     *
    */
    public Argument(String name, ArgType dataType){
    	
        this(name, dataType, "");
    }
     /**
     *
     *@param Argument Contructor for different combinations such as <b>name</b>, and <b>argDescription</b> 
     *
     *
    */
    public Argument(String name, String argDescription){
    	
        this(name, ArgType.STRING, argDescription);
    }
    
     /**
     *
     *@param Argument Contructor for different combinations such as <b>name</b>, only.
     *
     *
    */
    public Argument(String name){
    	
        this(name, ArgType.STRING, "");
    }
    /**
     *
     *@param getName Common method which will be defined in child classes
     *
     *
    */
    public abstract String getName();
    
    /**
     *
     *@param getType Common method which will be defined in child classes.
     *
     *
    */
    public abstract String getType();
    
    /**
     *
     *@param getDescription Common method which will be defined in child classes.
     *
     *
    */
    public abstract String getDescription();
    
    /**
     *
     *@param getValueSet Common method which will be defined in child classes.
     *
     *
    */
    public abstract String[] getValueSet();
    
    
}