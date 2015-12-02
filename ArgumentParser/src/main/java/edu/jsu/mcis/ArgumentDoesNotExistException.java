package edu.jsu.mcis;

import java.util.*;
import java.lang.*;

/**
*Thrown to indicate that an argument called from the command line has not been created
*
*/
public class ArgumentDoesNotExistException extends Exception{ //maybe runtime exception would be more efficient?
	
	/**
	*Constructs an ArgumentDoesNotExistException with the specified detail message.
	*@param message the detail message
	*/
	public ArgumentDoesNotExistException(String message){
		super(message);
	}
}