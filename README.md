# RTO_Managment-Project-Core-Java

Project Overview
The RTO Management System allows users to perform the following operations:

Register Vehicles: Add new vehicles (e.g., cars, bikes) with details like registration number, owner name, and vehicle type.

Update Vehicle Information: Modify the owner name of a registered vehicle.

Delete Vehicle Records: Remove a vehicle from the system using its registration number.

Display All Vehicles: View a list of all registered vehicles.

Handle Exceptions: Manage invalid inputs and duplicate registrations using custom exceptions.

Core Java Concepts Used
1. Fundamental Java
Basic syntax, data types, and control flow are used throughout the project.

Example: Variables, loops, and methods are used to handle user input and process data.

2. Conditional Statements
if-else and switch-case statements are used to handle user choices and validate inputs.

Example: The main menu uses a switch-case to navigate between different operations.

3. Inheritance
A base class Vehicle is created, and derived classes like Car and Bike extend it.

Example: The Car and Bike classes inherit common properties like registrationNumber and ownerName from the Vehicle class.

4. Polymorphism
Method overriding is used to provide specific implementations for the toString() method in derived classes.

Example: The Car and Bike classes override the toString() method to display additional details.

5. Abstraction
An interface RTOOperations is created to define common operations like registerVehicle, updateVehicle, and deleteVehicle.

Example: The RTOSystem class implements the RTOOperations interface to provide concrete implementations.

6. Encapsulation
Private fields with public getters and setters are used to ensure data security and controlled access.

Example: The Vehicle class encapsulates fields like registrationNumber, ownerName, and vehicleType.

7. Exception Handling
Custom exceptions like DuplicateVehicleException and InvalidInputException are created to handle specific errors.

Example: If a user tries to register a vehicle with a duplicate registration number, a DuplicateVehicleException is thrown.

8. Arrays and Strings
Strings are used to store and manipulate data like registration numbers and owner names.

Example: The registrationNumber and ownerName fields in the Vehicle class are of type String.

9. Collection Framework
The HashMap collection is used to store and manage vehicle data efficiently.

Example: The RTOSystem class uses a HashMap to store vehicles with their registration numbers as keys.

How to Run the Project
Clone or download the project repository.

Open the project in an IDE like IntelliJ IDEA or Eclipse.

Compile and run the Main class.

Follow the on-screen menu to perform operations like registering, updating, deleting, and viewing vehicles.
