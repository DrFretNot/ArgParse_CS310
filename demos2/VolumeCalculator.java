import edu.jsu.mcis.*;

public class VolumeCalculator 
{
    float x = 0;
    float y = 0;
    float zed = 0;
    float total = 0;
    
    
    Library lib = new Library();
	Argument length =new Argument();
	Argument width = new Argument();
	Argument height = new Argument();
    
    length.addElements("length", Library.argType.FLOAT, "the length of the box");
    width.addElements("width", Library.argType.FLOAT, "the width of the box");
    height.addElements("height", Library.argType.FLOAT, "the height of the box");
    
    lib.addArgument(length);
    lib.addArgument(width);
    lib.addArgument(height);
    
    
    try {
        lib.parse(args);
    }
    catch(Exception e){}
    
    x = length.getValue();
    y = width.getValue();
    zed = height.getValue();
    
    private float box(float a, float b, float c) {
        total = a*b*c;
        return total;
    }
    
    
    static void main (String args[]) {
        System.out.println( box(x,y,zed) );
        
    }
    
}