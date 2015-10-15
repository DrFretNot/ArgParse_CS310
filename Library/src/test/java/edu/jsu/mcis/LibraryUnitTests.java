package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class LibraryUnitTests {

	@Test
    public void testForAddProgramNameAndReturnCorrectProgramName(){
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        assertEquals("VolumeCalculator", lib.getProgramName());   
    }
    
    @Test
    public void testForAddProgramDescriptionAndReturnCorrectProgramDescription(){
        Library lib = new Library();
        lib.addProgramDescription("Calculate the volume of a box");
        assertEquals("Calculate the volume of a box", lib.getProgramDescription());   
    }
    
    @Test
    public void testAddArgumentAndReturnCorrectName(){
    	Argument length = new Argument();
    	length.addElements("length");
    	assertEquals("length", length.getName()); 
    }
    
    @Test
    public void testAddArgumentInLibraryAndReturnCorrectArgumentInLibrary(){
    	Library lib = new Library();
    	Argument length = new Argument();
    	length.addElements("length", Library.argType.INTEGER, "the length of the box");
    	lib.addArgument(length);
    	Argument currentArg = lib.getArgument("length");
    	assertEquals("length", currentArg.getName());
    	assertEquals("integer", currentArg.getType());
    	assertEquals("the length of the box", currentArg.getDescription());
    }
    
    @Test
    public void testAddArgumentWithoutTypeAndReturnDefaultType(){
    	Argument length = new Argument();
    	length.addElements("length");
    	assertEquals("string", length.getType()); 
    }
    
    @Test
    public void testEnterArgNameAndTypeAndReturnCorrectInfo(){
        //Library lib = new Library();
        Argument one = new Argument();
        one.addElements("length",Library.argType.FLOAT);
        assertEquals("length", one.getName());
        assertEquals("float", one.getType());
    }
    
    @Test
    public void testAddArgumentWithDescriptionAndReturnCorrectDescriptionAndDefaultType(){
    	Argument length = new Argument();
    	length.addElements("length", "the length of the box");
    	assertEquals("the length of the box", length.getDescription());
    	assertEquals("string", length.getType());  
    }
    
    @Test
    public void testArgValuesFromCLIAssignedToCorrectArgument(){
    	String[] args = {"7", "5", "3"};
    	Library lib = new Library();
    	Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length");
    	width.addElements("width");
    	height.addElements("height");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){};
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    }
    
    @Test
    public void testParseReturnsCorrectExceptionMessageWhenGivenLessArgsThanSpecified(){
    	String[] args = {"1", "2"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: the following arguments are required: height", e.getMessage());
        }
	}

    @Test
    public void testParseReturnsCorrectExceptionMessageWhenGivenMoreArgsThanSpecified(){
    	String[] args = {"1", "2", "3", "10"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: unrecognized arguments: 10", e.getMessage());
        }
	}
	//commented out because it is not working with parse right now. We have to figure out how to check for the right
	//number of positional args out of all the args
    
    @Test
    public void testParseReturnsCorrectHelpExceptionMessage(){
    	String[] args = {"-h"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", e.getMessage());
        }
	}
	
	@Test
	public void testParseReturnsCorrectExceptionMessageWhenGivenIncorrectDataType(){
		String[] args = {"1", "something", "3"};
		Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", Library.argType.FLOAT, "the length of the box");
    	width.addElements("width", Library.argType.FLOAT, "the width of the box");
    	height.addElements("height", Library.argType.FLOAT, "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: argument width: invalid float value: something", e.getMessage());
        }
	}
    
    /*@Test
    public void testShortFormHelp() {
        String[] args = {"-h"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", e.getMessage());
        }
	}*/

    
    @Test
    public void testEnterLongFormHelpAndReturnCorrectMessage(){
        String[] args = {"--help"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	lib.addNamedArgument(new NamedArgument("help", Library.argType.BOOLEAN));
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", e.getMessage());
        }
    }
    
    @Test
    public void testParseReadsCorrectPositionalArgsWhenGivenNamedArgsAlso(){
    	String[] args = {"7", "--type", "pyramid", "5", "3"};
    	Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box"));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    }

	@Test
	public void testNamedArgValuesFromCLIAssignedToCorrectNamedArgument(){
		String[] args = {"7", "--type", "pyramid", "5", "3"};
    	Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	NamedArgument type = new NamedArgument("type", "box");
    	lib.addNamedArgument(type);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	NamedArgument currentArg = lib.getNamedArgument("type");
    	assertEquals("pyramid", currentArg.getValue());
	}

	@Test
	public void testBooleanNamedArgAssignedCorrectValueWhenCalledInCLI(){
		String[] args = {"7", "--help", "5", "3"};
    	Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	NamedArgument help = new NamedArgument("help", Library.argType.BOOLEAN);
    	lib.addNamedArgument(help);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	NamedArgument currentArg = lib.getNamedArgument("help");
    	assertEquals("true", currentArg.getValue());
	}

	@Test
	public void testParseReadsCorrectPositionalArgsWhenGivenBooleanNamedArgsAlso(){
		String[] args = {"7", "--helpful", "5", "3"};
    	Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	NamedArgument help = new NamedArgument("helpful", Library.argType.BOOLEAN);
    	lib.addNamedArgument(help);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
	}

	@Test
	public void testParseReadsCorrectArgumentsWhenGivenMultipleNamedArguments(){
		String[] args = {"7", "--type", "pyramid", "5", "3", "--digits", "1"};
    	Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        Argument length = new Argument();
    	Argument width = new Argument();
    	Argument height = new Argument();
    	length.addElements("length", "the length of the box");
    	width.addElements("width", "the width of the box");
    	height.addElements("height", "the height of the box");
    	lib.addArgument(length);
    	lib.addArgument(width);
    	lib.addArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box"));
    	lib.addNamedArgument(new NamedArgument("digits", "0", Library.argType.INTEGER));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    	NamedArgument type = lib.getNamedArgument("type");
    	assertEquals("pyramid", type.getValue());
    	NamedArgument digits = lib.getNamedArgument("digits");
    	assertEquals("1", digits.getValue());
	}


@Test
    public void testAddNamedArgumentAndReturnCorrectNameWithDefaultValue(){
    	NamedArgument type = new NamedArgument("type", "box");
		assertEquals("type", type.getName()); 
    }

	@Test
    public void testAddNamedArgumentAndReturnCorrectName(){
    	NamedArgument type = new NamedArgument("type");
		assertEquals("type", type.getName()); 
    }
    
    @Test
    public void testAddNamedArgumentAndReturnCorrectNameWithTypeValueAndDescription(){
    	NamedArgument type = new NamedArgument("IntType", Library.argType.INTEGER,"This is an integer" );
		assertEquals("IntType", type.getName()); 
		assertEquals("integer", type.getType()); 
		assertEquals("This is an integer", type.getDescription()); 
    }
    
     @Test
    public void testAddNamedArgumentAndReturnCorrectNameWithTypeValueAndDescriptionWithFloat(){
    	NamedArgument type = new NamedArgument("FloatType", Library.argType.FLOAT,"This is a float" );
		assertEquals("FloatType", type.getName()); 
		assertEquals("float", type.getType()); 
		assertEquals("This is a float", type.getDescription()); 
    }
    
    @Test
    public void testAddNamedArgumentAndReturnCorrectDefaultValue(){
    	NamedArgument type = new NamedArgument("type", "box");
		assertEquals("box", type.getValue());
    }
	
	@Test
    public void testAddNamedArgumentWithoutTypeAndReturnDefaultType(){
    	NamedArgument type = new NamedArgument("type", "box");
    	assertEquals("string", type.getType()); 
    }
	
    @Test
    public void testEnterNamedArgNameAndTypeAndReturnCorrectInfo(){
        NamedArgument help = new NamedArgument("help",Library.argType.BOOLEAN);
        assertEquals("help", help.getName());
        assertEquals("boolean", help.getType());
    }
	
    @Test
    public void testAddNamedArgumentWithDescriptionAndReturnCorrectDescriptionAndDefaultType(){
    	NamedArgument type = new NamedArgument("type", "box", "the shape of the object");
    	assertEquals("the shape of the object", type.getDescription());
    	assertEquals("string", type.getType());  
    } 	
	
 	@Test
    public void testAddNamedArgumentInLibraryAndReturnCorrectNamedArgumentInLibrary(){
    	Library lib = new Library();
    	lib.addNamedArgument(new NamedArgument("type", "box", Library.argType.STRING, "the shape of the object"));
    	NamedArgument currentArg = lib.getNamedArgument("type");
    	assertEquals("type", currentArg.getName());
    	assertEquals("box", currentArg.getValue());
    	assertEquals("string", currentArg.getType());
    	assertEquals("the shape of the object", currentArg.getDescription());
    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
