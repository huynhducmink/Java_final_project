Take the serviceAccountKey.json file and put into the folder
backend/src/main/resources

Frontend:
```
mvn spring-boot:run
```

Backend:
```
mvn clean compile package
java -cp target/taskclient-1.0-SNAPSHOT.jar com.frontend.taskclient.App
```