package edu.jsu.mcis;

public class PositionalArgument extends Argument{
    //protected String argName;
    //protected String description;
    //protected ArgumentParser.argType type;
    //protected <T> value;
    //protected String value;
	private int position = -1;

    
   	
    //make constructor do the same as add elements
    
    public PositionalArgument(String name){
        //addElements(name);
        super(name);
        //argName = name;
        //description = "";
        //type = ArgType.STRING;
        //value = null;
    }
    
    public PositionalArgument(String name, ArgType dataType){
        //this.setName(name);
        //this.setType(dataType);
        super(name, dataType);
        //argName = name;
        //description = "";
        //type = dataType;
        //value = null;
    }
    
    public PositionalArgument(String name, String argDescription){
        //this.setName(name);
        //description = argDescription;
        //this.setType(ArgumentParser.argType.STRING);
        super(name, argDescription);
        //argName = name;
        //description = argDescription;
        //type = ArgType.STRING;
        //value = null;
    }
    
    public PositionalArgument(String name, ArgType dataType, String argDescription){
    	//this.setName(name);
        //this.setType(dataType);
        //description = argDescription;
        super(name, dataType, argDescription);
        //argName = name;
        //description = argDescription;
        //type = dataType;
        //value = null;
    } 

	
    private void setName(String name){
        argName = name;
    }
    
    public String getName()
    {
        return this.argName;
    }
    
	public void setPosition(int pos){
		position = pos;
	}
	
	public int getPosition(){
		return position;
	}
	
    private void setType(ArgType dataType){
        type = dataType;
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
	
    public String getValue(){
    	return value;
    }
     
}