// Program 2b: Subclass using protected members
// File: Car.java

public class Car extends Vehicle {
    private int doors;

    public void setCarDetails(String brandName, int carYear, String carColor, double carPrice, int numDoors) {
        brand = brandName;   // public - OK
        year = carYear;      // protected - OK in subclass
        color = carColor;    // default - OK (same package)
        setPrice(carPrice);  // private field accessed via public setter
        doors = numDoors;
    }

    public void showCar() {
        showVehicle();
        System.out.println("Doors: " + doors);
    }
}
