
<p align="center">
  <img alt="Java 17" src="https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white" />
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-REST%20API-6DB33F?logo=springboot&logoColor=white" />
  <img alt="Spring Data JPA" src="https://img.shields.io/badge/Spring%20Data-JPA-6DB33F?logo=spring&logoColor=white" />
  <img alt="Hibernate" src="https://img.shields.io/badge/ORM-Hibernate-59666C?logo=hibernate&logoColor=white" />
  <img alt="MySQL" src="https://img.shields.io/badge/Database-MySQL-4479A1?logo=mysql&logoColor=white" />
  <img alt="Maven" src="https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white" />
  <img alt="JUnit 5" src="https://img.shields.io/badge/Testing-JUnit%205-25A162?logo=junit5&logoColor=white" />
</p>

<p align="center">
  <img alt="IDE: Eclipse" src="https://img.shields.io/badge/IDE-Eclipse-2C2255?logo=eclipseide&logoColor=white" />
  <img alt="Git" src="https://img.shields.io/badge/Version%20Control-Git-F05032?logo=git&logoColor=white" />
  <img alt="GitHub" src="https://img.shields.io/badge/Platform-GitHub-181717?logo=github&logoColor=white" />
  <img alt="Last commit" src="https://img.shields.io/github/last-commit/DebashisTech/Client-Weather-API?logo=github" />
  <img alt="Stars" src="https://img.shields.io/github/stars/DebashisTech/Client-Weather-API?style=flat&logo=github" />
</p>


# 🌦️ Client Weather API

A **Spring Boot REST API application** designed to manage client-related information and integrate weather-related services. The project follows a layered architecture to maintain clean, modular, reusable, and maintainable code.

## 🚀 Project Overview

**Client Weather API** is a backend application developed using Java and Spring Boot. It demonstrates REST API development, database integration, object mapping, exception handling, and a structured service-based architecture.

The application is organized into separate packages for controllers, services, repositories, entities, DTOs, configurations, and other supporting components.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot | Backend framework |
| Spring Web | REST API development |
| Spring Data JPA | Database operations |
| Hibernate | ORM framework |
| MySQL | Relational database |
| Maven | Dependency management |
| ModelMapper | DTO and Entity mapping |
| JUnit 5 | Unit testing |
| Spring AOP | Aspect-oriented programming |

## ✨ Key Features

- **RESTful API Development:** Create and manage backend operations through REST endpoints.
- **Layered Architecture:** Separation of Controller, Service, and Repository layers.
- **DTO Pattern:** Separate request and response objects from database entities.
- **Database Integration:** Persistence using Spring Data JPA and Hibernate.
- **Object Mapping:** ModelMapper for converting DTOs and entities.
- **Exception Handling:** Dedicated package for handling application exceptions.
- **AOP:** Separate aspect-related functionality.
- **Event Handling:** Event and listener-based application components.
- **Configuration Management:** Centralized configuration classes.
- **Unit Testing:** Spring Boot application context testing with JUnit 5.

## 🏗️ Project Architecture

The application follows a layered architecture:

```text
Client / External Application
           |
           v
      Controller
           |
           v
        Service
           |
           v
       Repository
           |
           v
        Database
```

### Request Processing Flow

1. The client sends an HTTP request.
2. The Controller receives and processes the request.
3. The Service layer handles business logic.
4. The Repository communicates with the database.
5. The database returns the requested information.
6. The application sends an appropriate HTTP response.

## 📂 Project Structure

