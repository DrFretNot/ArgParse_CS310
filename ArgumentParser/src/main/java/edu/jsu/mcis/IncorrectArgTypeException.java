package edu.jsu.mcis;

import java.util.*;

/**
*Thrown to indicate that an argument type expected is different from argument type given.
*
*/

public class IncorrectArgTypeException extends Exception{
	
	/**
	*Constructs an IncorrectArgTypeException with the specified detail message.
	*@param message the detail message
	*/
	public IncorrectArgTypeException(String message){
		super(message);
	}
}