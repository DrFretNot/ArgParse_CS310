package edu.jsu.mcis;

/**
 *
 *Class description: Generics class which extends Arugument class. Allows for the calling of short form named arguments and or sets default values. 
 *
*/
public class NamedArgument extends Argument{
    
   //private T value;
   //private String value;
   private char shortFormName;
   private String defaultvalue = "";

//**************************************************************************************
    /**
     *initializes a new namedArgument object with only the name. 
     *@param name The name to be set for the argument object.
     *
    */
    public NamedArgument(String name){
        super(name);  
    }
    
    /**
     *initializes a new namedArgument object with the name and dataType. 
     *@param name The name to be set for the argument object.
     *@param dataType The data type that the argument will parse for. 
     *
    */
    public NamedArgument(String name, ArgType dataType){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	this.value = null; 
        } 
    }  
    
    /**
     *
     *initializes a new namedArgument object with Name, dataType, and Description. 
     *@param name The name to be set for the argument object.
     *@param dataType The data type that the argument will parse for.
     *@param argDescription The description that be set for the argument object.
     *
    */
    public NamedArgument(String name, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	this.value = null; 
        }   
    } 
    
    /**
     *initializes a new namedArgument object with name and default value. 
     *@param name The name to be set for the argument object.
     *@param defaultValue The value that the argument will default to unless otherwise stated. 
     *
     *
    */
    public NamedArgument(String name, String defaultValue){
        super(name);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue; 
    }          
	
     /**
      *initializes a new namedArgument object with name, default value, and dataType. 
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType){
        super(name, dataType);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;   
    }  
    
     /**
      *
      *initializes a new namedArgument object with name, default value, and description. 
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param argDescription The description that be set for the argument object
      *
      */
    public NamedArgument(String name, String defaultValue, String argDescription){
        super(name, argDescription);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;    
    }    	
	
     /**
      *initializes a new namedArgument object with name, default value, dataType, and description. 
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *@param argDescription The description that be set for the argument object
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;    
    }
    
    
    
    /**
     *initializes a new namedArgument object with name, and short form name.
     *
     *@param name The string name to be set for the argument object.
     *@param shortForm The shortend form of the name as a character.  
     */
	public NamedArgument(String name, char shortForm){
        super(name);
        shortFormName = shortForm;
	}	
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param shortForm The shortend form of the name.
      */
	public NamedArgument(String name, String defaultValue, char shortForm){
        super(name);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;  
    }  
    
    /**
      *NamedArgument initializes a new namedArgument object with name, data type, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param dataType The data type that the argument will parse for.
      *@param shortForm The shortend form of the name.
      */
	public NamedArgument(String name, ArgType dataType, char shortForm){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
    }  
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, data type, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *@param shortForm The shortend form of the name.
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, char shortForm){
        super(name, dataType);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;  
    }  
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, description, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param argDescription The description that be set for the argument object.
      *@param shortForm The shortend form of the name.
      */
    public NamedArgument(String name, String defaultValue, String argDescription, char shortForm){
        super(name, argDescription);
        //value = (T)defaultValue; 
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm; 
    }    	
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, description, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param dataType The data type that the argument will parse for.
      *@param argDescription The description that be set for the argument object.
      *@param shortForm The shortend form of the name.
      */
	public NamedArgument(String name, ArgType dataType, String argDescription, char shortForm){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
    }
     /**
      *NamedArgument initializes a new namedArgument object with name, default value, description, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *@param argDescription The description that be set for the argument object.
      *@param shortForm The shortend form of the name.
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription, char shortForm){
        super(name, dataType, argDescription);
        //value = (T)defaultValue;  
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
    }
    
    /*******************************With sets of values*********************************/
    
    /**
     *NamedArgument initializes a new namedArgument object with only the name. 
     *@param name The name to be set for the argument object.
     *@param setOfValues An array of possible values that the named argumnet will allow. 
    */
    public NamedArgument(String name, String[] setOfValues){
        super(name);
        valueSet = setOfValues;
    }
    
    /**
     *NamedArgument initializes a new namedArgument object with Name, dataType, and Description. 
     *
     *@param name The name to be set for the argument object.
     *@param dataType The data type that the argument will parse for.
     *@param setOfValues An array of possible values that the named argumnet will allow.
     *
    */
    public NamedArgument(String name, ArgType dataType, String[] setOfValues){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	this.value = null; 
        } 
        valueSet = setOfValues;
    }  
    
    /**
     *NamedArgument initializes a new namedArgument object with Name, dataType, and Description.
     * 
     *@param name The name to be set for the argument object.
     *@param dataType The data type that the argument will parse for.
     *@param argDescription The description that be set for the argument object.
     *@param setOfValues An array of possible values that the named argumnet will allow.
    */
    public NamedArgument(String name, ArgType dataType, String argDescription, String[] setOfValues){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	this.value = null; 
        }   
        valueSet = setOfValues;
    } 
    
    /**
     *NamedArgument initializes a new namedArgument object with name and default value. 
     *@param name The name to be set for the argument object.
     *@param defaultValue The value that the argument will default to unless otherwise stated. 
     *@param setOfValues An array of possible values that the named argumnet will allow.
     *
    */
    public NamedArgument(String name, String defaultValue, String[] setOfValues){
        super(name);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue; 
        valueSet = setOfValues;
    }   
    
	/**
      *NamedArgument initializes a new namedArgument object with name, default value, and dataType.
      *      
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *@param setOfValues An array of possible values that the named argumnet will allow.
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, String[] setOfValues){
        super(name, dataType);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        valueSet = setOfValues;
    }  
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, and description. 
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param argDescription The description that be set for the argument object
      *@param setOfValues An array of possible values that the named argumnet will allow.
      *
      */
    public NamedArgument(String name, String defaultValue, String argDescription,String[] setOfValues){
        super(name, argDescription);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;
        valueSet = setOfValues;
    }    	
	
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, dataType, and description. 
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *@param argDescription The description that be set for the argument object
      *@param setOfValues An array of possible values that the named argumnet will allow.
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription,String[] setOfValues){
        super(name, dataType, argDescription);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;
        valueSet = setOfValues;
    }
    
    
    /**
     *NamedArgument initializes a new namedArgument object with name, and short form name.
     *
     *@param name The name to be set for the argument object.
     *@param shortForm The shortend form of the name. 
     *@param setOfValues An array of possible values that the named argumnet will allow.
     */
	public NamedArgument(String name, char shortForm,String[] setOfValues){
        super(name);
        shortFormName = shortForm;
        valueSet = setOfValues;
	}	
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, short form name, and set of values.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param shortForm The char shortend form of the name.
      *@param setOfValues An array of possible values that the named argument will allow.
      */
	public NamedArgument(String name, String defaultValue, char shortForm,String[] setOfValues){
        super(name);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm; 
        valueSet = setOfValues;        
    }  
    
    /**
      *NamedArgument initializes a new namedArgument object with name, data type, short form name, and set of values .
      *
      *@param name The name to be set for the argument object.
      *@param dataType The data type that the argument will parse for.
      *@param shortForm The shortend form of the name.
      *@param setOfValues An array of possible values that the named argumnet will allow.
      */
	public NamedArgument(String name, ArgType dataType, char shortForm,String[] setOfValues){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
        valueSet = setOfValues;
    } 
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, data type, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *@param shortForm The shortend form of the name.
      *@param setOfValues An array of possible values that the named argumnet will allow.
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, char shortForm,String[] setOfValues){
        super(name, dataType);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
        valueSet = setOfValues; 
    }  
    
    /**
      *NamedArgument initializes a new namedArgument object with name, default value, description, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param argDescription The description that be set for the argument object.
      *@param shortForm The shortend form of the name.
      *@param setOfValues An array of possible values that the named argumnet will allow.
      *
      */
    public NamedArgument(String name, String defaultValue, String argDescription, char shortForm,String[] setOfValues){
        super(name, argDescription);
        //value = (T)defaultValue; 
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
        valueSet = setOfValues; 
    }    	
    
    /**
      *initializes a new namedArgument object with name, data type, description, short form name, and set of values.
      *
      *@param name The name to be set for the argument object.
      *@param dataType The data type that the argument will parse for.
      *@param argDescription The description that be set for the argument object.
      *@param shortForm The shortened form of the name.
      *@param setOfValues An array of possible values that the named argument will allow.
      *
      */
	public NamedArgument(String name, ArgType dataType, String argDescription, char shortForm,String[] setOfValues){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	//this.setValue((T)String.valueOf(false));
        	this.setValue(String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
        valueSet = setOfValues;
    }

//*************************************************************************************
     /**
      *initializes a new namedArgument object with name, default value, data type, description, and short form name.
      *
      *@param name The name to be set for the argument object.
      *@param defaultValue The value that the argument will default to unless otherwise stated.
      *@param dataType The data type that the argument will parse for.
      *@param argDescription The description to be set for the argument object.
      *@param shortForm The shortend form of the name.
      *@param setOfValues An array of possible values that the named argumnet will allow.
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription, char shortForm, String[] setOfValues) {
        super(name, dataType, argDescription);
        //value = (T)defaultValue; 
        value = defaultValue;  
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
        valueSet = setOfValues;
    }
	


//**************************************************************************************
//methods  
    
    /**
     *Returns the short form of an argument when ever there is one.
     *
     *
     *@return the character short form of the argument.
     */
	public char getShortFormName(){
		return shortFormName;
	}
	
    /**
     *Returns the default value to be used if a value is not given. If for eample --type is not called, the default value will be automatically put in its place.
     * 
     *@return the default value to the named argument.  
     */
	public String getDefaultValue(){
		return defaultvalue;
	}

//****** These are subclassed from the abstract class Argument **************************
    /**
    *Returns the name of the named argument.
    *
    *@return the String name of the named argument
    */


	public String getName()
    {
        return this.argName;
    }

    
    /**
    *Returns the data type of the named argument. 
    *
    *@return the data type of the named argument
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
    *Returns the description of the named argument. 
    *
    *@return the description of the named argument 
    */
	public String getDescription(){
    	return description;
    }
	
    
    /**
    *Sets the value that the argument will hold
    *
    *
    */
    
	public void setValue(String argValue){
    	value = argValue;
    }
    
    
    /**
    *Returns the argument value of the specified type that is held by the named argument
    *
    *
    *@return the value of the specified type
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
    *Returns the set of possible values that are allowed by that named argument object. 
    *
    *
    *@return an array of possible values for the named argument
    */
    public String[] getValueSet(){
    	return valueSet;
    }


}