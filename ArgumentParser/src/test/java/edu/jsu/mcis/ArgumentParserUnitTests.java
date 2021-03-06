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
    public void testAddArgumentAndNullValues(){
    	PositionalArgument length = new PositionalArgument("length");
    	assertEquals("length", length.getName()); 
        assertEquals("", length.getDescription());
        assertEquals("string", length.getType());
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
        	assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: the following arguments are required: height", e.getMessage());
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
        	assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: unrecognized arguments: 10", e.getMessage());
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
    	lib.addNamedArgument(new NamedArgument("help", "false", Argument.ArgType.BOOLEAN, "usage information", 'h'));
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator required: length width height\nCalculate the volume of a box.\npositional arguments:\n[length] (string) the length of the box\n[width] (string) the width of the box\n[height] (string) the height of the box\nnamed arguments:\n[--help] [-h] (boolean) usage information (optional)", e.getMessage());
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
        	assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: argument width: invalid float value: something", e.getMessage());
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
    	lib.addNamedArgument(new NamedArgument("help", Argument.ArgType.BOOLEAN, "usage information", 'h'));
        try{
        	lib.parse(args);
        }
        catch(Exception e){
        	assertEquals("usage: java VolumeCalculator required: length width height\nCalculate the volume of a box.\npositional arguments:\n[length] (string) the length of the box\n[width] (string) the width of the box\n[height] (string) the height of the box\nnamed arguments:\n[--help] [-h] (boolean) usage information (optional)", e.getMessage());
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
    	assertEquals(true, currentArg.getValue());
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
    	assertEquals(true, dark.getValue());
    	NamedArgument appropriate = lib.getNamedArgument("appropriate");
    	assertEquals(true, appropriate.getValue());
    	NamedArgument pink = lib.getNamedArgument("pink");
    	assertEquals(true, pink.getValue());
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
    	lib.addNamedArgument(new NamedArgument("help", "false", Argument.ArgType.BOOLEAN, "usage information", 'h'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator required: length width height\nCalculate the volume of a box.\npositional arguments:\n[length] (float) the length of the box\n[width] (float) the width of the box\n[height] (float) the height of the box\nnamed arguments:\n[--help] [-h] (boolean) usage information (optional)", e.getMessage());
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
    		assertEquals("usage: java Volume Calculator required: length width height\nVolume Calculator.java: error: argument width: invalid float value: something", e.getMessage());
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
    		assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: argument myarg does not exist", e.getMessage());
    	}
    }
    
    @Test
    public void testParseThrowsArgumentDoesNotExistExeptionForShortFormNamedArguments(){
    	String[] args = {"7", "-m", "myval", "5", "3"};
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
    		assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: argument m does not exist", e.getMessage());
    	}
    }
    
    @Test
    public void testParseThrowsArgumentDoesNotExistExeptionForShortFormNamedArgumentFlags(){
    	String[] args = {"7", "-hm", "5", "3"};
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
    	lib.addNamedArgument(new NamedArgument("help", Argument.ArgType.BOOLEAN, 'h'));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: argument m does not exist", e.getMessage());
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
    		assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: argument digits: invalid integer value: myval", e.getMessage());
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
    	PositionalArgument arg1 = lib.getPositionalArgument(1);
    	assertEquals("length", arg1.getName());
    	PositionalArgument arg2 = lib.getPositionalArgument(2);
    	assertEquals("width", arg2.getName());
    	PositionalArgument arg3 = lib.getPositionalArgument(3);
    	assertEquals("height", arg3.getName());
    }

	
	@Test//XML file location specific to individual computer
	public void testImportingXMLFileStoresCorrectInfoForEachArgumentFromOutsideOfArgumentParser(){
		String[] args = {"7", "-t", "pyramid", "5", "2", "true"};
		try{
			//XMLReader xml = new XMLReader();
			
			
			
			
			//for Katie's only
			//ArgumentParser lib = XMLReader.readXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/Arguments.xml");
			
			//for Trent's only
			ArgumentParser lib = XMLReader.readXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/Arguments.xml");
			
            //for andrew's only
            //ArgumentParser lib = XMLReader.readXMLFile("C:/Users/Andrew/Documents/GitHub/ArgParse_CS310/Arguments.xml");
			
			try{
				lib.parse(args);
			}
			catch(Exception e){
				assertEquals("", e);
			}
			assertEquals("VolumeCalculator", lib.getProgramName());
			assertEquals("Calculate the volume of a specified object.", lib.getProgramDescription());
			PositionalArgument length = lib.getPositionalArgument(1);
			PositionalArgument width = lib.getPositionalArgument(2);
			PositionalArgument height = lib.getPositionalArgument(3);
			PositionalArgument rainy = lib.getPositionalArgument(4);
			assertEquals(7, length.getValue());
			assertEquals((float)5.0, width.getValue());
			assertEquals("2", height.getValue());
			assertEquals(true, rainy.getValue());
			assertEquals("the height of the object", height.getDescription());
			NamedArgument type = lib.getNamedArgument('t');
			assertEquals("pyramid", type.getValue());
			NamedArgument digits = lib.getNamedArgument('d');
			assertEquals(4, digits.getValue());
			NamedArgument number = lib.getNamedArgument("number");
			assertEquals((float)1.0, number.getValue());
			NamedArgument large = lib.getNamedArgument('l');
			assertEquals(false, large.getValue());
		}
		catch(Exception e){
			assertEquals("", e);
		}
	
	}
	
	@Test
	public void testWriteAllInformationToXMLFileAndReadBackInCorrectInfo(){
		String[] args = {"7", "-t", "pyramid", "5", "2"};
		ArgumentParser lib = new ArgumentParser();
		lib.addProgramName("VolumeCalculator");
		lib.addProgramDescription("Calculate the volume of an object.");
		String[] lengthValueSet = {"7.0", "8.0", "9.0"};
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the object", lengthValueSet);
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the object");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the object");
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	String[] typeValueSet = {"box", "pyramid", "ellipsoid"};
    	NamedArgument type = new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object", 't', typeValueSet);
    	NamedArgument digits = new NamedArgument("digits", "4", Argument.ArgType.INTEGER, "the number of decimal digits to truncate at", 'd');
    	lib.addNamedArgument(type);
    	lib.addNamedArgument(digits);
    	
    	//lib.writeToXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/ArgumentParser.xml");
    	lib.writeToXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/ArgumentParser.xml");

    	//lib.writeToXMLFile("C:/Users/Andrew/Documents/GitHub/ArgParse_CS310/ArgumentParser.xml");
    	try{
    		//ArgumentParser newLib = XMLReader.readXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/ArgumentParser.xml");
    		//ArgumentParser newLib = XMLReader.readXMLFile("C:/Users/Andrew/Documents/GitHub/ArgParse_CS310/ArgumentParser.xml");
    		ArgumentParser newLib = XMLReader.readXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/ArgumentParser.xml");

    		try{
    			newLib.parse(args);
    		}
    		catch(Exception e){
    			assertEquals("", e);
    		}
    		assertEquals("VolumeCalculator", newLib.getProgramName());
			assertEquals("Calculate the volume of an object.", newLib.getProgramDescription());
			PositionalArgument newLength = newLib.getPositionalArgument(1);
			PositionalArgument newWidth = newLib.getPositionalArgument(2);
			PositionalArgument newHeight = newLib.getPositionalArgument(3);
			assertEquals(lengthValueSet, newLength.getValueSet());
			assertEquals((float)7.0, newLength.getValue());
			assertEquals((float)5.0, newWidth.getValue());
			assertEquals((float)2.0, newHeight.getValue());
			assertEquals("the height of the object", newHeight.getDescription());
			NamedArgument newType = newLib.getNamedArgument('t');
			assertEquals(typeValueSet, newType.getValueSet());
			assertEquals("pyramid", newType.getValue());
			NamedArgument newDigits = newLib.getNamedArgument('d');
			assertEquals(4, newDigits.getValue());
    		
		}
		catch(Exception e){
			assertEquals("", e);
		}
	}
	
	@Test
	public void testAddSetOfValuesToArgumentAndReturnCorrectSetOfValues(){
		String[] rainySet = {"true", "false", "True", "False"};
		String[] typeSet = {"box", "pyramid", "ellipsoid"};
		PositionalArgument rainy = new PositionalArgument("rainy", Argument.ArgType.BOOLEAN, "True if it is rainy", rainySet);
		NamedArgument type = new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object", 't', typeSet);
		assertEquals(rainySet, rainy.getValueSet());
		assertEquals(typeSet, type.getValueSet()); 
	}
	
	@Test
	public void testParseThrowsExceptionWhenGivenIncorrectNamedArgumentValue(){
		String[] args = {"7", "-t", "frustum", "5", "2"};
		ArgumentParser lib = new ArgumentParser();
		lib.addProgramName("VolumeCalculator");
		lib.addProgramDescription("Calculate the volume of an object.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the object");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the object");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the object");
    	String[] rainySet = {"true", "false", "True", "False"};
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	String[] typeValues = {"box", "pyramid", "ellipsoid"};
    	NamedArgument type = new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object", 't', typeValues);
    	NamedArgument digits = new NamedArgument("digits", "4", Argument.ArgType.INTEGER, "the number of decimal digits to truncate at", 'd');
    	lib.addNamedArgument(type);
    	lib.addNamedArgument(digits); 
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator required: length width height\nVolumeCalculator.java: error: argument type: invalid value: frustum", e.getMessage());
    	}
		
	}
	
	@Test
	public void testParseThrowsExceptionWhenGivenIncorrectPositionalArgumentValue(){
		String[] args = {"7", "-t", "pyramid", "5", "2", "6"};
		ArgumentParser lib = new ArgumentParser();
		lib.addProgramName("VolumeCalculator");
		lib.addProgramDescription("Calculate the volume of an object.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the object");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the object");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the object");
    	String[] numberSet = {"1", "2", "3", "4"};
    	PositionalArgument number = new PositionalArgument("number", Argument.ArgType.INTEGER, "the number of objects", numberSet);
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addPositionalArgument(number);
    	String[] typeValues = {"box", "pyramid", "ellipsoid"};
    	NamedArgument type = new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object", 't', typeValues);
    	NamedArgument digits = new NamedArgument("digits", "4", Argument.ArgType.INTEGER, "the number of decimal digits to truncate at", 'd');
    	lib.addNamedArgument(type);
    	lib.addNamedArgument(digits); 
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator required: length width height number\nVolumeCalculator.java: error: argument number: invalid value: 6", e.getMessage());
    	}
		
	}
	
	@Test
	public void testParseThrowsExceptionWhenGivenIncorrectPositionalArgumentValueWithStringValueSet(){
		String[] args = {"7", "-t", "pyramid", "5", "2", "6"};
		ArgumentParser lib = new ArgumentParser();
		lib.addProgramName("VolumeCalculator");
		lib.addProgramDescription("Calculate the volume of an object.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the object");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.FLOAT, "the width of the object");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.FLOAT, "the height of the object");
    	String[] numberSet = {"1", "2", "3", "4"};
    	PositionalArgument number = new PositionalArgument("number", "the number of objects", numberSet);
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	lib.addPositionalArgument(number);
    	String[] typeValues = {"box", "pyramid", "ellipsoid"};
    	NamedArgument type = new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object", 't', typeValues);
    	NamedArgument digits = new NamedArgument("digits", "4", Argument.ArgType.INTEGER, "the number of decimal digits to truncate at", 'd');
    	lib.addNamedArgument(type);
    	lib.addNamedArgument(digits); 
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator required: length width height number\nVolumeCalculator.java: error: argument number: invalid value: 6", e.getMessage());
    	}	
	}
	
	@Test
	public void testParseAddsCorectValueToPositionalArgumentWithStringValueSet(){
		String[] args = {"cat"};
		ArgumentParser lib = new ArgumentParser();
		String[] animalSet = {"cat", "dog", "bunny"};
		PositionalArgument animal = new PositionalArgument("animal", "the type of animal", animalSet);
		lib.addPositionalArgument(animal);
		try{
			lib.parse(args);
		}
		catch(Exception e){}
		assertEquals("cat", animal.getValue());
	}
	
	@Test
	public void testParseAddsCorectValueToNamedArgumentWithValueSet(){
		String[] args = {"--number", "2", "--decimal", "3.0"};
		ArgumentParser lib = new ArgumentParser();
		String[] numberSet = {"1", "2", "3"};
		String[] decimalSet = {"1.0", "2.0", "3.0"};
		NamedArgument number = new NamedArgument("number", Argument.ArgType.INTEGER, numberSet);
		NamedArgument decimal = new NamedArgument("decimal", Argument.ArgType.FLOAT, decimalSet);		
		lib.addNamedArgument(number);
		lib.addNamedArgument(decimal);
		try{
			lib.parse(args);
		}
		catch(Exception e){}
		assertEquals(2, number.getValue());
		assertEquals((float)3.0, decimal.getValue());
	}
	
    @Test
    public void NamedArgumentConstructorWithValueSetTest() {
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void NamedArgumentConstructorWithValuesandDataType() {
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", Argument.ArgType.STRING,testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void NamedArgumentConstructorWithValuesandDataTypeandArgumentDescription() {
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", Argument.ArgType.STRING, "different types of calculations", testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void NamedArgumentConstructorWithNameDefaultValueAndValueSet() {
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", "cube", testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void NamedArgumentConstructorWithNameDefaultValueandDescriptioinAndValueSet() {
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", "cube", "different types of calculations", testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void NamedArgumentConstructorWithNameValueTypeAndDefaultValueandDescriptioinAndValueSet() {
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", "cube", Argument.ArgType.STRING, "different types of calculations", testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentWithShortFormAndValueSet(){
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type",'t',testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentWithValueSetWithDefaultValueAndDataType(){
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", "cube", Argument.ArgType.STRING,testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentWithShortFormAndValueSetWithDescription(){
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type","this is a description", 't',testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentWithShortFormAndValueSetWithDataType(){
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", Argument.ArgType.STRING, 't',testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentWithShortFormAndValueSetWithDefaultValueAndDataType(){
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", "cube", Argument.ArgType.STRING, 't',testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentWithShortFormAndValueSetWithDefaultValueAndDescription(){
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type","cube", "this is a description", 't',testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentWithShortFormAndValueSetWithDataTypeAndDescription(){
        String[] testValues = {"cube", "ellipsoid", "pyramid"};
        NamedArgument type = new NamedArgument("type", Argument.ArgType.STRING, "this is a description", 't',testValues);
        assertEquals(testValues, type.getValueSet());
    }
    
    @Test
    public void TestNamedArgumentDefaultBoolean(){
        NamedArgument help = new NamedArgument("help", Argument.ArgType.BOOLEAN, "This is the description");
        assertEquals("boolean", help.getType());
    }
    
    @Test
    public void TestBooleanNamedArgumentWithShortForm(){
        NamedArgument help = new NamedArgument("help", Argument.ArgType.BOOLEAN, 'h');
        assertEquals(false, help.getValue());
    }
    
    @Test
    public void TestBooleanNamedArgumentWithSetOfValues(){
    	String[] helpValues = {"True", "False"};
        NamedArgument help = new NamedArgument("help", Argument.ArgType.BOOLEAN, helpValues);
        assertEquals(false, help.getValue());
    }
    
     @Test
    public void TestBooleanNamedArgumentWithDescriptionAndSetOfValues(){
    	String[] helpValues = {"True", "False"};
        NamedArgument help = new NamedArgument("help", Argument.ArgType.BOOLEAN, "usage information", helpValues);
        assertEquals(false, help.getValue());
    }
    
     @Test
    public void TestBooleanNamedArgumentWithShortFormAndSetOfValues(){
    	String[] helpValues = {"True", "False"};
        NamedArgument help = new NamedArgument("help", Argument.ArgType.BOOLEAN, 'h', helpValues);
        assertEquals(false, help.getValue());
    }
    
    @Test
    public void TestBooleanNamedArgumentWithDescriptionAndShortFormAndSetOfValues(){
    	String[] helpValues = {"True", "False"};
        NamedArgument help = new NamedArgument("help", Argument.ArgType.BOOLEAN, "usage information", 'h', helpValues);
        assertEquals(false, help.getValue());
    }
    
    
    @Test
    public void TestNamedArgumentsWithEachDifferentValue(){
        String[] args = {"1.0", "1", "2", "--type", "box", "--digits", "2", "--blah", "--shoe", "3.0", "-w", "5.0"};
		ArgumentParser lib = new ArgumentParser();
		lib.addProgramName("VolumeCalculator");
		lib.addProgramDescription("Calculate the volume of an object.");
    	PositionalArgument length = new PositionalArgument("length", Argument.ArgType.FLOAT, "the length of the object");
    	PositionalArgument width = new PositionalArgument("width", Argument.ArgType.INTEGER, "the width of the object");
    	PositionalArgument height = new PositionalArgument("height", Argument.ArgType.STRING, "the height of the object");
    	String[] rainySet = {"true", "false", "True", "False"};
    	lib.addPositionalArgument(length);
    	lib.addPositionalArgument(width);
    	lib.addPositionalArgument(height);
    	String[] typeValues = {"box", "pyramid", "ellipsoid"};
    	NamedArgument type = new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object", 't', typeValues);
    	NamedArgument digits = new NamedArgument("digits", "4", Argument.ArgType.INTEGER, "the number of decimal digits to truncate at", 'd');
    	NamedArgument blah = new NamedArgument("blah", Argument.ArgType.BOOLEAN);
        NamedArgument shoe = new NamedArgument("shoe", Argument.ArgType.FLOAT);
        NamedArgument weeks = new NamedArgument("days", Argument.ArgType.FLOAT, 'w');
        
        lib.addNamedArgument(type);
    	lib.addNamedArgument(digits);
    	lib.addNamedArgument(blah);
    	lib.addNamedArgument(shoe); 
    	lib.addNamedArgument(weeks);
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){
    		
    	}
        assertEquals("float", length.getType());
        assertEquals("integer", width.getType());
        assertEquals("string", height.getType());
        assertEquals("string", type.getType());
        assertEquals("integer", digits.getType());
        assertEquals("boolean", blah.getType());
        assertEquals("float", shoe.getType());
        assertEquals((float)3.0, shoe.getValue());
        assertEquals((float)5.0, weeks.getValue());
    }

	@Test//XML file location specific to individual computer
	public void testImportingXMLFileWithValueSetStoresCorrectInfoForEachArgumentFromOutsideOfArgumentParser(){
		String[] args = {"7", "-t", "pyramid", "5", "2"};
		try{
			//XMLReader xml = new XMLReader();
			
			
			
			
			//for Katie's only
			//ArgumentParser lib = XMLReader.readXMLFile("/Users/katiewood/Documents/Software_Engineering/ArgParse_CS310/ArgumentsWithValueSet.xml");
			
			//for Trent's only
			ArgumentParser lib = XMLReader.readXMLFile("/Users/trentford/Documents/Repositories/ArgParse_CS310/ArgumentsWithValueSet.xml");
			
            //for andrew's only
            //ArgumentParser lib = XMLReader.readXMLFile("C:/Users/Andrew/Documents/GitHub/ArgParse_CS310/ArgumentsWithValueSet.xml");
			
			try{
				lib.parse(args);
			}
			catch(Exception e){
				assertEquals("", e);
			}
			assertEquals("VolumeCalculator", lib.getProgramName());
			assertEquals("Calculate the volume of a specified object.", lib.getProgramDescription());
			PositionalArgument length = lib.getPositionalArgument(1);
			PositionalArgument width = lib.getPositionalArgument(2);
			PositionalArgument height = lib.getPositionalArgument(3);
			String[] lengthValueSet = {"6.0", "7.0", "8.0"};
			assertEquals(lengthValueSet, length.getValueSet());
			assertEquals((float)7.0, length.getValue());
			assertEquals((float)5.0, width.getValue());
			assertEquals(2, height.getValue());
			assertEquals("the height of the object", height.getDescription());
			NamedArgument type = lib.getNamedArgument('t');
			String[] typeValueSet = {"box", "pyramid", "ellipsoid"};
			assertEquals("pyramid", type.getValue());
			assertEquals(typeValueSet, type.getValueSet());
			NamedArgument digits = lib.getNamedArgument('d');
			assertEquals(4, digits.getValue());
		}
		catch(Exception e){
			assertEquals("", e);
		}
	
	}
	
	@Test
    public void TestPositionalArgumentWithNameAndTypeAndValueSet(){
        String[] testValues = {"1", "2", "3"};
        PositionalArgument length = new PositionalArgument("length", Argument.ArgType.INTEGER,testValues);
        assertEquals(testValues, length.getValueSet());
        assertEquals("length", length.getName());
        assertEquals("integer", length.getType());
    }
    
    @Test
    public void TestPositionalArgumentWithNameAndValueSet(){
        String[] testValues = {"1", "2", "3"};
        PositionalArgument length = new PositionalArgument("length", testValues);
        assertEquals(testValues, length.getValueSet());
        assertEquals("length", length.getName());
    }
    
     @Test
    public void TestPositionalArgumentWithNameAndDescriptionAndValueSet(){
        String[] testValues = {"1", "2", "3"};
        PositionalArgument length = new PositionalArgument("length", "the length of the box", testValues);
        assertEquals(testValues, length.getValueSet());
        assertEquals("length", length.getName());
        assertEquals("the length of the box", length.getDescription());
    }
    
    @Test
    public void testParseDataTypeThrowsCorrectExceptionForIncorrectBooleanValues(){
    	String[] args = {"something"};
    	ArgumentParser lib = new ArgumentParser();
    	lib.addProgramName("VolumeCalculator");
    	lib.addProgramDescription("Calculate the volume of an object");
    	PositionalArgument testBool = new PositionalArgument("testBool", Argument.ArgType.BOOLEAN);
    	lib.addPositionalArgument(testBool);
    	try{
    		lib.parse(args);
    		assertEquals("", testBool.getValue());
    	}
    	catch(Exception e){
    		assertEquals("usage: java VolumeCalculator required: testBool\nVolumeCalculator.java: error: argument testBool: invalid boolean value: something", e.getMessage());
    	}
    }
    
    @Test
    public void testParseBoolReturnsFalseWhenGivenCapitalLettersAsArgumentValue(){
    	String[] args = {"FalSe"};
    	ArgumentParser lib = new ArgumentParser();
    	lib.addPositionalArgument(new PositionalArgument("fun", Argument.ArgType.BOOLEAN));
    	try{
    		lib.parse(args);
    	}
    	catch(Exception e){}
    	PositionalArgument fun = lib.getPositionalArgument("fun");
    	assertEquals(false, fun.getValue());
    }
    
    @Test
    public void testDefaultValuesAreReturnedAsSpecificDataTypes(){
    	String[] args = {"-t", "pyramid", "5"};
    	ArgumentParser lib = new ArgumentParser();
    	lib.addPositionalArgument(new PositionalArgument("length"));
    	lib.addNamedArgument(new NamedArgument("type", "box", Argument.ArgType.STRING, "the shape of the object", 't'));
    	lib.addNamedArgument(new NamedArgument("digits", "4", Argument.ArgType.INTEGER, "the number of digits in the result", 'd'));
    	try{
    		lib.parse(args);
    		NamedArgument digits = lib.getNamedArgument("digits");
    		NamedArgument type = lib.getNamedArgument("type");
    		assertEquals(4, digits.getValue());
    		assertEquals("pyramid", type.getValue());  
    	}
    	catch(Exception e){
    		assertEquals("", e);
    	}
    }
	
}

    