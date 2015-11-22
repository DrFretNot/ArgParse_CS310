package edu.jsu.mcis;

public class PositionalArgument extends Argument{

	//private T value;
	private String value;
	private int position = -1;

    public PositionalArgument(String name){
        super(name);
    }
    
    public PositionalArgument(String name, ArgType dataType){
        super(name, dataType);
    }
    
    public PositionalArgument(String name, String argDescription){
        super(name, argDescription);
    }
    
    public PositionalArgument(String name, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
    } 
    
    public PositionalArgument(String name, String[] setOfValues){
        super(name);
        valueSet = setOfValues;
    }
    
    public PositionalArgument(String name, ArgType dataType, String[] setOfValues){
        super(name, dataType);
        valueSet = setOfValues;
    }
    
    public PositionalArgument(String name, String argDescription, String[] setOfValues){
        super(name, argDescription);
        valueSet = setOfValues;
    }
    
    public PositionalArgument(String name, ArgType dataType, String argDescription, String[] setOfValues){
        super(name, dataType, argDescription);
        valueSet = setOfValues;
    } 


//***********************************************************************************
	public void setPosition(int pos){
		position = pos;
	}
	
	public int getPosition(){
		return position;
	}
	
//****** These are subclassed from the abstract class Argument **************************

   
    public String getName(){
        return this.argName;
    }
    
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
    
    public String getDescription(){
    	return description;
    }
    
    public void setValue(String argValue){
    	value = argValue;
    }
	
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
    
    public String[] getValueSet(){
    	return valueSet;
    }
     
//**************************************************************************************

}