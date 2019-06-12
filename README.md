Buid Jar file: 
mvn install 
mvn clean compile assembly:single  --> a executable jar file will be generated with all dependencies

Run Jar file: 
java -jar -Xmx512m AppsToInstall-1.0.jar <Path_To_CSV_File>

Examples- 
java -jar -Xmx512m AppsToInstall-1.0.jar “…/sample-small.csv”  
java -jar -Xmx5120m AppsToInstall-1.0.jar “…/sample-large.csv” 

Note: This readme contains compile and run instructions only.  
The main readme file with all the information like design, instructions to build and run the code are provided in "README_Apps_To_Install.docx", which is present in the main directory.
