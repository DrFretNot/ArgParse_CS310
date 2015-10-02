import edu.jsu.mcis.*;

//import edu.jsu.mcis.Library;
//import edu.jsu.mcis.*;

public class VolumeCalculator 
{
    /*public static void main(String[] args) 
    {
        VolumeCalculator v = new VolumeCalculator();
        int length, width, height;
        length = Integer.parseInt(args[0]);
        width = Integer.parseInt(args[1]);
        height = Integer.parseInt(args[2]);
        System.out.println(v.calculator(length, width, height));
    }
    
    private int calculator(int x, int y, int z)
    {
        int volume = (x*y*z);
        return volume;
    }
    
    private String getHelp ()
    {
        String help = "usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments: \nlength the length of the box\nwidth the width of the box\nheight the height of the box\n";
        return help;
    }
    
    public VolumeCalculator()
    {
        
    }*/
    
    public static void main(String[] args){
    	Library VolumeCalculator = new Library();
    	//tried this but didn't work
    	//Library.Library VolumeCalculator = new Library.Library();
    	
    	VolumeCalculator.addProgramName("VolumeCalculator");
    	
    	VolumeCalculator.addProgramDescription("Calculate the volume of a box given length, width, and height.\nEnter -h for more details.");
    	
    	VolumeCalculator.addArgWithDataType("length", FLOAT);
    	
    	VolumeCalculator.addArgWithDataType("width", FLOAT);
    	
    	VolumeCalculator.addArgWithDataType("height", FLOAT);
    	
    	System.out.println(VolumeCalculator.getProgramName());
    	System.out.println(VolumeCalculator.getProgramDescription());
    	
    	if (VolumeCalculator.argMultiUseChecker(args).equals("")){
    		float Volume = VolumeCalculator.getParsedArgValue("length") * VolumeCalculator.getParsedArgValue("width") * VolumeCalculator.getParsedArgValue("height");
    		System.out.println("The volume is " + Volume);
    	}
    	else System.out.println(VolumeCalculator.argMultiUseChecker(args));
    }
}