package edu.jsu.mcis;

public class Argument{
    public String argName;
    
    public Argument(){
        argName = null;
    }
    
    public void addElements(String name){
        this.setName(name);
    }
    
    private void setName(String name){
        argName = name;
    }
    
    public String getName()
    {
        return this.argName;
    }
}