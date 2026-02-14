import java.util.Scanner;

interface IVehicle {
    void drive();
    void refuel();
}

class Car implements IVehicle {
    private String brand;
    private String model;
    private String fuelType;

    public Car(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    public void drive() {
        System.out.println("Car " + brand + " " + model + " is driving.");
    }

    public void refuel() {
        System.out.println("Refueling car with " + fuelType);
    }
}

class Motorcycle implements IVehicle {
    private String type;
    private int engineVolume;

    public Motorcycle(String type, int engineVolume) {
        this.type = type;
        this.engineVolume = engineVolume;
    }

    public void drive() {
        System.out.println("Motorcycle (" + type + ", " + engineVolume + "cc) is driving.");
    }

    public void refuel() {
        System.out.println("Refueling motorcycle.");
    }
}

class Truck implements IVehicle {
    private int capacity;
    private int axles;

    public Truck(int capacity, int axles) {
        this.capacity = capacity;
        this.axles = axles;
    }

    public void drive() {
        System.out.println("Truck with capacity " + capacity + "kg and " + axles + " axles is driving.");
    }

    public void refuel() {
        System.out.println("Refueling truck.");
    }
}

class Bus implements IVehicle {
    private int seats;
    private String route;

    public Bus(int seats, String route) {
        this.seats = seats;
        this.route = route;
    }

    public void drive() {
        System.out.println("Bus on route " + route + " with " + seats + " seats is driving.");
    }

    public void refuel() {
        System.out.println("Refueling bus.");
    }
}

abstract class VehicleFactory {
    public abstract IVehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    private String brand;
    private String model;
    private String fuelType;

    public CarFactory(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    public IVehicle createVehicle() {
        return new Car(brand, model, fuelType);
    }
}

class MotorcycleFactory extends VehicleFactory {
    private String type;
    private int engineVolume;

    public MotorcycleFactory(String type, int engineVolume) {
        this.type = type;
        this.engineVolume = engineVolume;
    }

    public IVehicle createVehicle() {
        return new Motorcycle(type, engineVolume);
    }
}

class TruckFactory extends VehicleFactory {
    private int capacity;
    private int axles;

    public TruckFactory(int capacity, int axles) {
        this.capacity = capacity;
        this.axles = axles;
    }

    public IVehicle createVehicle() {
        return new Truck(capacity, axles);
    }
}

class BusFactory extends VehicleFactory {
    private int seats;
    private String route;

    public BusFactory(int seats, String route) {
        this.seats = seats;
        this.route = route;
    }

    public IVehicle createVehicle() {
        return new Bus(seats, route);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose vehicle type:");
        System.out.println("1 - Car");
        System.out.println("2 - Motorcycle");
        System.out.println("3 - Truck");
        System.out.println("4 - Bus");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        VehicleFactory factory = null;

        switch (choice) {
            case 1:
                System.out.print("Enter brand: ");
                String brand = scanner.nextLine();

                System.out.print("Enter model: ");
                String model = scanner.nextLine();

                System.out.print("Enter fuel type: ");
                String fuel = scanner.nextLine();

                factory = new CarFactory(brand, model, fuel);
                break;

            case 2:
                System.out.print("Enter type (sport/tourist): ");
                String type = scanner.nextLine();

                System.out.print("Enter engine volume: ");
                int volume = scanner.nextInt();

                factory = new MotorcycleFactory(type, volume);
                break;

            case 3:
                System.out.print("Enter грузоподъемность (kg): ");
                int capacity = scanner.nextInt();

                System.out.print("Enter number of axles: ");
                int axles = scanner.nextInt();

                factory = new TruckFactory(capacity, axles);
                break;

            case 4:
                System.out.print("Enter number of seats: ");
                int seats = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter route: ");
                String route = scanner.nextLine();

                factory = new BusFactory(seats, route);
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        IVehicle vehicle = factory.createVehicle();

        vehicle.drive();
        vehicle.refuel();
    }
}
