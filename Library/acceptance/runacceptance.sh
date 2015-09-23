#!/bin/bash
javac -cp .:../build/classes/main HelloWorldKeywords.java
java -cp .:../build/classes/main:/home/agarrett/RobotFramework/robotframework-2.9.jar org.robotframework.RobotFramework HelloWorldTests.txt

