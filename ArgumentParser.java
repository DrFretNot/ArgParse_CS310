import java.util.Collections;

public class ArgumentParser{
    
    private String[] arguments;
    private int length = 0;
    
    public ArgumentParser()
    {
        
    }
    
    public void addArg(String a)
    {
        arguments[length] = a;  
        length ++;
        //add argument names to the arguments enum
        //not sure about this one being possible
    }
    
    public String getArgs()
    {
        int arg = arguments.length;
        String temp = "";
        for (int i = 0; i < arg; i++)
        {
            temp = temp + " [" + arguments[i] + "] ";
        }
        return temp;
        
    }
    
    private void numArgs(int n)
    {
        //sets number of arguments allowed
        arguments = new String[n];
    }
    
    private void argCatcher()
    {
        //catches the arguments from the command line
        //using the argument enum to hold the data
        //for example: 
        //for (int i = 0; i<length; i++)
        //arguments.length = Integer.parseInt(args[0]);
    }
    
    private String getHelpUsageInfo()
    {
        //parmeters need to be -h somehow and return a string that we define here
        //
        String a = "hi";
        return a;
    }
    
    public static void main(String[] args) 
    {
        ArgumentParser p = new ArgumentParser();
        p.numArgs(3);
        p.addArg("length");
        p.addArg("width");
        p.addArg("height");
        System.out.println(p.getArgs());
    }
}