# Final project for Advance programming class

## Author : Huynh Duc Minh & Tran Duc Dung

An application for managing online shop

### Instruction
The pre-compile jar file is provided in the release section

To run the jar file:
```
java -jar quanlykho-1.0-SNAPSHOT-jar-with-dependencies.jar
```

or give execution permission and double click the file

### Developer instruction

Take the serviceAccountKey.json file and put into the folder
quanlykho/src/main/resources

Run the project using Apache Netbean 15

To compile the project into a standalone jar file (need the serviceAccountKey.json file, not provided for security reason):
```
mvn clean compile assembly:single
```

