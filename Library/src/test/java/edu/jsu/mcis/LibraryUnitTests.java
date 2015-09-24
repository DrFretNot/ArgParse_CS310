package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class LibraryUnitTests {
    
    @Test
    public void testAddArgumentAndReturnDefault() {
    	Library l = new Library();
    	l.addArgName("length");
        assertEquals("", l.getArgValue("length"));
        //assert(false);
    }
    
    /*@Test
    public void testReverseIt() {
        HelloWorld h = new HelloWorld();
        assertEquals("dlrow olleh", h.reverseIt());
    }*/
        
}
