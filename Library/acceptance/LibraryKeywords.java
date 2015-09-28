import edu.jsu.mcis.*;
import java.lang.String.*;

public class LibraryKeywords 
{
    private Library lib = new Library();
    private String check;
    
    public void startVolumeCalculatorWithArguments(String[] args) 
    {
        lib.addProgramName("Volume Calculator");
        lib.addArgName("length");
        lib.addArgName("width");
        lib.addArgName("height");
        lib.addArgsFromCLI(args);
        check = lib.checkNumOfArgs(args);
        
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
    	String output;
    	if (check == ""){
        	float len = Float.parseFloat(lib.getArgValue("length"));
        	float wid = Float.parseFloat(lib.getArgValue("width"));
        	float hei = Float.parseFloat(lib.getArgValue("height"));
        	float total = len * wid * hei;
        	output = Float.toString(total);
        }
        else output = check;
        return output;
    }
    
    public void startAbsurdProgramWithArguments(String[] args)
    {
    	lib.addProgramName("Absurd Program");
        lib.addArgName("pet");
        lib.addArgName("number");
        lib.addArgName("rainy");
        lib.addArgName("bathrooms");
        lib.addArgsFromCLI(args);
        check = lib.checkNumOfArgs(args);
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
}