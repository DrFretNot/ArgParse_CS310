package edu.jsu.mcis;

public class Argument{
    public String argName;
    public Library.argType type;
    
    public Argument(){
        argName = null;
        type = null;
    }
    
    public void addElements(String name, Library.argType dataType){
        this.setName(name);
        this.setType(dataType);
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
    
    public Library.argType getType(){
        return this.type;
    }
    
    public String getName()
    {
        return this.argName;
    }
}