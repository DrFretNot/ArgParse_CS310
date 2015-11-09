javac -cp .;..\ArgumentParser\build\libs\ArgumentParser-1.0.jar VolumeCalculator.java
java -cp .;..\ArgumentParser\build\libs\ArgumentParser-1.0.jar VolumeCalculator 3 5 7

java -cp .;..\ArgumentParser\build\libs\ArgumentParser-1.0.jar VolumeCalculator 5 5 5
java -cp .;..\ArgumentParser\build\libs\ArgumentParser-1.0.jar VolumeCalculator 7 something 7
java -cp .;..\ArgumentParser\build\libs\ArgumentParser-1.0.jar VolumeCalculator -h

PAUSE