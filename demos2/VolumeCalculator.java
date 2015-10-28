import edu.jsu.mcis.*;
import java.util.*;

public class VolumeCalculator 
{

    public static void main (String args[]) {
        float x = 0;
        float y = 0;
        float z = 0;
        float total = 0;
            
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
        Argument width = new Argument();
        Argument height = new Argument();
    
        length.addElements("length", Library.argType.FLOAT, "the length of the box");
        width.addElements("width", Library.argType.FLOAT, "the width of the box");
        height.addElements("height", Library.argType.FLOAT, "the height of the box");
        
        lib.addArgument(length);
        lib.addArgument(width);
        lib.addArgument(height);
        lib.addNamedArgument(new NamedArgument("type", "box", 't'));
        lib.addNamedArgument(new NamedArgument("digits", "0", Library.argType.INTEGER, 'd'));
        lib.addNamedArgument(new NamedArgument("help", "false", Library.argType.BOOLEAN, 'h'));
        	
		try {
			lib.parse(args);
			x = Float.parseFloat(length.getValue());
			y = Float.parseFloat(width.getValue());
			z = Float.parseFloat(height.getValue());
			NamedArgument type = lib.getNamedArgument("type");
			if(type.getValue().equals("box")){
				System.out.println( String.valueOf(x * y * z) );
			}
			else if(type.getValue().equals("pyramid")){
				System.out.println( String.valueOf((x * y * z)/3) );
			}
			else if(type.getValue().equals("ellipsoid")){
				System.out.println( String.valueOf((4*(3.1415)*x*y*z)/3 ));
			}
			System.out.println(type.getValue());
			System.out.println("******************************");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("******************************");
		}
			
    }
    
}