package edu.jsu.mcis;

import java.util.*;
/**
 *
 *Class description: Exception class for incorrect argument values which extends Exception.
 *
 */
public class IncorrectArgumentValueException extends Exception{
    
    /**
     *
     *@param IncorrectArgumentValueException throws exception for an invalid argument to be used. 
     *
     */
	public IncorrectArgumentValueException(String message){
		super(message);
	}
}