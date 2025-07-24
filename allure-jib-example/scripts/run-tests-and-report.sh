#!/bin/bash

# Run tests and generate Allure report inside Docker container
set -e

echo "🧪 Running JUnit tests..."
java -cp /app/classes:/app/test-classes:/app/libs/*:/app/allure-commandline/lib/* \
     org.junit.platform.console.ConsoleLauncher \
     execute --select-class=io.prokobit.allure.jib.AppTest \
     --reports-dir=/app/allure-results --disable-ansi-colors || true

echo "📊 Generating Allure report..."
/app/allure-commandline/bin/allure generate /app/allure-results -o /app/allure-report --clean

echo "🌐 Starting Allure server on port 8080..."
/app/allure-commandline/bin/allure serve /app/allure-results -p 8080 