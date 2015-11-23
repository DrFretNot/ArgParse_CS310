import edu.jsu.mcis.*;
import java.util.*;
import java.lang.Object.*;
import java.io.*;

public class VolumeCalculator 
{

    
    public static void main (String args[]) {
        
        float x = 0;
        float y = 0;
        float z = 0;
        double total = 0;
            
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of an object");
        String[] lengthValueSet = {"3.0", "4.0", "5.0"};
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the object", lengthValueSet);
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the object");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the object");
		lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("help", Argument.ArgType.BOOLEAN, "Prints usage information", 'h'));
    	String[] typeValueSet = {"box", "pyramid", "ellipsoid"};
    	NamedArgument type = new NamedArgument<String>("type", "box", Argument.ArgType.STRING, "the shape of the object", 't', typeValueSet);
    	lib.addNamedArgument(type);
        
        try{
    		lib.parse(args);
    		x = length.getValue();
			y = width.getValue();
			z = height.getValue();
			if(type.getValue().equals("box")){
				total = x*y*z;	
				System.out.println("total = " + total);
			}
			else if(type.getValue().equals("pyramid")){
				total = (x*y*z)/3;	
				System.out.println("total = " + total);
			}
			else if(type.getValue().equals("ellipsoid")){
				total = ((4/3) * 3.14) * x * y * z;	
				System.out.println("total = " + total);
			}
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
        System.out.println("******************************");
        
        
    }
    
    
    
}