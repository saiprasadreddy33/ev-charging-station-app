EV Charging Station App

Welcome to the EV Charging Station App! This app is designed to help EV drivers find available charging stations near them and also allows EV charging station owners to add and manage their charging stations.
Getting Started

To get started with the EV Charging Station App, please follow these steps:
    Clone the repository to your local machine.
    git clone https://github.com/yourusername/evchargingstation.git

    Open the project in your IDE.

    Run the project using the main class EvChargingStationAppApplication.

    Navigate to http://localhost:8080.
API Endpoints

The following API endpoints are available in the EV Charging Station App:

    GET /api/stations - Returns a list of all available charging stations.
    GET /api/stations/{id} - Returns a charging station with the specified ID.
    POST /api/stations - Adds a new charging station to the app.
    PUT /api/stations/{id} - Updates an existing charging station with the specified ID.
    DELETE /api/stations/{id} - Deletes a charging station with the specified ID.

Error Handling

The EV Charging Station App handles the following errors:

    StationNotFoundException - Thrown when a charging station with the specified ID is not found.

Testing

The EV Charging Station App includes unit tests for the service layer and integration tests for the controller layer. To run the tests, simply run the following command:
                     mvn test
Technologies Used

The EV Charging Station App is built using the following technologies:

    Java 
    Spring Boot
    Spring Data JPA
    H2 in-memory database
    Maven
    JUnit 5
    Contributions

We welcome contributions to the EV Charging Station App! If you find a bug or have a feature request, please open an issue on the repository. If you would like to contribute code, please follow these steps:

    Fork the repository.

    Create a new branch for your feature or bug fix.

    Make your changes and commit them with descriptive commit messages.

    Push your changes to your forked repository.

    Submit a pull request to the original repository with a description of your changes.