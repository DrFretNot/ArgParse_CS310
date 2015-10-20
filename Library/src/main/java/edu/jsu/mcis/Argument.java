package edu.jsu.mcis;

public class Argument{
    protected String argName;
    protected String description;
    protected Library.argType type;
    protected String value;

    
    public Argument(){
        argName = null;
        description = "";
        type = null;
        value = null;
    }
    
    public void addElements(String name){
        this.setName(name);
        this.setType(Library.argType.STRING);
    }
    
    public void addElements(String name, Library.argType dataType){
        this.setName(name);
        this.setType(dataType);
    }
    
    public void addElements(String name, String argDescription){
        this.setName(name);
        description = argDescription;
        this.setType(Library.argType.STRING);
    }
    
    public void addElements(String name, Library.argType dataType, String argDescription){
    	this.setName(name);
        this.setType(dataType);
        description = argDescription;
    } 

    private void setName(String name){
        argName = name;
    }
    
    private void setType(Library.argType dataType){
        type = dataType;
    }
    
    public void setValue(String argValue){
    	value = argValue;
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
    
    public String getName()
    {
        return this.argName;
    }
    
    public String getDescription(){
    	return description;
    }
    
    public String getValue(){
    	return value;
    } 
}