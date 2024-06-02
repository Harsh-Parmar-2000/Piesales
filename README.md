# Fullstack E-commerce Application

This repository contains a fullstack e-commerce application built using Spring Boot for the backend and Angular for the frontend. The application is designed using a microservices architecture with each microservice having its own database.

![image](https://github.com/Harsh-Parmar-2000/Piesales/assets/94829092/62ab9f17-2f4e-4fcd-9183-17543539615b)

Sure, here is the updated README.md file with the corrected project structure:

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [Microservices](#microservices)
- [Frontend](#frontend)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 8
- Node.js and npm
- MySQL Server
- Angular CLI
- Gradle

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Harsh-Parmar-2000/Piesales.git
   cd Piesales
   ```

2. Install All 5 backend dependencies:

   ```bash
   cd [SERVICENAME]
   ./gradlew clean build
   ```

3. Install frontend dependencies:

   ```bash
   cd piesales
   npm install
   ```

## Database Setup

1. Install MySQL Server. Follow the instructions for your operating system from the [MySQL official website](https://dev.mysql.com/doc/refman/8.0/en/installing.html).

2. Start the MySQL server and log in as root:

   ```bash
   mysql -u root -p
   ```

3. Create the necessary databases:

   ```sql
   CREATE DATABASE auth_server;
   CREATE DATABASE product_service;
   CREATE DATABASE cart_service;
   CREATE DATABASE order_service;
   ```

4. Configure database credentials in each microservice's application properties file (`src/main/resources/application.properties`).

## Running the Application

1. Start the Eureka Server:

   ```bash
   cd backend/eureka-server
   ./gradlew bootRun
   ```

2. Start the API Gateway:

   ```bash
   cd backend/api-gateway
   ./gradlew bootRun
   ```

3. Start the Auth Service:

   ```bash
   cd backend/auth-server
   ./gradlew bootRun
   ```

4. Start the Product Service:

   ```bash
   cd backend/product-service
   ./gradlew bootRun
   ```

5. Start the Cart Service:

   ```bash
   cd backend/cart-service
   ./gradlew bootRun
   ```

6. Start the Order Service:

   ```bash
   cd backend/order-service
   ./gradlew bootRun
   ```

7. Start the Angular frontend:

   ```bash
   cd piesales
   ng serve
   ```

## Microservices

### Auth Service

- **Port:** 9091
- **Database:** auth_server
- **Description:** Manages user authentication and authorization.
- **Initial Users:**
  - Email: user@piesales.com, Password: password
  - Email: user2@piesales.com, Password: password

### Product Service

- **Port:** 9092
- **Database:** product_service
- **Description:** Manages product catalog and inventory.

### Cart Service

- **Port:** 9093
- **Database:** cart_service
- **Description:** Manages shopping cart operations.

### Order Service

- **Port:** 9094
- **Database:** order_service
- **Description:** Manages order processing and history.

### API Gateway

- **Port:** 9090
- **Description:** Routes requests to the appropriate microservice.

### Eureka Server

- **Port:** 8761 (Default)
- **Description:** Service registry for microservice discovery.

## Frontend

- **Project Name:** piesales
- **Framework:** Angular
- **Development Server:** http://localhost:4200
- **Build:** Run `ng build` to build the project.

## Usage

1. Access the application via the API Gateway at `http://localhost:9090`.
2. Log in using one of the initial user accounts:
   - Email: user@piesales.com, Password: password
   - Email: user2@piesales.com, Password: password

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
