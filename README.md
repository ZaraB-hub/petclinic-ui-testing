# Petclinic UI Testing Suite

This repository contains a series of UI test implementations for the [Spring Petclinic Sample Application](https://github.com/spring-projects/spring-petclinic?tab=readme-ov-file#run-petclinic-locally) using various testing approaches and frameworks. Each subfolder corresponds to a different assignment or evolution stage.

---

## Project Structure

```
.
├── 01-CaptureReplayTests/       # Assignment 1: Selenium IDE (Capture & Replay)
├── 02-SeleniumTests/            # Assignment 2: Manual Selenium WebDriver tests (JUnit)
├── 03-PageObjectTests/          # Assignment 3: Selenium tests with Page Object Model
├── 04-CucumberTests/            # Assignment 4: BDD testing using Cucumber + Selenium
├── 05-PlaywrightTests/          # Assignment 5: Migrated tests using Playwright for Java
└── README.md                    # This file
```

---

## Setup Requirements

* Java 11 or higher
* Maven
* Chrome browser (for Selenium & Playwright)
* Spring Petclinic backend running at: `http://localhost:8080/`

### Start the Petclinic app locally

```bash
cd spring-petclinic
mvn package
java -jar target/spring-petclinic-*.jar
```

---

## Assignment 01: Selenium IDE (Capture & Replay)

**Folder:** `01-CaptureReplayTests/`

* Record UI flows using Selenium IDE browser extension.

---

## Assignment 02: Selenium Tests (JUnit)

**Folder:** `02-SeleniumTests/`

* Write Selenium tests manually using Java and JUnit 5.
* Use WebDriverManager for setup.
* Example tests: `testAddOwner`, `testEditOwner`, `testFindOwner`

### Run

```bash
mvn test
```

---

## Assignment 03: Page Object Model

**Folder:** `03-PageObjectTests/`

* Refactor Selenium tests to use the Page Object Pattern.
* Each page is represented by a class (`AddOwnerPage`, `OwnerPage`, etc.)
* Tests are cleaner and easier to maintain.

---

## Assignment 04: BDD with Cucumber

**Folder:** `04-CucumberTests/`

* Define features using Gherkin (`.feature` files)
* Implement step definitions in Java using Selenium Page Objects

### Run

```bash
mvn test
```

### Report

```
target/cucumber-reports.html
```

---

## Assignment 05: Playwright for Java

**Folder:** `05-PlaywrightTests/`

* Migrate UI tests from Selenium to Playwright (Java bindings)
* Replace WebDriver with Playwright's `Browser`, `Page`, etc.
* Example tests:

  * `AddOwnerPlaywrightTest`
  * `FindOwnerPlaywrightTest`
  * `EditOwnerPlaywrightTest`

### Run

```bash
mvn test
```

---

## Notes

* Each test suite is independent.
* Common base: Spring Petclinic must be running at `localhost:8080`.
* Tests use Chrome in non-headless mode (can be switched to headless in setup).

---

## Author

Developed as part of Software Testing coursework.
