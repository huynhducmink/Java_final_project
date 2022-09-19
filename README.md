Take the serviceAccountKey.json file and put into the folder
backend/src/main/resources

Backend:
```
mvn spring-boot:run
```

Frontend:
```
mvn clean compile package
java -cp target/taskclient-1.0-SNAPSHOT.jar com.frontend.taskclient.App
```