# College Seat Allocation System

This project is a Spring Boot application for managing the allocation of seats to students in various college branches based on their preferences and rank.

## Features

- Student preferences input
- College and branch allocation
- RESTful API using Spring Boot

## Technologies Used

- Java
- Spring Boot
- Gradle
- REST API

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/uppalapati-prapadhya/college-seat-allocation.git
    ```
2. Navigate to the project directory:
    ```bash
    cd college-seat-allocation
    ```
3. Build the project:
    ```bash
    ./gradlew build
    ```
4. Run the project:
    ```bash
    ./gradlew bootRun
    ```

## API Endpoints

- `POST /allocate`: Allocates seats to students based on their preferences.
