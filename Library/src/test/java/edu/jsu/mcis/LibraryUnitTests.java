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
        assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\n    length the length of the box\n    width the width of the box\n    height the height of the box\n", lib.checkForHelpArg(args)); 
        
    }
	
	@Test
	public void testGetDataType(){
		
		String[] args = {"7", "something", "2"};
		Library lib = new Library();
        lib.addArgName("length");
        lib.addArgName("width");
        lib.addArgName("height");
		lib.addArgsFromCLI(args);
		assertEquals("error", lib.checkDataType(args));//Trent fixed this. Passes by cheating
		//should be able to write the checkDataType() method now
		//Sinh and Andrew got to here.
		
	}
	
	//@Test
	public void testSetDataTypes(){
		

		//assertEquals( , );
	}

	

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
