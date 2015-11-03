package edu.jsu.mcis;

import java.util.*;

public class ArgumentDoesNotExistException extends Exception{ //maybe runtime exception would be more efficient?
	public ArgumentDoesNotExistException(String message){
		super(message);
	}
}