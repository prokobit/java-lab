# Allure JIB Example

This project demonstrates how to integrate Allure reporting with JUnit 5 tests in a containerized environment using Google JIB.

## What is Allure?

Allure is a flexible, lightweight multi-language test reporting tool that provides detailed information about test execution. It offers:

- **Beautiful HTML reports** with interactive dashboards
- **Detailed test steps** and execution flow
- **Test categorization** with Epics, Features, and Stories
- **Severity levels** for test prioritization
- **Attachments** for screenshots, logs, and other files
- **Parameterized test support**
- **Integration** with CI/CD pipelines

## Project Structure

```
allure-jib-example/
├── src/
│   ├── main/java/io/prokobit/allure/jib/
│   │   └── App.java                    # Calculator application
│   └── test/java/io/prokobit/allure/jib/
│       └── AppTest.java               # Test cases with Allure annotations
├── pom.xml                           # Maven configuration with Allure
└── README.md                         # This file
```

## Key Features Demonstrated

### 1. Allure Annotations
- `@Epic` - High-level test categorization
- `@Feature` - Feature-level grouping
- `@Story` - User story or test scenario
- `@Description` - Detailed test description
- `@Severity` - Test priority levels (BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL)

### 2. Test Steps
- `Allure.step()` - Detailed step-by-step execution tracking
- Automatic step recording for test methods

### 3. Attachments
- `Allure.attachment()` - Attach files, logs, or data to reports

### 4. Parameterized Tests
- Support for `@ParameterizedTest` with various data sources
- CSV and ValueSource examples

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Docker (for containerized execution)

## Setup and Usage

### 1. Run Tests Locally

```bash
# Navigate to the project directory
cd allure-jib-example

# Run tests and generate Allure results
mvn clean test
```

### 2. Generate Allure Report

```bash
# Generate HTML report from results
mvn allure:report

# Open the report in browser
mvn allure:serve
```

### 3. Containerized Execution

```bash
# Build Docker image with tests
mvn clean package jib:dockerBuild

# Run tests in container
docker run allure-jib-example:latest
```

## Allure Report Features

### Dashboard Overview
- Test execution summary
- Pass/fail statistics
- Duration analysis
- Severity distribution

### Test Details
- Step-by-step execution flow
- Test parameters and data
- Attachments (logs, screenshots, data files)
- Error details with stack traces

### Filtering and Search
- Filter by severity, status, duration
- Search by test name or description
- Group by features, stories, or epics

## Maven Commands

| Command | Description |
|---------|-------------|
| `mvn test` | Run tests and generate Allure results |
| `mvn allure:report` | Generate HTML report from results |
| `mvn allure:serve` | Generate and open report in browser |
| `mvn allure:open` | Open existing report in browser |
| `mvn clean` | Clean generated files |

## Allure Configuration

The project is configured with:

- **Allure JUnit 5** integration
- **AspectJ weaver** for automatic step recording
- **Maven Surefire** plugin integration
- **Results directory**: `target/allure-results`
- **Report directory**: `target/allure-report`

## Test Categories

### Epic: Calculator Application
- **Feature**: Basic Arithmetic Operations
  - Addition, Subtraction, Multiplication, Division
  - Edge cases and error handling
  - Parameterized tests
  - Large number operations

### Severity Levels
- **BLOCKER**: Critical failures (division by zero, invalid inputs)
- **CRITICAL**: Core functionality (basic arithmetic)
- **NORMAL**: Standard operations (factorial, large numbers)
- **MINOR**: Utility functions (even/odd detection)

## CI/CD Integration

Allure reports can be integrated into CI/CD pipelines:

```yaml
# Example GitHub Actions workflow
- name: Run Tests
  run: mvn test

- name: Generate Allure Report
  run: mvn allure:report

- name: Upload Allure Report
  uses: actions/upload-artifact@v2
  with:
    name: allure-report
    path: target/allure-report/
```

## Troubleshooting

### Common Issues

1. **AspectJ weaver not found**
   - Ensure Maven dependencies are downloaded
   - Run `mvn dependency:resolve` first

2. **Allure results not generated**
   - Check that tests are running with Surefire plugin
   - Verify `allure.results.directory` property is set

3. **Report not opening**
   - Ensure Allure command-line tool is installed
   - Check browser compatibility

### Installation of Allure CLI

```bash
# macOS
brew install allure

# Linux
sudo apt-add-repository ppa:qameta/allure
sudo apt-get update
sudo apt-get install allure

# Windows
scoop install allure
```

## Comparison with JUnit Example

| Feature | JUnit Example | Allure Example |
|---------|---------------|----------------|
| Test Execution | Basic JUnit 5 | JUnit 5 + Allure |
| Reporting | Console output | Rich HTML reports |
| Test Organization | Basic annotations | Epic/Feature/Story hierarchy |
| Error Details | Stack traces | Interactive error views |
| Test Steps | None | Detailed step tracking |
| Attachments | None | File/log attachments |
| Severity | None | Priority levels |
| Parameterized Tests | Basic | Enhanced with Allure |

## Next Steps

1. **Customize Allure Configuration**
   - Modify `allure.properties` for custom settings
   - Add custom categories and labels

2. **Integrate with CI/CD**
   - Set up automated report generation
   - Configure report archiving

3. **Add More Test Types**
   - API testing with Allure
   - UI testing integration
   - Performance testing

4. **Enhance Reports**
   - Custom CSS styling
   - Additional metrics and charts
   - Team-specific dashboards 