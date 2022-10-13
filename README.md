Take the serviceAccountKey.json file and put into the folder
quanlykho/src/main/resources

To compile the project into a standalone jar file (need the serviceAccountKey.json file, not provided for security reason):
```
mvn clean compile assembly:single
```

To run the jar file:
```
java -jar quanlykho-1.0-SNAPSHOT-jar-with-dependencies.jar
```

or give execution permission and execute the file

The pre-compile jar file is provided in the release section