package edu.jsu.mcis;

import java.util.*;
/**
 *Thrown to indicate that a given argument value is not a possible value for that argument.
 *
 */
public class IncorrectArgumentValueException extends Exception{
    
    /**
	*Constructs an IncorrectArgumentValueException with the specified detail message.
	*@param message the detail message
	*/
	public IncorrectArgumentValueException(String message){
		super(message);
	}
}