import edu.jsu.mcis.*;
import java.util.*;

public class VolumeCalculatorWithXMLWriteFunction 
{

    public static void main (String args[]) {
        /*float x = 0;
        float y = 0;
        float z = 0;
        float total = 0;*/
            
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the box");
        PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the box");
        PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the box");
        
        lib.addPositionalArgument(length);
        lib.addPositionalArgument(width);
        lib.addPositionalArgument(height);
		
		String[] typeValueSet = {"box", "pyramid", "ellipsoid"};
        lib.addNamedArgument(new NamedArgument("type", "box", Argument.ArgType.STRING, 't', typeValueSet));
        lib.addNamedArgument(new NamedArgument("digits", "0", Argument.ArgType.INTEGER, 'd'));
        lib.addNamedArgument(new NamedArgument("help", Argument.ArgType.BOOLEAN, 'h'));
		//Sinh
		//lib.writeToXMLFile("C:\\Users\\HP Laptop\\Documents\\GitHub\\ArgParse_CS310\\SinhArgumentParser.xml");
		
		//Katie
		lib.writeToXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/demos2/KatieArgumentParser.xml");
		
		//Rob
		//lib.writeToXMLFile("C:\\Users\\HP Laptop\\Documents\\GitHub\\ArgParse_CS310\\SinhArgumentParser.xml");
		
		//Trent
		//lib.writeToXMLFile("C:\\Users\\HP Laptop\\Documents\\GitHub\\ArgParse_CS310\\SinhArgumentParser.xml");
		
		//Andrew
		//lib.writeToXMLFile("C:\\Users\\HP Laptop\\Documents\\GitHub\\ArgParse_CS310\\SinhArgumentParser.xml");
		
		
        	
			
    }
    
}
