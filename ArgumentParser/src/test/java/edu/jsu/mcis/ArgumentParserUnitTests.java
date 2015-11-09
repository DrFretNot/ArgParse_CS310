package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

public class ArgumentParserUnitTests {

	@Test
    public void testForAddProgramNameAndReturnCorrectProgramName(){
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        assertEquals("VolumeCalculator", lib.getProgramName());   
    }
    
    @Test
    public void testForAddProgramDescriptionAndReturnCorrectProgramDescription(){
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramDescription("Calculate the volume of a box");
        assertEquals("Calculate the volume of a box", lib.getProgramDescription());   
    }
    
    @Test
    public void testAddArgumentAndReturnCorrectName(){
    	PositionalArgument length = new PositionalArgument("length");
    	//length.addElements("length");
    	assertEquals("length", length.getName()); 
    }
    
    @Test
    public void testAddArgumentInArgumentParserAndReturnCorrectArgumentInArgumentParser(){
    	ArgumentParser lib = new ArgumentParser();
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.INTEGER, "the length of the box");
    	//length.addElements("length", Argument.ArgType.INTEGER, "the length of the box");
    	lib.addPositionalArgument(length);
    	PositionalArgument currentArg = lib.getPositionalArgument("length");
    	assertEquals("length", currentArg.getName());
    	assertEquals("integer", currentArg.getType());
    	assertEquals("the length of the box", currentArg.getDescription());
    }
    
    @Test
    public void testAddArgumentWithoutTypeAndReturnDefaultType(){
    	PositionalArgument length = new PositionalArgument("length");
    	//length.addElements("length");
    	assertEquals("string", length.getType()); 
    }
    
    @Test
    public void testEnterArgNameAndTypeAndReturnCorrectInfo(){
        PositionalArgument one = new PositionalArgument("length", Argument.ArgType.FLOAT);
        //one.addElements("length",Argument.ArgType.FLOAT);
        assertEquals("length", one.getName());
        assertEquals("float", one.getType());
    }
    
    @Test
    public void testAddArgumentWithDescriptionAndReturnCorrectDescriptionAndDefaultType(){
    	PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	//length.addElements("length", "the length of the box");
    	assertEquals("the length of the box", length.getDescription());
    	assertEquals("string", length.getType());  
    }
    
    @Test
    public void testAddNamedArgumentAndReturnCorrectNameWithDefaultValue(){
    	NamedArgument type = new NamedArgument("type", "box");
		assertEquals("type", type.getName()); 
    }

	@Test
    public void testAddNamedArgumentAndReturnCorrectName(){
    	NamedArgument type = new NamedArgument("type");
		assertEquals("type", type.getName()); 
    }
    
    @Test
    public void testAddNamedArgumentAndReturnCorrectNameWithTypeValueAndDescription(){
    	NamedArgument type = new NamedArgument("IntType", Argument.ArgType.INTEGER,"This is an integer" );
		assertEquals("IntType", type.getName()); 
		assertEquals("integer", type.getType()); 
		assertEquals("This is an integer", type.getDescription()); 
    }
    
     @Test
    public void testAddNamedArgumentAndReturnCorrectNameWithTypeValueAndDescriptionWithFloat(){
    	NamedArgument type = new NamedArgument("FloatType", Argument.ArgType.FLOAT,"This is a float" );
		assertEquals("FloatType", type.getName()); 
		assertEquals("float", type.getType()); 
		assertEquals("This is a float", type.getDescription()); 
    }
    
    @Test
    public void testAddNamedArgumentAndReturnCorrectDefaultValue(){
    	NamedArgument type = new NamedArgument("type", "box");
		assertEquals("box", type.getValue());
    }
	
	@Test
    public void testAddNamedArgumentWithoutTypeAndReturnDefaultType(){
    	NamedArgument type = new NamedArgument("type", "box");
    	assertEquals("string", type.getType()); 
    }
	
    @Test
    public void testEnterNamedArgNameAndTypeAndReturnCorrectInfo(){
        NamedArgument help = new NamedArgument("help",Argument.ArgType.BOOLEAN);
        assertEquals("help", help.getName());
        assertEquals("boolean", help.getType());
    }
	
    @Test
    public void testAddNamedArgumentWithDescriptionAndReturnCorrectDescriptionAndDefaultType(){
    	NamedArgument type = new NamedArgument("type", "box", "the shape of the object");
    	assertEquals("the shape of the object", type.getDescription());
    	assertEquals("string", type.getType());  
    } 	
	
 	@Test
    public void testAddNamedArgumentInArgumentParserAndReturnCorrectNamedArgumentInArgumentParser(){
    	ArgumentParser lib = new ArgumentParser();
    	lib.addNamedArgument(new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object"));
    	NamedArgument currentArg = lib.getNamedArgument("type");
    	assertEquals("type", currentArg.getName());
    	assertEquals("box", currentArg.getValue());
    	assertEquals("string", currentArg.getType());
    	assertEquals("the shape of the object", currentArg.getDescription());
    }


	@Test
	public void testAddingFloatAndBooleanArgumentsAndParseValuesCorrectly(){
		String[] args = {"7","8","9","TRUE"};
		ArgumentParser lib = new ArgumentParser();
		PositionalArgument length =new PositionalArgument("length", Argument.ArgType.INTEGER, "the length of the box");
		PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the box");
		PositionalArgument height = new PositionalArgument("height", Argument.ArgType.INTEGER, "the height of the box");
		PositionalArgument fact = new PositionalArgument("fact", Argument.ArgType.BOOLEAN, "the validity of the fact");
		
		//length.addElements("length", Argument.ArgType.INTEGER, "the length of the box");
    	//width.addElements("width", Argument.ArgType.FLOAT, "the width of the box");
    	//height.addElements("height", Argument.ArgType.INTEGER, "the height of the box");
    	//fact.addElements("fact", Argument.ArgType.BOOLEAN, "the validity of the fact");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
	 	lib.addPositionalArgument(height);
    	lib.addPositionalArgument(fact);
    	
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	
    	assertEquals(7, length.getValue());
    	assertEquals((float)8.0,width.getValue());
    	assertEquals(9, height.getValue());
    	assertEquals(true, fact.getValue());	
	}

    
    @Test
    public void testArgValuesFromCLIAssignedToCorrectArgument(){
    	String[] args = {"7", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
    	PositionalArgument length = new PositionalArgument("length");
    	PositionalArgument width = new PositionalArgument("width");
    	PositionalArgument height = new PositionalArgument("height");
    	//length.addElements("length");
    	//width.addElements("width");
    	//height.addElements("height");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){};
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    }
    
    @Test
    public void testParseReturnsCorrectExceptionMessageWhenGivenLessArgsThanSpecified(){
    	String[] args = {"1", "2"};
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: the following arguments are required: height", e.getMessage());
        }
	}

    @Test
    public void testParseReturnsCorrectExceptionMessageWhenGivenMoreArgsThanSpecified(){
    	String[] args = {"1", "2", "3", "10"};
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: unrecognized arguments: 10", e.getMessage());
        }
	}
	
    @Test
    public void testParseReturnsCorrectHelpExceptionMessage(){
    	String[] args = {"-h"};
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("help", "false", Argument.ArgType.BOOLEAN, 'h'));
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", e.getMessage());
        }
	}
	
	@Test
	public void testParseReturnsCorrectExceptionMessageWhenGivenIncorrectDataType(){
		String[] args = {"1", "something", "3"};
		ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", Argument.ArgType.INTEGER, "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.INTEGER, "the height of the box");
    	//length.addElements("length", Argument.ArgType.INTEGER, "the length of the box");
    	//width.addElements("width", Argument.ArgType.FLOAT, "the width of the box");
    	//height.addElements("height", Argument.ArgType.INTEGER, "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: argument width: invalid float value: something", e.getMessage());
        }
	}
    
 

    
    @Test
    public void testEnterLongFormHelpAndReturnCorrectMessage(){
        String[] args = {"--help"};
        ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("help", Argument.ArgType.BOOLEAN));
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", e.getMessage());
        }
    }
    
    @Test
    public void testParseReadsCorrectPositionalArgsWhenGivenNamedArgsAlso(){
    	String[] args = {"7", "--type", "pyramid", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box"));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    }

	@Test
	public void testNamedArgValuesFromCLIAssignedToCorrectNamedArgument(){
		String[] args = {"7", "--type", "pyramid", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	NamedArgument type = new NamedArgument("type", "box");
    	lib.addNamedArgument(type);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	NamedArgument currentArg = lib.getNamedArgument("type");
    	assertEquals("pyramid", currentArg.getValue());
	}

	@Test
	public void testBooleanNamedArgAssignedCorrectValueWhenCalledInCLI(){
		String[] args = {"7", "--help", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	NamedArgument help = new NamedArgument("help", Argument.ArgType.BOOLEAN);
    	lib.addNamedArgument(help);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	NamedArgument currentArg = lib.getNamedArgument("help");
    	assertEquals("true", currentArg.getValue());
	}

	@Test
	public void testParseReadsCorrectPositionalArgsWhenGivenBooleanNamedArgsAlso(){
		String[] args = {"7", "--helpful", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	NamedArgument help = new NamedArgument("helpful", Argument.ArgType.BOOLEAN);
    	lib.addNamedArgument(help);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
	}

	@Test
	public void testParseReadsCorrectArgumentsWhenGivenMultipleNamedArguments(){
		String[] args = {"7", "--type", "pyramid", "5", "3", "--digits", "1"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box"));
    	lib.addNamedArgument(new NamedArgument("digits", "0", Argument.ArgType.INTEGER));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    	NamedArgument type = lib.getNamedArgument("type");
    	assertEquals("pyramid", type.getValue());
    	NamedArgument digits = lib.getNamedArgument("digits");
    	assertEquals(1, digits.getValue());
	}
	
	@Test
	public void testParseReadsCorrectArgumentsWhenGivenShortFormNamedArguments(){
		String[] args = {"7", "-t", "pyramid", "5", "3", "-d", "6"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box", 't'));
    	lib.addNamedArgument(new NamedArgument("digits", "0", Argument.ArgType.INTEGER, 'd'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("", e);
    	}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    	NamedArgument type = lib.getNamedArgument("type");
    	assertEquals("pyramid", type.getValue());
    	NamedArgument digits = lib.getNamedArgument("digits");
    	assertEquals(6, digits.getValue());
	}
	
	@Test
	public void testParseReadsCorrectArgumentsWhenGivenShortFormFlagsCombinedInSingleSpecification(){
		String[] args = {"7", "-dap", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("dark", "false", Argument.ArgType.BOOLEAN, 'd'));
    	lib.addNamedArgument(new NamedArgument("appropriate", "false", Argument.ArgType.BOOLEAN, 'a'));
    	lib.addNamedArgument(new NamedArgument("pink", "false", Argument.ArgType.BOOLEAN, 'p'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("", e);
    	}
    	assertEquals("7", length.getValue());
    	assertEquals("5", width.getValue());
    	assertEquals("3", height.getValue());
    	NamedArgument dark = lib.getNamedArgument("dark");
    	assertEquals("true", dark.getValue());
    	NamedArgument appropriate = lib.getNamedArgument("appropriate");
    	assertEquals("true", appropriate.getValue());
    	NamedArgument pink = lib.getNamedArgument("pink");
    	assertEquals("true", pink.getValue());
	}
	
	@Test
	public void testParseThrowsHelpExceptionWhenGivenShortFormHelpArgument(){
		String[] args = {"7", "-h", "5", "3"};
		ArgumentParser lib = new ArgumentParser();
    	lib.addProgramName("VolumeCalculator");
    	lib.addProgramDescription("Calculate the volume of a box.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the box");
    	//length.addElements("length", Argument.ArgType.FLOAT, "the length of the box");
    	//width.addElements("width", Argument.ArgType.FLOAT, "the width of the box");
    	//height.addElements("height", Argument.ArgType.FLOAT, "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("help", "false", Argument.ArgType.BOOLEAN, 'h'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box", e.getMessage());
    	}
	}

	@Test
	public void testParseThrowsCorrectExceptionWhenGivenIncorrectDataTypeAndNamedHelpArgument(){
		String[] args = {"7", "something", "2"};
		ArgumentParser lib = new ArgumentParser();
    	lib.addProgramName("Volume Calculator");
    	lib.addProgramDescription("Calculate the volume of a box.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the box (float)");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the box (float)");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the box (float)");
    	//length.addElements("length", Argument.ArgType.FLOAT, "the length of the box (float)");
    	//width.addElements("width", Argument.ArgType.FLOAT, "the width of the box (float)");
    	//height.addElements("height", Argument.ArgType.FLOAT, "the height of the box (float)");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("help", "false", Argument.ArgType.BOOLEAN));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java Volume Calculator length width height\nVolume Calculator.java: error: argument width: invalid float value: something", e.getMessage());
    	}
    }
	
	@Test
	public void testPositionalArgumentHoldsPosition(){
		ArgumentParser lib = new ArgumentParser();
    	lib.addProgramName("Volume Calculator");
    	lib.addProgramDescription("Calculate the volume of a box.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the box (float)");
    	//length.addElements("length", Argument.ArgType.FLOAT, "the length of the box (float)");
    	lib.addPositionalArgument(length);
		assertEquals(0, length.getPosition());
	}
	
    @Test
	public void testAddingNamedArgumentWithShortFormAndReturnCorrectShortForm(){
		NamedArgument type = new NamedArgument("type", 't');
    	assertEquals('t', type.getShortFormName());  	
	} 
    @Test
	public void testAddingNamedArgumentWithShortFormAndValueThenReturnCorrectShortForm(){
		NamedArgument type = new NamedArgument("type", "new value",'t');
    	assertEquals('t', type.getShortFormName());  	
	}
	 @Test
	public void testAddingNamedArgumentWithShortFormAndDataTypeThenReturnCorrectShortForm(){
		NamedArgument type = new NamedArgument("type", Argument.ArgType.STRING,'t');
    	assertEquals('t', type.getShortFormName());  	
	}
    
    @Test
	public void testAddingNamedArgumentWithShortFormAndValueAndDataTypeThenReturnCorrectShortForm(){
		NamedArgument type = new NamedArgument("type", "value",Argument.ArgType.STRING,'t');
    	assertEquals('t', type.getShortFormName());  	
	}
	@Test
	public void testAddingNamedArgumentWithShortFormAndValueAndDescriptionThenReturnCorrectShortForm(){
		NamedArgument type = new NamedArgument("type", "value", "this is a type",'t');
    	assertEquals('t', type.getShortFormName());  	
	}
    @Test
	public void testAddingNamedArgumentWithShortFormAndDataTypeAndDescriptionThenReturnCorrectShortForm(){
		NamedArgument type = new NamedArgument("type", Argument.ArgType.STRING, "This is a type", 't');
    	assertEquals('t', type.getShortFormName());  	
	}
	
	@Test
	public void testAddingNamedArgumentWithShortFormAndValueAndDataTypeAndDescriptionThenReturnCorrectShortForm(){
		NamedArgument type = new NamedArgument("type", "value", Argument.ArgType.STRING, "This is a type", 't');
    	assertEquals('t', type.getShortFormName());  	
	}
	
	@Test
	public void testAddNamedArgumentWithShortFormAndReturnCorrectNamedArgumentInArgumentParserUsingShortFormName(){
		ArgumentParser lib = new ArgumentParser();
		lib.addNamedArgument(new NamedArgument("type", 't'));
		NamedArgument arg = lib.getNamedArgument('t');
		assertEquals("type", arg.getName());
	}
    
    @Test
    public void testParseThrowsArgumentDoesNotExistExeptionForNamedArguments(){
    	String[] args = {"7", "--myarg", "myval", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box", 't'));
    	lib.addNamedArgument(new NamedArgument("digits", "0", Argument.ArgType.INTEGER, 'd'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator length width height\nVolumeCalculator.java: error: argument myarg does not exist", e.getMessage());
    	}
    }
    
    @Test
    public void testParseThrowsIncorrectArgTypeExceptionForNamedArguments(){
    	String[] args = {"7", "-d", "myval", "5", "3"};
    	ArgumentParser lib = new ArgumentParser();
        lib.addProgramName("VolumeCalculator");
        lib.addProgramDescription("Calculate the volume of a box.");
        PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addNamedArgument(new NamedArgument("type", "box", 't'));
    	lib.addNamedArgument(new NamedArgument("digits", "0", Argument.ArgType.INTEGER, 'd'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator type digits\nVolumeCalculator.java: error: argument digits: invalid integer value: myval", e.getMessage());
    	}
    }
    
    @Test
    public void testGetArgumentReturnCorrectArgumentBySearchingForPosition(){
    	ArgumentParser lib = new ArgumentParser();
    	PositionalArgument length = new PositionalArgument("length", "the length of the box");
    	PositionalArgument width = new PositionalArgument("width", "the width of the box");
    	PositionalArgument height = new PositionalArgument("height", "the height of the box");
    	//length.addElements("length", "the length of the box");
    	//width.addElements("width", "the width of the box");
    	//height.addElements("height", "the height of the box");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	PositionalArgument arg1 = lib.getPositionalArgument(0);
    	assertEquals("length", arg1.getName());
    	PositionalArgument arg2 = lib.getPositionalArgument(1);
    	assertEquals("width", arg2.getName());
    	PositionalArgument arg3 = lib.getPositionalArgument(2);
    	assertEquals("height", arg3.getName());
    }

	
	@Test//XML file location specific to individual computer
	public void testImportingXMLFileStoresCorrectInfoForEachArgumentFromOutsideOfArgumentParser(){
		String[] args = {"7", "-t", "pyramid", "5", "2"};
		try{
			AddXMLArguments xml = new AddXMLArguments();
			
			
			
			
			//for Katie's only
			ArgumentParser lib = xml.addArgumentsFromXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			
			//for Trent's only
			//ArgumentParser lib = xml.addArgumentsFromXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/Arguments.xml");
			
			
			/*
			//This section should work, but gives initialization issues or other issues 
			//checks if the XML File exists
			
			ArgumentParser lib = new ArgumentParser();
			File varTempDir = new File("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			boolean exists = varTempDir.exists();
			if (varTempDir.isDirectory()){
				//Katie
				ArgumentParser lib = xml.addArgumentsFromXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			}
			varTempDir = new File("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			exists = varTempDir.exists();
			
			if (varTempDir.isDirectory()){
				//Trent
				ArgumentParser lib = xml.addArgumentsFromXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/Arguments.xml");
			}
			
			else{ArgumentParser lib = new ArgumentParser();}
			*/
			
			
			
			
			try{
			lib.parse(args);
			}
			catch(Exception e){
				assertEquals("", e);
			}
			assertEquals("VolumeCalculator", lib.getProgramName());
			assertEquals("Calculate the volume of a specified object.", lib.getProgramDescription());
			PositionalArgument length = lib.getPositionalArgument(0);
			PositionalArgument width = lib.getPositionalArgument(1);
			PositionalArgument height = lib.getPositionalArgument(2);
			assertEquals((float)7.0, length.getValue());
			assertEquals((float)5.0, width.getValue());
			assertEquals((float)2.0, height.getValue());
			assertEquals("the height of the object", height.getDescription());
			NamedArgument type = lib.getNamedArgument('t');
			assertEquals("pyramid", type.getValue());
			NamedArgument digits = lib.getNamedArgument('d');
			assertEquals(4, digits.getValue());
		}
		catch(Exception e){
			assertEquals("", e);
		}
	
	}
	
	/*@Test
	public void test*/
	
}

    