import edu.jsu.mcis.*;
import java.lang.String.*;

public class ArgumentParserKeywords 
{
    private ArgumentParser lib;
    private String output = "n";

    public void startVolumeCalculatorWithArguments(String[] args){
    	lib = new ArgumentParser();
    	lib.addProgramName("Volume Calculator");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.INTEGER, "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.INTEGER, "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.INTEGER, "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box", 't'));
    	lib.addNamedArgument(new NamedArgument("digits", "4", 'd'));
    	try{
    		lib.parse(args);
            int len = length.getValue();
            int wid = width.getValue();
            int hei = height.getValue();
            float result = len * wid * hei;
            output = String.valueOf(result);
    	}
    	catch(Exception e){
    		output = e.getMessage();
    	}
    }
    
    public String getLength(){
    	PositionalArgument currentArg = lib.getPositionalArgument("length");
    	int value = (Integer)currentArg.getValue();
    	return Integer.toString(value);
    }
    
    public String getWidth(){
    	PositionalArgument currentArg = lib.getPositionalArgument("width");
    	int value = (Integer)currentArg.getValue();
    	return Integer.toString(value);
    }
    
    public String getHeight(){
    	PositionalArgument currentArg = lib.getPositionalArgument("height");
    	int value = (Integer)currentArg.getValue();
    	return Integer.toString(value);
    }
    
    public String getType(){
    	NamedArgument type = lib.getNamedArgument("type");
    	return (String)type.getValue();
    }
    
    public String getDigits(){
    	NamedArgument digits = lib.getNamedArgument("digits");
    	return (String)digits.getValue();
    }
    public String getProgramOutput() 
    {
        return output;
    }
    
    public void startAbsurdProgramWithArguments(String[] args){
    	lib = new ArgumentParser();
    	lib.addProgramName("Volume Calculator");
    	PositionalArgument pet = new PositionalArgument("pet");
    	PositionalArgument number = new PositionalArgument("number");
    	PositionalArgument rainy = new PositionalArgument("rainy");
    	PositionalArgument bathrooms = new PositionalArgument("bathrooms");
    	//pet.addElements("pet");
    	//number.addElements();
    	//rainy.addElements("rainy");
    	//bathrooms.addElements(");
    	lib.addPositionalArgument(pet);
    	lib.addPositionalArgument(number);
    	lib.addPositionalArgument(rainy);
    	lib.addPositionalArgument(bathrooms);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		output = e.getMessage();
    	}	
    }
    
    public String getpet(){
    	PositionalArgument currentArg = lib.getPositionalArgument("pet");
    	return (String)currentArg.getValue();
    }
    
    public String getNumber(){
    	PositionalArgument currentArg = lib.getPositionalArgument("number");
    	return (String)currentArg.getValue();
    }
    
    public String getRainy(){
    	PositionalArgument currentArg = lib.getPositionalArgument("rainy");
    	return (String)currentArg.getValue();
    }
    
    public String getBathrooms(){
    	PositionalArgument currentArg = lib.getPositionalArgument("bathrooms");
    	return (String)currentArg.getValue();
    }
    
    public void startProgramWithArguments(String[] args){
    	lib = new ArgumentParser();
    	lib.addProgramName("Volume Calculator");
    	lib.addProgramDescription("Calculate the volume of a box.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the box (float)");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the box (float)");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the box (float)");
    	//length.addElements("length", Argument.ArgType.FLOAT, "the length of the box (float)");
    	//width.addElements();
    	//height.addElements();
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("help", "false", Argument.ArgType.BOOLEAN, "usage information", 'h'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		output = e.getMessage();
    	}
    }

}