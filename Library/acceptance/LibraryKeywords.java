import edu.jsu.mcis.*;
import java.lang.String.*;

public class LibraryKeywords 
{
    private Library lib;
    private String output;

    public void startVolumeCalculatorWithArguments(String[] args){
    	lib = new Library();
    	lib.addProgramName("Volume Calculator");
    	Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", Library.argType.INTEGER, "the length of the box");
    	width.addElements("width", Library.argType.INTEGER, "the width of the box");
    	height.addElements("height", Library.argType.INTEGER, "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box"));
    	lib.addNamedArgument(new NamedArgument("digits", "4"));
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
    
    public String getLength(){
    	Argument currentArg = lib.getArgument("length");
    	return currentArg.getValue();
    }
    
    public String getWidth(){
    	Argument currentArg = lib.getArgument("width");
    	return currentArg.getValue();
    }
    
    public String getHeight(){
    	Argument currentArg = lib.getArgument("height");
    	return currentArg.getValue();
    }
    
    public String getType(){
    	NamedArgument type = lib.getNamedArgument("type");
    	return type.getValue();
    }
    
    public String getDigits(){
    	NamedArgument digits = lib.getNamedArgument("digits");
    	return digits.getValue();
    }
    public String getProgramOutput() 
    {
        return output;
    }
    
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
    
    public String getpet(){
    	Argument currentArg = lib.getArgument("pet");
    	return currentArg.getValue();
    }
    
    public String getNumber(){
    	Argument currentArg = lib.getArgument("number");
    	return currentArg.getValue();
    }
    
    public String getRainy(){
    	Argument currentArg = lib.getArgument("rainy");
    	return currentArg.getValue();
    }
    
    public String getBathrooms(){
    	Argument currentArg = lib.getArgument("bathrooms");
    	return currentArg.getValue();
    }
    
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