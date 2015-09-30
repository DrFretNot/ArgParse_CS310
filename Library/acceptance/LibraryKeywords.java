import edu.jsu.mcis.*;
import java.lang.String.*;

public class LibraryKeywords 
{
    private Library lib;
    private String output;

    public void startVolumeCalculatorWithArguments(String[] args) 
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
    }
    
    public String getLength() 
    {
        return lib.getArgValue("length");
    }
    
    public String getWidth() 
    {
        return lib.getArgValue("width");
    }
    
    public String getHeight() 
    {
        return lib.getArgValue("height");
    }
    
    public String getProgramOutput() 
    {
        return output;
    }
    
    public void startAbsurdProgramWithArguments(String[] args)
    {

        lib = new Library();
        lib.addProgramName("Absurd Program");

        lib.addArgName("pet");
        lib.addArgName("number");
        lib.addArgName("rainy");
        lib.addArgName("bathrooms");
        lib.addArgsFromCLI(args);
    }
    
    public String getPet()
    {
        return lib.getArgValue("pet");
    }
    public String getNumber()
    {
        return lib.getArgValue("number");
    }
    public String getRainy()
    {
        return lib.getArgValue("rainy");
    }
    public String getBathrooms()
    {
        return lib.getArgValue("bathrooms");
    }
    
    public void startProgramWithArguments(String[] args)
    {
    	lib = new Library();
        lib.addProgramName("Volume Calculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgName("length");
        lib.addArgDescription("the length of the box (float)");
        lib.addArgName("width");
    	lib.addArgDescription("the width of the box (float)");
        lib.addArgName("height");
        lib.addArgDescription("the height of the box (float)");
        lib.addArgsFromCLI(args);
        output = lib.checkForHelpArg();
    }

}