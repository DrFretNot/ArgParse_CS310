import edu.jsu.mcis.*;
import java.util.*;

public class VolumeCalculator 
{

    
    public static void main (String args[]) {
        
        float x = 0;
        float y = 0;
        float z = 0;
        float total = 0;
            
        ArgumentParser lib = new ArgumentParser();
    	PositionalArgument<Float> length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the box");
    	PositionalArgument<Float> width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the box");
    	PositionalArgument<Float> height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the box");
		lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
        
        try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		
    	}
        
        
        x = length.getValue();
        y = width.getValue();
        z = height.getValue();
		total = x*y*z;	
        System.out.println("total = " + total);
    }
    
    
    
}