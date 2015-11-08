package edu.jsu.mcis;

public class PositionalArgument<T> extends Argument{

	private T value;
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
    
    public void setValue(T argValue){
    	value = argValue;
    }
	
    public T getValue(){
    	if(type == ArgType.FLOAT){
    		return (T)(Float)value;
    	}
    	else{
    		return value;
    	}
    }
     
//**************************************************************************************

}