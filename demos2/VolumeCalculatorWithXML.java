import edu.jsu.mcis.*;
import java.util.*;

public class VolumeCalculatorWithXML 
{

    public static void main (String args[]) {
        float x = 0;
        float y = 0;
        int z = 0;
          
        try{
        	//ArgumentParser lib = XMLReader.readXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/demos2/ArgumentsDemo.xml");
			
			/*AddXMLArguments xml = new AddXMLArguments();

			//Katie Location
			//Library lib = xml.addArgumentsFromXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
		
			//Trent Location
			Library lib = xml.addArgumentsFromXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/Arguments.xml");*/
		    ArgumentParser lib = XMLReader.readXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/demos2/ArgumentsDemo.xml");
		    
			try{
				lib.parse(args);
				PositionalArgument length = lib.getPositionalArgument(1);
				PositionalArgument width = lib.getPositionalArgument(2);
				PositionalArgument height = lib.getPositionalArgument(3);
			
				x = length.getValue();
				y = width.getValue();
				z = height.getValue();
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