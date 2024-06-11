# E-Learning Website

This is a full-stack E-Learning website developed using HTML, CSS, JavaScript, React.js (with Axios) for the frontend, and Java, Spring Boot, and MySQL for the backend.

## Introduction

The E-Learning website provides a platform for students to access various courses, watch video tutorials, and track their progress. It includes user authentication, a course catalog, video playback, and progress tracking features.

## Features

- User Authentication (Login/Signup)
- Course Catalog
- Video Tutorials
- Progress Tracking
- Comments and Discussions

## Video

https://github.com/Paarth-Chandan/ELearningBackend/assets/135144621/a7cd05dc-40b8-4500-9af2-56abdc97a5e0

## Technologies Used

### Frontend

- HTML
- CSS
- JavaScript
- React.js (Axios for API calls)

### Backend

- Java
- Spring Boot
- MySQL

## Installation

### Prerequisites

- Node.js
- npm
- Java (JDK 17)
- MySQL

### Frontend Setup

1. Install the dependencies:

    ```sh
    npm install
    ```

2. Start the frontend development server:

    ```sh
    npm start
    ```

### Backend Setup

1. Clone the repository:

    ```sh
    git clone https://github.com/Paarth-Chandan/ELearningBackend.git
    cd ELearningBackend
    ```

2. Set up MySQL database:

    ```sql
    CREATE DATABASE elearning_db;
    ```

3. Update `application.properties` file with your MySQL credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/elearning_db
    spring.datasource.username=YOUR_DB_USERNAME
    spring.datasource.password=YOUR_DB_PASSWORD
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Build and run the backend:

    ```sh
    cd backend
    mvn clean package
    java -jar target/ELearningBackend-0.0.1-SNAPSHOT.jar
    ```

The application should now be running with the frontend accessible at `http://localhost:3000` and the backend accessible at `http://localhost:8080`.

## Usage

1. Register a new user or log in with existing credentials.
2. Browse the course catalog and select a course.
3. Watch video tutorials and track your progress.
4. Participate in discussions by adding comments.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## Contact

- **Paarth Chandan** - [GitHub](https://github.com/Paarth-Chandan)

Feel free to reach out if you have any questions or suggestions!
