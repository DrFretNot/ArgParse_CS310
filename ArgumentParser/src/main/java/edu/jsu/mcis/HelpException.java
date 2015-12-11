package edu.jsu.mcis;

import java.util.*;

/**
*Thrown to display a list of available options for the user.
*
*/

public class HelpException extends Exception{
	
	/**
	*Constructs a HelpException with the specified available options.
	*@param message the detail message
	*/
	
	public HelpException(String message){
		super(message);
	}
}
    