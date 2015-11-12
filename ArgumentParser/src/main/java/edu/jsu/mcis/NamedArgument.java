package edu.jsu.mcis;

public class NamedArgument<T> extends Argument{
    
   private T value;
   private char shortFormName;
   private String defaultvalue = "";

//**************************************************************************************

    public NamedArgument(String name){
        super(name);  
    }
    
    public NamedArgument(String name, ArgType dataType){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	this.value = null; 
        } 
    }  
    
    public NamedArgument(String name, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	this.value = null; 
        }   
    } 
    
    public NamedArgument(String name, String defaultValue){
        super(name);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue; 
    }          
	
    public NamedArgument(String name, String defaultValue, ArgType dataType){
        super(name, dataType);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;   
    }  
    public NamedArgument(String name, String defaultValue, String argDescription){
        super(name, argDescription);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;    
    }    	
	
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription){
        super(name, dataType, argDescription);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;    
    }
    
    
    //These take shortForm
	public NamedArgument(String name, char shortForm){
        super(name);
        shortFormName = shortForm;
	}	
	public NamedArgument(String name, String defaultValue, char shortForm){
        super(name);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;  
    }  
	public NamedArgument(String name, ArgType dataType, char shortForm){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
    }  
    public NamedArgument(String name, String defaultValue, ArgType dataType, char shortForm){
        super(name, dataType);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;  
    }  
    public NamedArgument(String name, String defaultValue, String argDescription, char shortForm){
        super(name, argDescription);
        value = (T)defaultValue; 
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm; 
    }    	
	public NamedArgument(String name, ArgType dataType, String argDescription, char shortForm){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
    }
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription, char shortForm){
        super(name, dataType, argDescription);
        value = (T)defaultValue;  
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
    }
    
    /*******************************With set of values*********************************/
    public NamedArgument(String name, String[] setOfValues){
        super(name);
        valueSet = setOfValues;
    }
    
    public NamedArgument(String name, ArgType dataType, String[] setOfValues){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	this.value = null; 
        } 
        valueSet = setOfValues;
    }  
    
    public NamedArgument(String name, ArgType dataType, String argDescription, String[] setOfValues){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	this.value = null; 
        }   
        valueSet = setOfValues;
    } 
    
    public NamedArgument(String name, String defaultValue, String[] setOfValues){
        super(name);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue; 
        valueSet = setOfValues;
    }          
	
    public NamedArgument(String name, String defaultValue, ArgType dataType, String[] setOfValues){
        super(name, dataType);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;  
        valueSet = setOfValues;
    }  
    public NamedArgument(String name, String defaultValue, String argDescription,String[] setOfValues){
        super(name, argDescription);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;
        valueSet = setOfValues;
    }    	
	
    public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription,String[] setOfValues){
        super(name, dataType, argDescription);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;
        valueSet = setOfValues;
    }
    
    
    //These take shortForm
	public NamedArgument(String name, char shortForm,String[] setOfValues){
        super(name);
        shortFormName = shortForm;
        valueSet = setOfValues;
	}	
	public NamedArgument(String name, String defaultValue, char shortForm,String[] setOfValues){
        super(name);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm; 
        valueSet = setOfValues;        
    }  
	public NamedArgument(String name, ArgType dataType, char shortForm,String[] setOfValues){
        super(name, dataType);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
        valueSet = setOfValues;
    }  
    public NamedArgument(String name, String defaultValue, ArgType dataType, char shortForm,String[] setOfValues){
        super(name, dataType);
        value = (T)defaultValue;
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
        valueSet = setOfValues; 
    }  
    public NamedArgument(String name, String defaultValue, String argDescription, char shortForm,String[] setOfValues){
        super(name, argDescription);
        value = (T)defaultValue; 
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
        valueSet = setOfValues; 
    }    	
	public NamedArgument(String name, ArgType dataType, String argDescription, char shortForm,String[] setOfValues){
        super(name, dataType, argDescription);
        if(dataType == ArgType.BOOLEAN){
        	this.setValue((T)String.valueOf(false));
        }
        else{
        	value = null; 
        }   
        shortFormName = shortForm;
        valueSet = setOfValues;
    }

//*************************************************************************************
	public NamedArgument(String name, String defaultValue, ArgType dataType, String argDescription, char shortForm, String[] setOfValues) {
        super(name, dataType, argDescription);
        value = (T)defaultValue;  
        this.defaultvalue =  defaultValue;  
        shortFormName = shortForm;
        valueSet = setOfValues;
    }
	


//**************************************************************************************
//methods
	public char getShortFormName(){
		return shortFormName;
	}
	
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
	
	public void setValue(T argValue){
    	value = argValue;
    }
    
    public T getValue(){
    	return value;
    }
    
    public String[] getValueSet(){
    	return valueSet;
    }

//**************************************************************************************

}