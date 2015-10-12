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
    
    /*@Test
    public void testAddArgumentAndReturnDefault() {
    	Library lib = new Library();
    	lib.addArgName("length");
        assertEquals("", lib.getArgValue("length"));
    }*/
    
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
    
    /*@Test
    public void testArgumentPlacedInCorrectIndex(){
    	String[] args = {"7", "3", "2"};
    	Library lib = new Library();
    	lib.addArgName("length");
    	lib.addArgName("width");
    	lib.addArgName("height");
    	lib.addArgsFromCLI(args);
    	assertEquals("", lib.checkNumOfArgs(args));
    	assertEquals("7", lib.getArgValue("length"));
    	assertEquals("3", lib.getArgValue("width"));
    	assertEquals("2", lib.getArgValue("height"));
    }*/
    
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
    /*
    @Test
    public void testErrorThrownWhenGivenLessArgsThanSpecified(){
    	String[] args = {"7", "3"};
    	Library lib = new Library();
    	lib.addProgramName("VolumeCalculator");
    	lib.addArgName("length");
    	lib.addArgName("width");
    	lib.addArgName("height");
    	lib.addArgsFromCLI(args);
    	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: the following arguments are required: height", lib.checkNumOfArgs(args));
    }
    */
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

 	/*@Test
    public void testErrorThrownWhenGivenMoreArgsThanSpecified(){
    	String[] args = {"7", "3", "2", "10"};
    	Library lib = new Library();
    	lib.addProgramName("VolumeCalculator");
    	lib.addArgName("length");
    	lib.addArgName("width");
    	lib.addArgName("height");
    	lib.addArgsFromCLI(args);
    	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: unrecognized arguments: 10", lib.checkNumOfArgs(args));
    }*/
    
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
    /*
    @Test
    public void testHelpInformation(){
        String[] args = {"-h"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgName("length");
        lib.addArgDescription("the length of the box");
        lib.addArgName("width");
        lib.addArgDescription("the width of the box");
        lib.addArgName("height");
        lib.addArgDescription("the height of the box");
        lib.addArgsFromCLI(args);
        assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", lib.checkForHelpArg()); 
        
    }*/
    
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
	
	/*@Test
	public void testDataTypeOfAllArgsIsFloat(){
		
		Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgWithDataType("length", Library.argType.FLOAT);
        lib.addArgDescription("the length of the box");
        lib.addArgWithDataType("width", Library.argType.FLOAT);
        lib.addArgDescription("the width of the box");
        lib.addArgWithDataType("height", Library.argType.FLOAT);
        lib.addArgDescription("the height of the box");
		assertEquals(Library.argType.FLOAT, lib.getArgDataType("length"));
        assertEquals(Library.argType.FLOAT, lib.getArgDataType("width"));
        assertEquals(Library.argType.FLOAT, lib.getArgDataType("height"));
        
        
	}
	
	@Test
	public void testParseToCorrectDataType()
    {
        String[] args = {"1", "2", "3"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgWithDataType("length", Library.argType.FLOAT);
        lib.addArgDescription("the length of the box");
        lib.addArgWithDataType("width", Library.argType.FLOAT);
        lib.addArgDescription("the width of the box");
        lib.addArgWithDataType("height", Library.argType.FLOAT);
        lib.addArgDescription("the height of the box");
        lib.addArgsFromCLI(args);
        lib.parseDataType(args);
        assertEquals((float)1, lib.getParsedArgValue("length"));
        assertEquals((float)2, lib.getParsedArgValue("width"));
        assertEquals((float)3, lib.getParsedArgValue("height"));
	} 
	
	@Test
	public void testEnterInvalidDataTypeForArgumentAndReturnErrorMessage(){
		String[] args = {"1", "something", "3"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgWithDataType("length", Library.argType.FLOAT);
        lib.addArgDescription("the length of the box");
        lib.addArgWithDataType("width", Library.argType.FLOAT);
        lib.addArgDescription("the width of the box");
        lib.addArgWithDataType("height", Library.argType.FLOAT);
        lib.addArgDescription("the height of the box");
        lib.addArgsFromCLI(args);
        assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: argument width: invalid float value: something", lib.parseDataType(args));
	}*/
	
	
	/*
	//@Test
	public void testArgMultiUseCheckerReturnsCorrectMessage(){
		String[] helpArgs = {"-h"};
		String[] args = {"1", "something", "3"};
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgWithDataType("length", Library.argType.FLOAT);
        lib.addArgDescription("the length of the box");
        lib.addArgWithDataType("width", Library.argType.FLOAT);
        lib.addArgDescription("the width of the box");
        lib.addArgWithDataType("height", Library.argType.FLOAT);
        lib.addArgDescription("the height of the box");
        lib.addArgsFromCLI(helpArgs);
        assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", lib.argMultiUseChecker(helpArgs)); 
        lib.addArgsFromCLI(args);
        assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: argument width: invalid float value: something", lib.argMultiUseChecker(args));
        String[] lessArgs = {"1", "something"};
        assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: the following arguments are required: height", lib.argMultiUseChecker(lessArgs));
        String[] moreArgs = {"1", "something", "3", "10"};
        assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: unrecognized arguments: 10", lib.argMultiUseChecker(moreArgs));
	}*/
    

    /*@Test
    public void testForArgName(){
        Argument one = new Argument();
        one.addElements(arg[0], Library.argType.FLOAT, "length");
        one.getName();       
    }*/
    
    
    
   
	
	
	
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
        //need to figure out a way to have lowercase type values and not just return the enum
	}
    
    /*@Test
    public void testNamedArgumentTakesAndReturnCorrectName(){
        
        Library lib = new Library();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        lib.addArgument(new Argument("length"));
        lib.addArgument(new Argument("width"));
        lib.addArgument(new Argument("height"));
        lib.addArgument(new NamedArgument("--location"));
        
    }*/
    //need to make the name part of the constructor, but then will have to change when we add it to the argumentList
    //because if we add it to the argumentList first with just then name then add elements later, the argument instance in the 
    //list won't have the other elements
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
