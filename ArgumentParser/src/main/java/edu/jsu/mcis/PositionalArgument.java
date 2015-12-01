package edu.jsu.mcis;

/**
*
*Class positional argument creates a required argument to be read from the command line in a specified order. It includes position, argument name, description, value set, value and argument type. If not specified, the type defaults to a string and description defaults to an empty string.
*
*/
public class PositionalArgument extends Argument{

	private int position = -1;
    
    /**
    *Initializes a positional argument object with only the specified <b>name</b>.
    *@param name String to be set as <b>name</b>.   
    *
    *
    */
    public PositionalArgument(String name){
        super(name);
    }
    
    /**
    *
    *@param PositionalArgument Initializes a positional argument object with the specified <b>name</b>, <b>dataType</b>, and default desctiption.
    *
    *
    */
    public PositionalArgument(String name, ArgType dataType){
        super(name, dataType);
    }
    
    /**
    *
    *@param PositionalArgument Initializes a positional argument object with the specified <b>name</b>, <b>argDescription</b> and the default type.
    *
    *
    */
    public PositionalArgument(String name, String argDescription){
        super(name, argDescription);
    }
    
    /**
    *
    *@param PositionalArgument Initializes a positional argument object with the specified  <b>name</b>, <b>ArgType</b>, <b>dataType</b>, and <b>argDescription</b>
    *
    *
    */
    public PositionalArgument(String name, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
    } 
    
    /**
    *
    *@param PositionalArgument Initializes a positional argument object with the specified <b>name</b> and <b>setOfValues</b>.
    *
    *
    */
    public PositionalArgument(String name, String[] setOfValues){
        super(name);
        valueSet = setOfValues;
    }
    
    /**
    *
    *@param PositionalArgument Initializes a positional argument object with the specified <b>name</b>, <b>dataType</b>, <b>setOfValues</b> and default desctiption.
    *
    *
    */
    public PositionalArgument(String name, ArgType dataType, String[] setOfValues){
        super(name, dataType);
        valueSet = setOfValues;
    }
    
    /**
    *
    *@param PositionalArgument Initializes a positional argument object with the specified <b>name</b>, <b>argDescription</b>, <b>setOfValues</b> and the default type.
    *
    *
    */
    public PositionalArgument(String name, String argDescription, String[] setOfValues){
        super(name, argDescription);
        valueSet = setOfValues;
    }
    
    /**
    *
    *@param PositionalArgument Initializes a positional argument object with the specified <b>name</b>, <b>dataType</b> <b>, argDescription</b> and <b>setOfValues</b>.
    *
    *
    */
    public PositionalArgument(String name, ArgType dataType, String argDescription, String[] setOfValues){
        super(name, dataType, argDescription);
        valueSet = setOfValues;
    } 


//***********************************************************************************
	
    /**
    *
    *@param setPosition Sets the position of the positional argument object.
    *
    *
    */
    public void setPosition(int pos){
		position = pos;
	}
	
    /**
    *
    *@param getPosition Returns the integer position of the positional argument object. Numbering starts at 0.
    *@returns position
    *
    */
	public int getPosition(){
		return position;
	}
	
//****** These are subclassed from the abstract class Argument **************************

   /**
    *
    *
    *
    *
    */
    public String getName(){
        return this.argName;
    }
    
    /**
    *
    *
    *
    *
    */
    public String getType(){
    	if(type == ArgType.INTEGER){
    		return "integer";
    	}
    	else if(type == ArgType.FLOAT){
    		return "float";
    	}
    	else if(type == ArgType.STRING){
    		return "string";
    	}
    	else return "boolean";
    }
    
    /**
    *
    *
    *
    *
    */
    public String getDescription(){
    	return description;
    }
    
    /**
    *
    *
    *
    *
    */
    public void setValue(String argValue){
    	value = argValue;
    }
	
    /**
    *
    *
    *
    *
    */
    public <T> T getValue(){
    	if(this.getType().equals("integer")){
    		int intValue = Integer.parseInt(value);
    		return (T)(Integer)intValue;
    	}
    	else if(this.getType().equals("float")){
    		float floatValue = Float.parseFloat(value);
    		return (T)(Float)floatValue;
    	}
    	else if(this.getType().equals("boolean")){
    		Boolean boolValue = Boolean.parseBoolean(value);
    		return (T)(Boolean)boolValue;
    	}
    	else{
    		return (T)value;
    	}
    }
    
    /**
    *
    *
    *
    *
    */
    public String[] getValueSet(){
    	return valueSet;
    }
     
//**************************************************************************************

}