javac -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML.java

java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML 5 5 5
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML 7 something 7
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML -h
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML 5 4 3 2
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML 5 4
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML 5 --type pyramid 4 -d 1 3
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML 2 --type ellipsoid 3 -d 1 5
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculatorWithXML 2 --type ellipsoid 3 -d value 5