```text
M1_REST1/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/qsp/
│   │   │       │
│   │   │       ├── aspect/
│   │   │       ├── configuration/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── event/
│   │   │       ├── exceptionhandling/
│   │   │       ├── listener/
│   │   │       ├── modelmapper/
│   │   │       ├── repository/
│   │   │       ├── requestdto/
│   │   │       ├── responsedto/
│   │   │       ├── runner/
│   │   │       ├── service/
│   │   │       ├── serviceImplement/
│   │   │       ├── util/
│   │   │       │
│   │   │       └── M1Rest1Application.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│       └── java/
│           └── com/qsp/
│               └── M1Rest1ApplicationTests.java
│
├── target/
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

### Package Responsibilities

| Package | Responsibility |
|---|---|
| `aspect` | Aspect-oriented programming |
| `configuration` | Application configuration |
| `controller` | Handles HTTP requests and responses |
| `entity` | Database entity classes |
| `event` | Application event definitions |
| `exceptionhandling` | Custom exception handling |
| `listener` | Handles application events |
| `modelmapper` | Object mapping configuration |
| `repository` | Database access operations |
| `requestdto` | Incoming request data |
| `responsedto` | Outgoing response data |
| `runner` | Application startup operations |
| `service` | Service interfaces and business operations |
| `serviceImplement` | Service implementation classes |
| `util` | Utility classes and reusable methods |

## ⚙️ Prerequisites

Before running this project, make sure you have installed:

- Java Development Kit (JDK 17)
- Maven
- MySQL Server
- Eclipse IDE / IntelliJ IDEA / VS Code
- Postman (for API testing)

## 📥 Installation & Setup

**1. Clone the repository**

```bash
git clone https://github.com/DebashisTech/Client-Weather-API.git
```

**2. Navigate to the project directory**

```bash
cd Client-Weather-API/M1_REST1
```

**3. Configure the database**

Create a MySQL database and configure your database connection in `src/main/resources/application.properties`.

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace the database name, username, and password with your local configuration.

**4. Build the project**

On Windows:

```bash
mvnw.cmd clean install
```

On Linux/macOS:

```bash
./mvnw clean install
```

**5. Run the application**

```bash
mvnw.cmd spring-boot:run
```

The application will start on the configured Spring Boot port (8080 by default).

## 🧪 Testing

The project uses JUnit 5 and Spring Boot Test for application testing.

Run the tests using:

```bash
mvnw.cmd test
```

You can use Postman to test the REST API endpoints.

## 🎯 Learning Objectives

This project demonstrates practical knowledge of:

- Java and Object-Oriented Programming.
- Spring Boot application development.
- REST API design and development.
- Dependency Injection.
- Spring Data JPA and Hibernate.
- Entity and DTO separation.
- Exception handling.
- Layered application architecture.
- Event-driven components and AOP.

## 🔮 Future Enhancements

- Add comprehensive unit and integration tests.
- Improve API documentation using Swagger/OpenAPI.
- Implement authentication and authorization.
- Add centralized logging and monitoring.
- Improve API validation and error responses.

## 👨‍💻 Developer

**Debashis Palai**

Java Full Stack Developer | Spring Boot Developer

- GitHub: https://github.com/DebashisTech
- Project Repository: https://github.com/DebashisTech/Client-Weather-API
- Project Module: https://github.com/DebashisTech/Client-Weather-API/tree/main/M1_REST1

---

## 💡 Developer's Note

This project represents my practical learning journey in Java Full Stack Development, with a focus on building scalable, maintainable, and well-structured backend applications using Java and Spring Boot.

I believe in learning by building, improving through challenges, and writing clean, meaningful code.

**"Think. Code. Debug. Improve. Repeat."**

**Built with passion, powered by Java & Spring Boot. ❤️**

<hr/>

<p align="center">
  <b>Thanks for checking out Client Weather API!</b><br/>
  If this project helped you, consider giving it a ⭐
</p>

<p align="center">
  <a href="https://github.com/DebashisTech/Client-Weather-API/stargazers">
    <img alt="Star this repo" src="https://img.shields.io/github/stars/DebashisTech/Client-Weather-API?style=for-the-badge&logo=github&color=F5C518&labelColor=181717" />
  </a>
  <a href="https://github.com/DebashisTech">
    <img alt="Follow on GitHub" src="https://img.shields.io/badge/Follow-DebashisTech-181717?style=for-the-badge&logo=github&logoColor=white" />
  </a>
  <img alt="PRs welcome" src="https://img.shields.io/badge/PRs-Welcome-6DB33F?style=for-the-badge" />
</p>

<p align="center">
  <img alt="Made with Java" src="https://img.shields.io/badge/Made%20with-Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white" />
  <img alt="Built with Spring Boot" src="https://img.shields.io/badge/Built%20with-Spring%20Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white" />
  <img alt="Developed by Devashish Paloi" src="https://img.shields.io/badge/Developed%20by-Devashish%20Paloi-2C2255?style=flat-square" />
</p>

<img width="100%" alt="footer wave" src="https://capsule-render.vercel.app/api?type=waving&color=0:6DB33F,100:2C2255&height=100&section=footer" />
