# Codility project
This project contains my solutions of codility lessons available on www.codility.com.
All of them were tested by using junit tests and codility engine and gained 100% correctness.

## Usage

Make sure that javac is in the *PATH* environment variable.
Make sure that *JAVA_HOME* is set.

### Getting the repo

```
git clone https://github.com/paweln1975/Codility
```

### Compiling the project using maven
```
mvn compile
```

### Run all junit tests
```
mvn test
```

### Create jar file Codility-X.Y-SNAPSHOT.jar

Compiles the code, executes test and finally build a jar file.

```
mvn package
```

### Performing the release

Creates a new tag and adds the artefact the repo (github is used).

```
mvn release:prepare
mvn release:perform
```

In case of failure use the command:

```
mvn release:rollback
```
