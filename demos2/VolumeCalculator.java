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
        Argument length = new Argument();
        Argument width = new Argument();
        Argument height = new Argument();
    
        length.addElements("length", Library.argType.FLOAT, "the length of the box");
        width.addElements("width", Library.argType.FLOAT, "the width of the box");
        height.addElements("height", Library.argType.FLOAT, "the height of the box");
        
        lib.addArgument(length);
        lib.addArgument(width);
        lib.addArgument(height);
        
        while(true){
			System.out.println("Please enter your argument values");
		
			try {
				lib.parse(args);
				x = Float.parseFloat(length.getValue());
				y = Float.parseFloat(width.getValue());
				z = Float.parseFloat(height.getValue());
				System.out.println( String.valueOf(x * y * z) );
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
			
        }
    }
    
    /*private float box(float a, float b, float c) {
        float total = a*b*c;
        return total;
    }*/
        
    
}