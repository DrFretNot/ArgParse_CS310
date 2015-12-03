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
    *Initializes a positional argument object with the specified <b>name</b>, <b>dataType</b>, and default desctiption.
    *@param name String to be set as <b>name</b>. 
    *@param dataType Correct data type to be set. 
    *
    */
    public PositionalArgument(String name, ArgType dataType){
        super(name, dataType);
    }
    
    /**
    *Initializes a positional argument object with the specified <b>name</b>, <b>argDescription</b> and the default type.
    *@param name String to be set as <b>name</b>.
    *@param argDescription Description of each argument object.
    *
    */
    public PositionalArgument(String name, String argDescription){
        super(name, argDescription);
    }
    
    /**
    *Initializes a positional argument object with the specified  <b>name</b>, <b>ArgType</b>, <b>dataType</b>, and <b>argDescription</b>
    *@param name String to be set as <b>name</b>.
    *@param dataType The data type that the argument will parse for.
    *@param argDescription Description of each argument object.
    */
    public PositionalArgument(String name, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
    } 
    
    /**
    *Initializes a positional argument object with the specified <b>name</b> and <b>setOfValues</b>.
    *@param name String to be set as <b>name</b>.
    *@param setOfValues An array of possible values that <b>namedArgument</b> will allow.
    *
    */
    public PositionalArgument(String name, String[] setOfValues){
        super(name);
        valueSet = setOfValues;
    }
    
    /**
    *Initializes a positional argument object with the specified <b>name</b>, <b>dataType</b>, <b>setOfValues</b> and default desctiption.
    *@param name String to be set as <b>name</b>.
    *@param dataType The data type that the argument will parse for.
    *@param setOfValues An array of possible values that <b>namedArgument</b> will allow.
    */
    public PositionalArgument(String name, ArgType dataType, String[] setOfValues){
        super(name, dataType);
        valueSet = setOfValues;
    }
    
    /**
    *Initializes a positional argument object with the specified <b>name</b>, <b>argDescription</b>, <b>setOfValues</b> and the default type.
    *@param name String to be set as <b>name</b>.
    *@param argDescription the description for each argument object
    *@param setOfValues An array of possible values that <b>namedArgument</b> will allow.
    *
    */
    public PositionalArgument(String name, String argDescription, String[] setOfValues){
        super(name, argDescription);
        valueSet = setOfValues;
    }
    
    /**
    *Initializes a positional argument object with the specified <b>name</b>, <b>dataType</b> <b>, argDescription</b> and <b>setOfValues</b>.
    *@param name String to be set as <b>name</b>.
    *@param dataType The data type that the argument will parse for. 
    *@param argDescription the description for each argument object.
    *@param setOfValues An array of possible values that <b>namedArgument</b> will allow.
    */
    public PositionalArgument(String name, ArgType dataType, String argDescription, String[] setOfValues){
        super(name, dataType, argDescription);
        valueSet = setOfValues;
    } 


//***********************************************************************************
	
    /**
    *
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
    *@return position
    *
    */
	public int getPosition(){
		return position;
	}
	
//****** These are subclassed from the abstract class Argument **************************

   /**
    *
    *Gets the name and returns argName. 
    *@return this.argName
    *
    */
    public String getName(){
        return this.argName;
    }
    
    /**
    *
    *Returns the type of an argument object.
    *@return integer
    *@return float
    *@return string
    *@return boolean
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
    *Simply gets the description and returns the description of the argument object.
    *@return description returns the description
    *
    */
    public String getDescription(){
    	return description;
    }
    
    /**
    *Sets the value of the object.
    *@param argValue the string representation of the value to be set for the argument object
    *
    *
    */
    public void setValue(String argValue){
    	value = argValue;
    }
	
    /**
    *getValue Returns <T> value that is held by the named argument.
    *Returns the value of an argument object
    *@return intValue
    *@return floatValue
    *@return boolValue
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
    *Returns the set of possible values that are allowed by that named argument object.
    *@return valueSet 
    *
    *
    */
    public String[] getValueSet(){
    	return valueSet;
    }
     
//**************************************************************************************

}