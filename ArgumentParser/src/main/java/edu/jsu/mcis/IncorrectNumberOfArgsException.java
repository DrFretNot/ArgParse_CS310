package edu.jsu.mcis;

import java.util.*;

/**
*Thrown to indicate that there are either too many or not enough arguments given than expected.
*
*/

public class IncorrectNumberOfArgsException extends Exception{
		
	/**
	*Constructs an IncorrectNumberOfArgsException with the specified detail message.
	*@param message the detail message
	*/
	public IncorrectNumberOfArgsException(String message){
		super(message);
	}
}