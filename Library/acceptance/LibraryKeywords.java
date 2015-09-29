import edu.jsu.mcis.*;
import java.lang.String.*;

public class LibraryKeywords 
{
<<<<<<< HEAD
    private Library lib;
    private String output;

=======
    private Library lib = new Library();
    private String check;
    
>>>>>>> origin/master
    public void startVolumeCalculatorWithArguments(String[] args) 
    {
        lib = new Library();
        lib.addProgramName("Volume Calculator");
        lib.addArgName("length");
        lib.addArgName("width");
        lib.addArgName("height");
        lib.addArgsFromCLI(args);
<<<<<<< HEAD
        output = lib.checkNumOfArgs(args);
        if (output != ""){}
        else
        {
            float len = Float.parseFloat(lib.getArgValue("length"));
            float wid = Float.parseFloat(lib.getArgValue("width"));
            float hei = Float.parseFloat(lib.getArgValue("height"));
            output = String.valueOf(len * wid * hei);
        }
=======
        check = lib.checkNumOfArgs(args);
        
>>>>>>> origin/master
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
<<<<<<< HEAD
        //float len = Float.parseFloat(lib.getArgValue("length"));
        //float wid = Float.parseFloat(lib.getArgValue("width"));
        //float hei = Float.parseFloat(lib.getArgValue("height"));
        //String.valueOf(len * wid * hei);
=======
    	String output;
    	if (check == ""){
        	float len = Float.parseFloat(lib.getArgValue("length"));
        	float wid = Float.parseFloat(lib.getArgValue("width"));
        	float hei = Float.parseFloat(lib.getArgValue("height"));
        	float total = len * wid * hei;
        	output = Float.toString(total);
        }
        else output = check;
>>>>>>> origin/master
        return output;
    }
    
    public void startAbsurdProgramWithArguments(String[] args)
    {
<<<<<<< HEAD
        lib = new Library();
        lib.addProgramName("Absurd Program");
=======
    	lib.addProgramName("Absurd Program");
>>>>>>> origin/master
        lib.addArgName("pet");
        lib.addArgName("number");
        lib.addArgName("rainy");
        lib.addArgName("bathrooms");
        lib.addArgsFromCLI(args);
<<<<<<< HEAD
        output = lib.checkNumOfArgs(args);
=======
        check = lib.checkNumOfArgs(args);
>>>>>>> origin/master
    }
    
    public String getPet()
    {
<<<<<<< HEAD
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
=======
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
>>>>>>> origin/master
    }
}