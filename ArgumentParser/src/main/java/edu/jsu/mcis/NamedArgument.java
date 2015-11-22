package edu.jsu.mcis;

/**
 *
 *Class description: Generics class which extends Arugument class. Allows for the calling of short form named arguments and or sets default values. 
 *
*/
public class NamedArgument<T> extends Argument{
    
   //private T value;
   //private String value;
   private char shortFormName;
   private String defaultvalue = "";

//**************************************************************************************
    /**
     *
     *@param NamedArgument Takes Name
     *
    */
    public NamedArgument(String name){
        super(name);  
    }
    
    /**
     *
     *@param NamedArgument takes Name, and DataType
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
     *@param NamedArgument takes Name, Data Type, and Description
     *
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
     *
     *@param NamedArgument takes Name, and Default Value
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
      *
      *@param NamedArgument takes Name, Default Value, and Argument Type)
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
      *@param NamedArgument takes Name, Default Value, and Description)
      *
      */
    public NamedArgument(String name, String defaultValue, String argDescription){
        super(name, argDescription);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;    
    }    	
	
     /**
      *
      *@param NamedArgument takes Name, Default Value, Argument Type, Description)
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;    
    }
    
    
    
    /**
     *
     *@param NamedArgument takes Name, and Short Form)
     *
     */
	public NamedArgument(String name, char shortForm){
        super(name);
        shortFormName = shortForm;
	}	
    
    /**
      *
      *@param NamedArgument takes Name, Default Value, and Short Form)
      *
      */
	public NamedArgument(String name, String defaultValue, char shortForm){
        super(name);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;  
    }  
    
    /**
      *
      *@param NamedArgument takes Name, Argument Type, and Short Form)
      *
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
      *
      *@param NamedArgument takes Name, Default Value, Argument Type, and Short Form)
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, char shortForm){
        super(name, dataType);
        //value = (T)defaultValue;
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;  
    }  
    
    /**
      *
      *@param NamedArgument takes Name, Default Value, Description, and Short Form)
      *
      */
    public NamedArgument(String name, String defaultValue, String argDescription, char shortForm){
        super(name, argDescription);
        //value = (T)defaultValue; 
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm; 
    }    	
    
     /**
      *
      *@param NamedArgument takes Name, Argument Type, Description, and Short Form)
      *
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
      *
      *@param NamedArgument takes Name, Default Value, Argument Type, Description, and Short Form)
      *
      */
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription, char shortForm){
        super(name, dataType, argDescription);
        //value = (T)defaultValue;  
        value = defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
    }
    
    /*******************************With sets of values*********************************/
    public NamedArgument(String name, String[] setOfValues){
        super(name);
        valueSet = setOfValues;
    }
    
    /**
      *
      *@param NamedArgument takes Name, Argument Type, and a Set of Values
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
      *
      *@param NamedArgument takes Name, Argument Type, Description, and a Set of Values
      *
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
      *
      *@param NamedArgument takes Name, Default Value, and a Set of Values
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
      *
      *@param NamedArgument takes Name, Default Value, Argument Type, and a Set of Values
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
      *
      *@param NamedArgument takes Name, Default Value, Description, and a Set of Values
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
      *
      *@param NamedArgument takes Name, Default Value, Argument Type, Description, and a Set of Values
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
      *
      *@param NamedArgument takes Name, Short Form name and, a Set Of Values
      *
      */
	public NamedArgument(String name, char shortForm,String[] setOfValues){
        super(name);
        shortFormName = shortForm;
        valueSet = setOfValues;
	}	
    
    /**
      *
      *@param NamedArgument takes Name, Default Value, Short Form name and, a Set Of Values
      *
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
      *
      *@param NamedArgument takes Name, Data Type, Short Form name and, a Set Of Values
      *
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
      *
      *@param NamedArgument takes Name, Default Value, Data Type, Short Form name and, a Set Of Values
      *
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
      *
      *@param NamedArgument takes Name, Default Value, Argument Description, Short Form name and, a Set Of Values
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
      *
      *@param NamedArgument takes Name, Default Value, Data Type, Argument Description, Short Form name and, a Set Of Values
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
      *
      *@param NamedArgument takes Name, Default Value, Data Type, Argument Description, Short Form name and, a Set Of Values
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
     *
     *@param getShortFormName Gets the short form of an argument when ever there is one.
     *@return shortFormName return the short form of the argument.
     */
	public char getShortFormName(){
		return shortFormName;
	}
	
    /**
     *
     *@param getDefaultValue If for eample --type is not called, the default value will be automatically put in its place. 
     *@return defaultvalue Returns the default value to the CLI.  
     */
	public String getDefaultValue(){
		return defaultvalue;
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