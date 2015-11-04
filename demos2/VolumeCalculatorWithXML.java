import edu.jsu.mcis.*;
import java.util.*;

public class VolumeCalculatorWithXML 
{

    public static void main (String args[]) {
        float x = 0;
        float y = 0;
        float z = 0;
          
        try{
			
			/*AddXMLArguments xml = new AddXMLArguments();//XML File path is different for each computer
			
			//checks if the XML File exists
			File varTempDir = new File("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			boolean exists = varTempDir.exists();
			if (varTempDir.isDirectory()){
				//Katie
				ArgumentParser lib = xml.addArgumentsFromXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			}
			File varTempDir = new File("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			boolean exists = varTempDir.exists();
			
			if (varTempDir.isDirectory()){
				//Trent
				ArgumentParser lib = xml.addArgumentsFromXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/Arguments.xml");
			}
			*/
			
			
			AddXMLArguments xml = new AddXMLArguments();
		
			//Katie Location
			//Library lib = xml.addArgumentsFromXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
		
			//Trent Location
			Library lib = xml.addArgumentsFromXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/Arguments.xml");
			
			
			
			
			
			
			
			try{
				lib.parse(args);
				Argument length = lib.getArgument(1);
				Argument width = lib.getArgument(2);
				Argument height = lib.getArgument(3);
			
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
		catch(Exception e){
			System.out.println(e.getMessage());
		}	
    }
    
}