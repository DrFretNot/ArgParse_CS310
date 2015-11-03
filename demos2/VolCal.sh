javac -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator.java

java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator 5 5 5
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator 7 something 7
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator -h
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator 5 4 3 2
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator 5 4
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator 5 --type pyramid 4 -d 1 3
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator 2 --type ellipsoid 3 -d 1 5
java -cp .:../ArgumentParser/build/libs/ArgumentParser-1.0.jar VolumeCalculator 2 --type ellipsoid 3 -d value 5