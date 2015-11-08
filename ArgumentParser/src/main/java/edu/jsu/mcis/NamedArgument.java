package edu.jsu.mcis;

public class NamedArgument extends Argument{
    
   private char shortFormName;

//**************************************************************************************

    public NamedArgument(String name){
        super(name);  
    }
    
    public NamedArgument(String name, ArgType dataType){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	this.value = "false";
        }
        else{
        	this.value = null; 
        } 
    }  
    
    public NamedArgument(String name, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	this.value = "false";
        }
        else{
        	this.value = null; 
        }   
    } 
    
    public NamedArgument(String name, String defaultValue){
        super(name);
        value = defaultValue;  
    }          
	
    public NamedArgument(String name, String defaultValue, ArgType dataType){
        super(name, dataType);
        value = defaultValue;  
    }  
    public NamedArgument(String name, String defaultValue, String argDescription){
        super(name, argDescription);
        value = defaultValue;  
    }    	
	
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
        value = defaultValue;  
    }
    
    
    //These take shortForm
	public NamedArgument(String name, char shortForm){
        super(name);
        shortFormName = shortForm;
	}	
	public NamedArgument(String name, String defaultValue, char shortForm){
        super(name);
        value = defaultValue;
        shortFormName = shortForm;  
    }  
	public NamedArgument(String name, ArgType dataType, char shortForm){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	value = "false";
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
    }  
    public NamedArgument(String name, String defaultValue, ArgType dataType, char shortForm){
        super(name, dataType);
        value = defaultValue;
        shortFormName = shortForm;  
    }  
    public NamedArgument(String name, String defaultValue, String argDescription, char shortForm){
        super(name, argDescription);
        value = defaultValue; 
        shortFormName = shortForm; 
    }    	
	public NamedArgument(String name, ArgType dataType, String argDescription, char shortForm){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	value = "false";
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
    }
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription, char shortForm){
        super(name, dataType, argDescription);
        value = defaultValue;  
        shortFormName = shortForm;
    }
	


//**************************************************************************************
//methods
	public char getShortFormName(){
		return shortFormName;
	}

//****** These are subclassed from the abstract class Argument **************************

	public String getName()
    {
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
    
    public String getValue(){
    	return value;
    }

//**************************************************************************************

}