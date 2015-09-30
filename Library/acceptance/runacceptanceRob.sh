#!/bin/bash
javac -cp .:../build/classes/main LibraryKeywords.java
java -cp .:../build/classes/main:/Users/robertwarren/RobotFramework/robotframework-2.9.jar org.robotframework.RobotFramework LibraryTests.txt

