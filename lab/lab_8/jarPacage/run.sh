CLASSPATH="out/classes/"
JARPATH="out/jar/"
JARFILE="java1.media.jar"

#find all .java source files under src/
SOURCEFILES=$(find src/ -name *.java)

#compile all .java files from $SOURCEFILES 
#place the compiled .class files in to the -d(destination directory#)$CLASSPATH
javac -d $CLASSPATH $SOURCEFILES

#copy MediaTest.class to the directory where the jar file will be generated
cp out/classes/MediaTest.class $JARPATH

#-c create a new jar file 
#-f with the name $JARPATH$JARFILE 
#-M with no manifest
#-C change directory and use the .class files from this directory
jar -cfM $JARPATH$JARFILE -C $CLASSPATH java1/

#move to the jar file
cd $JARPATH

#execute mediaTest.class 
#set the classpath to use with the jarfile and spesify the main class
#cmd
#java -cp .;java1.media.jar MediaTest
#git bash
java -cp ".;java1.media.jar" MediaTest