package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class LibraryUnitTests {
    
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
    	assertEquals("7", lib.getArgValue("length"));
    	assertEquals("3", lib.getArgValue("width"));
    	assertEquals("2", lib.getArgValue("height"));
    }
    
    @Test
    public void testErrorThrownWhenGivenLessArgsThanSpecified(){
    	String[] args = {"7", "3"};
    	Library lib = new Library();
    	lib.addArgName("length");
    	lib.addArgName("width");
    	lib.addArgName("height");
    	lib.addArgsFromCLI(args);
    	assertEquals("Error", lib.checkNumOfArgs(args));
    }
//    "usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: the following arguments are required: height"
 
}
