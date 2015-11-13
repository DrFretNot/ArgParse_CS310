javac -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML.java

java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 6 5 2
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 7 something 3
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML --help
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 6 6 3 2
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 6 5
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML -h
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 6 --type pyramid 5 4
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 6 --type ellipsoid 5 2
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 6 --type sphere 7 3
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculatorWithXML 9 7 3