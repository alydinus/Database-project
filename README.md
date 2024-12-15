# Online Bookstore Management System

## Overview
The Online Bookstore Management System is a Java-based application designed to manage books, authors, customers, and orders in an online bookstore. It provides a graphical user interface (GUI) for users to interact with the system.

## Features
- Manage Books: Add, update, delete, and view books.
- Manage Authors: Add, update, delete, and view authors.
- Manage Customers: Add, update, delete, and view customers.
- Manage Orders: Create and view orders.

## Technologies Used
- Java
- Swing (for GUI)
- PostgreSQL (for database)
- Maven (for project management)
- Spring Boot (for backend services)

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- PostgreSQL database
- Maven

## Setup Instructions

### Database Setup
1. Install PostgreSQL and create a database named `BookStore`.
2. Update the database connection details in `src/main/resources/application.properties`:
    ```ini
    URL = jdbc:postgresql://localhost:5432/BookStore
    USER = postgres
    PASSWORD = your_password
    ```

3. Run the SQL scripts in `src/questions.sql` to create the necessary tables and insert initial data.

### Project Setup
1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/online-bookstore.git
    cd online-bookstore
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn exec:java -Dexec.mainClass="Viewer"
    ```

## Usage
- Launch the application and use the GUI to manage books, authors, customers, and orders.
- Select an option from the dropdown menu and click "Choose" to navigate to the respective panel.

## Project Structure
- `src/main/java`: Contains the Java source files.
- `src/main/resources`: Contains the application properties file.
- `src/questions.sql`: Contains SQL queries for database operations.

## Contributing
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.