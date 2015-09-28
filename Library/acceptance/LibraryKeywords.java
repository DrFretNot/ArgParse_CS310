import edu.jsu.mcis.*;

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
        	output = String.parseString(total);
        }
        else output = check;
        return output;
    }
    
}