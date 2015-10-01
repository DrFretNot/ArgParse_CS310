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
    public void testAddArgumentAndReturnDefault() {
    	Library lib = new Library();
    	lib.addArgName("length");
        assertEquals("", lib.getArgValue("length"));
    }
    
    @Test
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
    }
    
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

 	@Test
    public void testErrorThrownWhenGivenMoreArgsThanSpecified(){
    	String[] args = {"7", "3", "2", "10"};
    	Library lib = new Library();
    	lib.addProgramName("VolumeCalculator");
    	lib.addArgName("length");
    	lib.addArgName("width");
    	lib.addArgName("height");
    	lib.addArgsFromCLI(args);
    	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: unrecognized arguments: 10", lib.checkNumOfArgs(args));
    }
    
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
        
    }
	
	@Test
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
        assertEquals(1.0, lib.getParsedArgValue("length"));
        assertEquals(2.0, lib.getParsedArgValue("width"));
        assertEquals(3.0, lib.getParsedArgValue("height"));
	} 
  
}
    
