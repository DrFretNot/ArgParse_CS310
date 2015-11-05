package edu.jsu.mcis;

public class NamedArgument extends PositionalArgument{
    
   private char shortFormName;

	/*

	constructors
	
	HAVE
	name
	name	defaultValue
	name	dataType
	name	defaultValue	dataType
	name	defaultValue	argDescription
	name	dataType		argDescription
	name	defaultValue	dataType 		argDescription
	name	shortForm
	name	defaultValue	shortForm
	
	NEED(?)
	name	argDescription		but description is a String, so we can't have this one. 
	//							how to handle? do we need this combination?
	
	name	dataType		shortForm
	name	defaultValue	dataType		shortForm
	name	defaultValue	argDescription	shortForm
	name	dataType		argDescription	shortForm
	name	defaultValue	dataType 		argDescription	shortForm
	
	*/
//**************************************************************************************

    public NamedArgument(String name){
        //argName = name;
        //description = "";
        //type = ArgType.STRING;
        //value = null;
        super(name);  
    }
    
    public NamedArgument(String name, ArgType dataType){
        //argName = name;
        //description = "";
        //type = dataType;
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	this.value = "false";
        }
        else{
        	this.value = null; 
        } 
    }  
    
     
    
    /*public NamedArgument(String name, String argDescription){
    	
    } */ 
    
    public NamedArgument(String name, ArgType dataType, String argDescription){
        //argName = name;
        //description = argDescription;
        //type = dataType;
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	this.value = "false";
        }
        else{
        	this.value = null; 
        }   
    } 
    
    public NamedArgument(String name, String defaultValue){
        //argName = name;
        //description = "";
        //type = ArgType.STRING;
        super(name);
        value = defaultValue;  
    }          
	
    public NamedArgument(String name, String defaultValue, ArgType dataType){
        //argName = name;
        //description = "";
        //type = dataType;
        super(name, dataType);
        value = defaultValue;  
    }  
    public NamedArgument(String name, String defaultValue, String argDescription){
        //argName = name;
        //description = argDescription;
        //type = ArgType.STRING;
        super(name, argDescription);
        value = defaultValue;  
    }    	
	
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription){
        //argName = name;
        //description = argDescription;
        //type = dataType;
        super(name, dataType, argDescription);
        value = defaultValue;  
    }
    
    
    //These take shortForm
	public NamedArgument(String name, char shortForm){
		//argName = name;
        //description = "";
        //type = ArgType.STRING;
        //value = null;
        super(name);
        shortFormName = shortForm;
	}	
	public NamedArgument(String name, String defaultValue, char shortForm){
        //argName = name;
        //description = "";
        //type = ArgType.STRING;
        super(name);
        value = defaultValue;
        shortFormName = shortForm;  
    }  
	public NamedArgument(String name, ArgType dataType, char shortForm){
        //argName = name;
        //description = "";
        //type = dataType;
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
        //argName = name;
        //description = "";
        //type = dataType;
        super(name, dataType);
        value = defaultValue;
        shortFormName = shortForm;  
    }  
    public NamedArgument(String name, String defaultValue, String argDescription, char shortForm){
        //argName = name;
        //description = argDescription;
        //type = ArgType.STRING;
        super(name, argDescription);
        value = defaultValue; 
        shortFormName = shortForm; 
    }    	
	public NamedArgument(String name, ArgType dataType, String argDescription, char shortForm){
        //argName = name;
        //description = argDescription;
        //type = dataType;
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
        //argName = name;
        //description = argDescription;
        //type = dataType;
        super(name, dataType, argDescription);
        value = defaultValue;  
        shortFormName = shortForm;
    }
	


//**************************************************************************************
//methods
	public char getShortFormName(){
		return shortFormName;
	}


}