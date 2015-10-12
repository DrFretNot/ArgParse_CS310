import edu.jsu.mcis.*;
import java.lang.String.*;

public class LibraryKeywords 
{
    private Library lib;
    private String output;

    /*public void startVolumeCalculatorWithArguments(String[] args) 
    {
        lib = new Library();
        lib.addProgramName("Volume Calculator");
        lib.addArgName("length");
        lib.addArgName("width");
        lib.addArgName("height");
        lib.addArgsFromCLI(args);

        output = lib.checkNumOfArgs(args);
        if (output == "")
        {
        	float len = Float.parseFloat(lib.getArgValue("length"));
            float wid = Float.parseFloat(lib.getArgValue("width"));
            float hei = Float.parseFloat(lib.getArgValue("height"));
            output = String.valueOf(len * wid * hei);
        }
    }*/
    public void startVolumeCalculatorWithArguments(String[] args){
    	lib = new Library();
    	lib.addProgramName("Volume Calculator");
    	Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", Library.argType.FLOAT, "the length of the box");
    	width.addElements("width", Library.argType.FLOAT, "the width of the box");
    	height.addElements("height", Library.argType.FLOAT, "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	try{
    		lib.parse(args);
    		float len = Float.parseFloat(length.getValue());
            float wid = Float.parseFloat(width.getValue());
            float hei = Float.parseFloat(height.getValue());
            float result = len * wid * hei;
            output = String.valueOf(result);
    	}
    	catch(Exception e){
    		output = e.getMessage();
    	}
    }
    
    /*public String getLength() 
    {
        return lib.getArgValue("length");
    }*/
    
    public String getLength(){
    	Argument currentArg = lib.getArgument("length");
    	return (String)currentArg.getValue();
    }
    
    /*public String getWidth() 
    {
        return lib.getArgValue("width");
    }*/
    
    public String getWidth(){
    	Argument currentArg = lib.getArgument("width");
    	return (String)currentArg.getValue();
    }
    
    /*public String getHeight() 
    {
        return lib.getArgValue("height");
    }*/
    
    public String getHeight(){
    	Argument currentArg = lib.getArgument("height");
    	return (String)currentArg.getValue();
    }
    
    public String getProgramOutput() 
    {
        return output;
    }
    
    /*public void startAbsurdProgramWithArguments(String[] args)
    {

        lib = new Library();
        lib.addProgramName("Absurd Program");

        lib.addArgName("pet");
        lib.addArgName("number");
        lib.addArgName("rainy");
        lib.addArgName("bathrooms");
        lib.addArgsFromCLI(args);
    }*/
    
    public void startAbsurdProgramWithArguments(String[] args){
    	lib = new Library();
    	lib.addProgramName("Volume Calculator");
    	Argument pet = new Argument();
    	Argument number = new Argument();
    	Argument rainy = new Argument();
    	Argument bathrooms = new Argument();
    	pet.addElements("pet");
    	number.addElements("number");
    	rainy.addElements("rainy");
    	bathrooms.addElements("bathrooms");
    	lib.addArgument(pet);
    	lib.addArgument(number);
    	lib.addArgument(rainy);
    	lib.addArgument(bathrooms);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		output = e.getMessage();
    	}	
    }
    
    /*public String getPet()
    {
        return lib.getArgValue("pet");
    }*/
    
    public String getpet(){
    	Argument currentArg = lib.getArgument("pet");
    	return (String)currentArg.getValue();
    }
    
    /*public String getNumber()
    {
        return lib.getArgValue("number");
    }*/
    
    public String getNumber(){
    	Argument currentArg = lib.getArgument("number");
    	return (String)currentArg.getValue();
    }
    
    /*public String getRainy()
    {
        return lib.getArgValue("rainy");
    }*/
    
    public String getRainy(){
    	Argument currentArg = lib.getArgument("rainy");
    	return (String)currentArg.getValue();
    }
    
    /*public String getBathrooms()
    {
        return lib.getArgValue("bathrooms");
    }*/
    
    public String getBathrooms(){
    	Argument currentArg = lib.getArgument("bathrooms");
    	return (String)currentArg.getValue();
    }
    
    /*public void startProgramWithArguments(String[] args)
    {
    	Library lib = new Library();
        lib.addProgramName("Volume Calculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgWithDataType("length", Library.argType.FLOAT);
        lib.addArgDescription("the length of the box (float)");
        lib.addArgWithDataType("width", Library.argType.FLOAT);
        lib.addArgDescription("the width of the box (float)");
        lib.addArgWithDataType("height", Library.argType.FLOAT);
        lib.addArgDescription("the height of the box (float)");
        lib.addArgsFromCLI(args);
        output = lib.argMultiUseChecker(args);
    }*/
    
    public void startProgramWithArguments(String[] args){
    	lib = new Library();
    	lib.addProgramName("Volume Calculator");
    	lib.addProgramDescription("Calculate the volume of a box.");
    	Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", Library.argType.FLOAT, "the length of the box (float)");
    	width.addElements("width", Library.argType.FLOAT, "the width of the box (float)");
    	height.addElements("height", Library.argType.FLOAT, "the height of the box (float)");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		output = e.getMessage();
    	}
    }

}