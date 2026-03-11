# Complya UI Automation Framework

## Overview
- Maven-based hybrid framework with Selenium 4, TestNG, Allure reporting, and GitHub Actions.
- PageFactory POM, BrowserFactory/DriverManager setup, retry analyzer/listener, plus helper/waits utilities provided.
- Configuration is centralized via `src/test/resources/config.properties`, and tests run through `testng.xml`.

## Getting Started
1. **Clone & build**
   - `git clone <repo>` and open the project in your IDE.
   - `mvn -B clean install` (downloads dependencies and compiles skeleton tests).
2. **Local execution**
   - Update `src/test/resources/config.properties` with the base URL and desired browser/headless flags.
   - Run `mvn -B test` to execute UI tests; `mvn -B allure:report` generates the HTML report.
3. **Runtime overrides**
   - Pass `-Dbrowser=firefox`, `-Dheadless=false`, `-Dretry.count=2`, `-DbaseUrl=https://staging.example.com`, etc., to adjust without editing files.
4. **IDE support**
   - Import the Maven project so IntelliJ recognizes dependencies.
   - `testng.xml` drives the suite; add new test packages under `com.complya.tests`.

## Framework structure
- `config/ConfigReader` loads `config.properties` and respects system overrides.
- `driver/BrowserFactory` selects the browser per config and configures timeouts.
- `driver/DriverManager` stores the thread-local driver referenced everywhere.
- `base/BaseTest` boots the driver, opens `baseUrl`, and quits it cleanly.
- `pages/BasePage` wires PageFactory, `Waits`, and `Helper` instances for derived page objects.
- `utils/Waits` exposes `WebElement`-based waits; `Helper` wraps common actions.
- `retry/RetryAnalyzer` + `RetryListener` retry failed tests according to `retry.count`.
- `tests/` contains TestNG classes; `SampleTest` is a smoke starter example.

## Reporting
- TestNG listeners include Allure (configured in `testng.xml`).
- Allure JSON results drop under `allure-results`; `mvn allure:report` produces HTML under `target/site/allure-maven-plugin`.
- GitHub Actions workflow (`.github/workflows/ui-tests.yml`) runs `mvn test`, uploads `allure-results`, HTML report, and Surefire artifacts for every push/PR.

## Notes for new joiners
- Stick to PageFactory-based page objects extending `BasePage`.
- Use `Helper`/`Waits` helpers instead of direct `Thread.sleep`.
- Add new tests to `com.complya.tests` and include them in `testng.xml` if package structure differs.
- Keep `config.properties` synced with shared environment values, but use system properties for per-run tweaks.

