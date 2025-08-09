# Flight Ticket Booking System API Automation

This project implements API test automation for the Flight Ticket Booking System using REST Assured and Maven. The framework is designed with modularity, maintainability, and industry best practices to enable efficient team collaboration.

***

## Project Structure

```
FlightBookingAPIAutomation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── FlightBookingSystem/
│   │   │           ├── Authentication/        # Authentication API logic (e.g., token generation)
│   │   │           ├── PassengerService/      # Passenger Service API client & models
│   │   │           ├── configs/                # Configuration utilities (e.g., loading properties)
│   │   │           └── utils/                  # Helper utilities (logging, token management, etc.)
│   │   │
│   │   └── resources/
│   │       └── config.properties               # External configuration (URLs, credentials)
│   │
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── FlightBookingSystem/
│   │               ├── Authentication/        # Test classes for Authentication API
│   │               ├── PassengerService/      # Test classes for Passenger Service API
│   │               └── utils/                  # Test utilities and helpers
│   │
├── pom.xml                                    # Maven build and dependency management
├── README.md                                  # Project overview and instructions
├── logs/                                      # Execution logs
└── reports/                                   # Test execution reports (ExtentReports/Allure)
```

***

## Implementation Overview

### 1. Modular Design and Package Structure

- The codebase is organized into logical packages by API domain to promote modularity and clean separation of concerns.
- `Authentication` package handles token generation and management.
- `PassengerService` package contains a client class responsible for interacting with Passenger APIs and POJOs representing data models.
- Shared configurations (URLs, secrets) are placed in the `configs` package and loaded from `config.properties`.
- Utility classes for logging, token handling, and reusable code are in the `utils` package.

### 2. Externalized Configuration for Security and Flexibility

- Sensitive information such as client ID, client secret, and endpoint URLs are stored in `config.properties` file under `src/main/resources`.
- This file is excluded from version control via `.gitignore` to avoid exposing secrets in Git repositories.
- A Java `ConfigLoader` class reads configuration properties at runtime and provides easy access across the project.
- Environment variables or secret vaults can be integrated for further security enhancements.

### 3. Authentication API Automation

- The `TokenManager` utility class handles token generation by sending a POST request to the authentication endpoint.
- Token is cached and refreshed as needed.
- Tests for authentication ensure valid tokens are generated before other API tests run.
- The token is injected as a Bearer token in the Authorization header for subsequent API requests.

### 4. Passenger Service API Automation

- The `PassengerServiceClient` class encapsulates REST Assured requests for all Passenger API operations:
  - Add Passenger (POST /addPassenger)
  - View Passenger by ID (GET /viewPassengerById/{id})
  - View Passenger List (GET /viewPassengerList)
  - View Passenger by Name and Mobile (GET /viewPassengerByNameMobile/{name}/{mobile})
  - Delete Passenger by ID (DELETE /deletePassengerById/{id})
- POJO class `Passenger` models request and response payloads for type-safe API interactions.
- Requests use form parameters or path parameters as required, with proper headers and token authorization.
- Tests verify positive and negative scenarios using TestNG or JUnit framework with data-driven approaches.

### 5. Testing and Reporting

- Tests are organized in packages mirroring the main code structure under `src/test/java`.
- Test classes contain well-structured test methods with assertions on status codes, response data, and error handling.
- Logging is integrated to capture request/response details.
- Test reports are generated using popular frameworks like ExtentReports or Allure for clear results visibility.
- Maven handles dependency management and test execution.

### 6. Team Collaboration Practices

Detailed [Testing Docs](TESTING-DOCS.md)
- The project follows a modular file and package approach allowing team members to work concurrently on different API modules.
- Configuration externalization ensures sensitive data is not shared via code repository.
- Code reviews and CI/CD integration can be applied for quality assurance and automated test execution.
- Clear documentation (like this README) helps onboard new contributors and maintain the framework effectively.

***

This comprehensive and modular architecture aligns with industry standards for REST API automation, facilitating maintainability, scalability, security, and collaborative development.

For detailed code examples or help with specific modules, feel free to reach out.

***

*End of README.md content.*