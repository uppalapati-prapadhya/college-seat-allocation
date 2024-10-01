# College Seat Allocation System

The **College Seat Allocation System** is a Java Spring Boot application designed to facilitate the allocation of college seats to students based on their preferences and ranks. The system ensures that students are assigned to colleges and branches they prefer, while adhering to seat availability constraints in different branches.

## Project Overview

This project simulates a seat allocation process where students provide their ranked preferences for colleges and branches, and the system allocates seats based on their ranks. It takes into account the number of available seats per branch and allocates seats fairly, based on a predefined logic.

### Key Features

- **Student Rank-Based Allocation**: The system prioritizes students with higher ranks when allocating seats.
- **Multiple Preferences**: Students can provide multiple college-branch preferences, and the system tries to allocate the first available choice.
- **REST API**: The project exposes an API that accepts a list of students and their preferences, processes the data, and returns the allocation results.
- **Simple and Extensible**: The project is designed with a simple structure, making it easy to extend or modify to accommodate more complex allocation rules or additional features.

### Technologies Used

- **Java**: The core language used for building the system.
- **Spring Boot**: A popular Java framework that simplifies the creation of web applications.
- **Gradle**: Build automation tool for managing dependencies and building the project.
- **REST API**: The allocation logic is exposed as a RESTful API, enabling easy integration with other systems or clients.
- **JSON**: Data format for input and output, allowing for easy communication with the API.

## Project Structure

- **Main Application**: The main application file that runs the Spring Boot application (`CollegeSeatAllocationApplication.java`).
- **Controller**: The controller handles HTTP requests, particularly for the `/allocate` endpoint, and returns the seat allocation results (`CollegeSeatAllocationController.java`).
- **Model**: The `Student` class models each student’s data, including rank and preferences.
- **Seat Allocation Logic**: The core logic of the application is contained in the `allocateSeats` method, which processes the student preferences and available seats.

## How It Works

1. **Input**: A list of students is provided, each with their rank, name, and a set of preferences for colleges and branches.
2. **Seat Allocation Logic**: The system attempts to allocate seats to students, starting from the student with the highest rank. It checks each student's preferences in order and allocates a seat in the first available branch.
3. **Output**: The system outputs a list showing which college and branch each student was allocated to, or an indication if no seats were available for the student's preferences.

### Example API Request:

```json
[
  {
    "rank": 1,
    "name": "John",
    "pref": [11, 12, 32]
  },
  {
    "rank": 2,
    "name": "Jane",
    "pref": [13, 14, 41]
  }
]
```

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
