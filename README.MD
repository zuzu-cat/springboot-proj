# Springboot-university-coding-test-template

REST API for an university

## Build and Test the API

```
./gradlew build
```

## Run Tests

Only integration tests at the moment against an embedded DB in memory

```
./gradlew test
```

## Run the application

1. Regular run:

```
./gradlew bootRun
```

2. Enable remote debug

```
./gradlew bootRun --debug-jvm
```

if you want to leave the application suspended until you connect your debugger to the port it is listening on (5005).

3. Run UniversityApplication on your favorite IDE.

## Invoke the API

There is an exported postman collection called `university.postman_collection.json`. You can also check out the APIs
interfaces in the `api` package.