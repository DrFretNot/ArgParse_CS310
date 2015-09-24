package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class LibraryUnitTests {
    
    @Test
    public void testAddArgumentAndReturnDefault() {
    	Library l = new Library();
    	l.addArgName("length");
        assertEquals("", l.getArgValue("length"));
    }
    
    
        
}
