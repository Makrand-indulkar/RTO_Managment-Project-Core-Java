package RTO;

import java.util.Map;
import java.util.Scanner;
import java.util.*;

class Vehicle {
    private String registrationNumber;
    private String ownerName;
    private String vehicleType;

    // Constructor
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Getters and Setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle [registrationNumber=" + registrationNumber + ", ownerName=" + ownerName + ", vehicleType=" + vehicleType + "]";
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String registrationNumber, String ownerName, int numberOfDoors) {
        super(registrationNumber, ownerName, "Car");
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return super.toString() + ", Number of Doors=" + numberOfDoors;
    }
}

class Bike extends Vehicle {
    private boolean hasSideCar;

    public Bike(String registrationNumber, String ownerName, boolean hasSideCar) {
        super(registrationNumber, ownerName, "Bike");
        this.hasSideCar = hasSideCar;
    }

    @Override
    public String toString() {
        return super.toString() + ", Has Side Car=" + hasSideCar;
    }
}

interface RTOOperations {
    void registerVehicle(Vehicle vehicle) throws DuplicateVehicleException;
    void updateVehicle(String registrationNumber, String newOwnerName) throws InvalidInputException;
    void deleteVehicle(String registrationNumber) throws InvalidInputException;
    void displayAllVehicles();
}
class DuplicateVehicleException extends Exception {
    public DuplicateVehicleException(String message) {
        super(message);
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class RTOSystem implements RTOOperations {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    @Override
    public void registerVehicle(Vehicle vehicle) throws DuplicateVehicleException {
        if (vehicles.containsKey(vehicle.getRegistrationNumber())) {
            throw new DuplicateVehicleException("Vehicle already registered!");
        }
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
        System.out.println("Vehicle registered successfully!");
    }

    @Override
    public void updateVehicle(String registrationNumber, String newOwnerName) throws InvalidInputException {
        if (!vehicles.containsKey(registrationNumber)) {
            throw new InvalidInputException("Vehicle not found!");
        }
        Vehicle vehicle = vehicles.get(registrationNumber);
        vehicle.setOwnerName(newOwnerName);
        System.out.println("Vehicle updated successfully!");
    }

    @Override
    public void deleteVehicle(String registrationNumber) throws InvalidInputException {
        if (!vehicles.containsKey(registrationNumber)) {
            throw new InvalidInputException("Vehicle not found!");
        }
        vehicles.remove(registrationNumber);
        System.out.println("Vehicle deleted successfully!");
    }

    @Override
    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered!");
        } else {
            for (Vehicle vehicle : vehicles.values()) {
                System.out.println(vehicle);
            }
        }
    }
}
public class RTO_Management {

	public static void main(String[] args) {
		
		 RTOSystem rtoSystem = new RTOSystem();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nRTO Management System");
	            System.out.println("1. Register Vehicle");
	            System.out.println("2. Update Vehicle Owner");
	            System.out.println("3. Delete Vehicle");
	            System.out.println("4. Display All Vehicles");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter Registration Number: ");
	                        String regNumber = scanner.nextLine();
	                        System.out.print("Enter Owner Name: ");
	                        String ownerName = scanner.nextLine();
	                        System.out.print("Enter Vehicle Type (Car/Bike): ");
	                        String vehicleType = scanner.nextLine();
	                        if (vehicleType.equalsIgnoreCase("Car")) {
	                            System.out.print("Enter Number of Doors: ");
	                            int doors = scanner.nextInt();
	                            rtoSystem.registerVehicle(new Car(regNumber, ownerName, doors));
	                        } else if (vehicleType.equalsIgnoreCase("Bike")) {
	                            System.out.print("Does it have a side car? (true/false): ");
	                            boolean hasSideCar = scanner.nextBoolean();
	                            rtoSystem.registerVehicle(new Bike(regNumber, ownerName, hasSideCar));
	                        }
	                        break;
	                    case 2:
	                        System.out.print("Enter Registration Number: ");
	                        regNumber = scanner.nextLine();
	                        System.out.print("Enter New Owner Name: ");
	                        String newOwnerName = scanner.nextLine();
	                        rtoSystem.updateVehicle(regNumber, newOwnerName);
	                        break;
	                    case 3:
	                        System.out.print("Enter Registration Number: ");
	                        regNumber = scanner.nextLine();
	                        rtoSystem.deleteVehicle(regNumber);
	                        break;
	                    case 4:
	                        rtoSystem.displayAllVehicles();
	                        break;
	                    case 5:
	                        System.out.println("Exiting...");
	                        return;
	                    default:
	                        System.out.println("Invalid choice!");
	                }
	            } catch (DuplicateVehicleException | InvalidInputException e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
		

	}

}
