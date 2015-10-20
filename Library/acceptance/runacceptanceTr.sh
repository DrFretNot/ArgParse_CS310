#!/bin/bash
javac -cp .:../build/classes/main LibraryKeywords.java
java -cp .:../build/classes/main:/Users/trentford/Documents/Software_Engineering_1_Class/Programs/robotframework-2.9.jar org.robotframework.RobotFramework LibraryTests.txt

