import edu.jsu.mcis.*;
import java.util.*;

public class VolumeCalculatorWithXML 
{

    public static void main (String args[]) {
        float x = 0;
        float y = 0;
        float z = 0;
          
        try{
        	ArgumentParser lib = XMLReader.readXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/demos2/ArgumentsDemo.xml");
			/*AddXMLArguments xml = new AddXMLArguments();
		
			//Katie Location
			//Library lib = xml.addArgumentsFromXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
		
			//Trent Location
			Library lib = xml.addArgumentsFromXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/Arguments.xml");*/
			
			
			
			
			
			
			
			try{
				lib.parse(args);
				PositionalArgument<Float> length = lib.getPositionalArgument(0);
				PositionalArgument<Float> width = lib.getPositionalArgument(1);
				PositionalArgument<Integer> height = lib.getPositionalArgument(2);
			
				x = length.getValue();
				y = width.getValue();
				z = height.getValue();
				NamedArgument<String> type = lib.getNamedArgument("type");
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