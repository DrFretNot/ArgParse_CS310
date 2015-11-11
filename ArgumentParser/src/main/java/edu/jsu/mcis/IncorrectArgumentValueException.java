package edu.jsu.mcis;

import java.util.*;

public class IncorrectArgumentValueException extends Exception{ //maybe runtime exception would be more efficient?
	public IncorrectArgumentValueException(String message){
		super(message);
	}
}