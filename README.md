Take the serviceAccountKey.json file and put into the folder
backend/src/main/resources

Backend:
```
mvn spring-boot:run
```

Frontend:
```
mvn clean compile assembly:single
java -cp target/taskclient-1.0-SNAPSHOT-jar-with-dependencies.jar com.frontend.taskclient.App
```