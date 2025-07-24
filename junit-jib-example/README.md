# JUnit JIB Example Module

A demonstration module showcasing JUnit 5 testing with Docker containerization using Google's JIB plugin.

## Overview

This module demonstrates how to:
- Run JUnit 5 tests inside Docker containers
- Build Docker images without Dockerfiles using JIB
- Package tests and dependencies for containerized execution
- Handle mixed test results (passing and failing tests)

## Module Structure

```
junit-jib-example/
├── pom.xml                      # Module POM with JIB configuration
├── README.md                    # This documentation
├── src/main/java/io/prokobit/junit/jib/
│   └── App.java                 # Sample application class
└── src/test/java/io/prokobit/junit/jib/
    └── AppTest.java             # JUnit 5 test class
```

## Quick Start

### Build and Run

```bash
# Build the module and create Docker image
mvn clean install -DskipTests

# Run tests in Docker container
docker run junit-jib-example:latest
```

### Test Output

The Docker container will execute all tests and display results:

```
Thanks for using JUnit! Support its development at https://junit.org/sponsoring

╷
├─ JUnit Jupiter ✔
│  └─ AppTest ✔
│     ├─ testAppAddMethod() ✔
│     ├─ simpleTest() ✔
│     ├─ anotherFailingTest() ✘ This string comparison should fail
│     └─ thisTestWillFail() ✘ This calculation should fail: 5 + 4 ≠ 10
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 138 ms
[         4 containers found      ]
[         4 tests found           ]
[         2 tests successful      ]
[         2 tests failed          ]

## Configuration

### JIB Plugin Setup

The module uses JIB to build Docker images:

```xml
<plugin>
  <groupId>com.google.cloud.tools</groupId>
  <artifactId>jib-maven-plugin</artifactId>
  <configuration>
    <from>
      <image>amazoncorretto:21</image>
    </from>
    <to>
      <image>junit-jib-example:latest</image>
    </to>
    <extraDirectories>
      <paths>
        <path>
          <from>target/test-classes</from>
          <into>/app/test-classes</into>
        </path>
      </paths>
    </extraDirectories>
    <container>
      <entrypoint>
        <arg>java</arg>
        <arg>-cp</arg>
        <arg>/app/classes:/app/test-classes:/app/libs/*</arg>
        <arg>org.junit.platform.console.ConsoleLauncher</arg>
        <arg>execute</arg>
        <arg>--scan-class-path</arg>
      </entrypoint>
    </container>
  </configuration>
</plugin>
```

### Key Features

- **Base Image**: Amazon Corretto 21 (lightweight Java runtime)
- **Test Classes**: Copied to `/app/test-classes` in container
- **Dependencies**: JUnit Platform Console Launcher included
- **Entrypoint**: Automatically runs all tests on container start


## Development

### Local Testing (Optional)

```bash
# Run tests locally (will fail due to intentional failures)
mvn test

# Run specific test class
mvn test -Dtest=AppTest

# Run specific test method
mvn test -Dtest=AppTest#simpleTest
```

### Docker Development

```bash
# Rebuild Docker image after changes
mvn clean install -DskipTests

# Run with custom JVM options
docker run -e JAVA_OPTS="-Xmx512m" junit-jib-example:latest

# Run with verbose output
docker run junit-jib-example:latest --details=verbose
```

## Integration with Parent Project

This module is part of the `java-lab` multi-module project and inherits:
- **Dependency versions** from parent BOM
- **Plugin configurations** from parent management
- **Version information** via `${revision}` property
- **Java compiler settings** (Java 21)

See the main [README.md](../README.md) for complete project documentation. 