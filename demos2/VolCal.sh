javac -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator.java
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator 3 5 7

java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator 5 5 5
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator 7 something 7
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator -h
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator 5 4 3 2
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator 5 4
java -cp .:../Library/build/libs/Library-1.0.jar VolumeCalculator 5 --type pyramid 4 -d 1 3
