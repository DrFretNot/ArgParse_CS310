package edu.jsu.mcis;

public class Argument{
    private String argName;
    private String description;
    private Library.argType type;
    private Object value;
    
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
    
/*     public String getInfo(){
        public String info = String.valueOf(this.getName());
        info = info + " is a " + String.valueOf(this.getType());
        
    } */
    
    private void setName(String name){
        argName = name;
    }
    
    private void setType(Library.argType dataType){
        type = dataType;
    }
    
    public void setValue(Object argValue){
    	value = argValue;
    }
    
    public Library.argType getType(){
        return this.type;
    }
    
    public String getName()
    {
        return this.argName;
    }
    
    public String getDescription(){
    	return description;
    }
    
    public Object getValue(){
    	return value;
    }
    
    public static void main(String args[]){
        
        String testString = "string Test";
        Library.argType testArgType = Library.argType.STRING;
        System.out.println(testString + "is a " + String.valueOf(testArgType));
        
        
    }
}