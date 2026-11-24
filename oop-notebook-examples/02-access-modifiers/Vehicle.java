// Program 2a: Access Modifiers - base class
// File: Vehicle.java

public class Vehicle {
    public String brand;          // public: accessible everywhere
    protected int year;           // protected: same package + subclasses
    String color;                 // default (package-private): same package only
    private double price;         // private: this class only

    public void setPrice(double p) {
        if (p > 0) {
            price = p;
        } else {
            System.out.println("Invalid price. Price not changed.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void showVehicle() {
        System.out.println("Brand: " + brand
                + " | Year: " + year
                + " | Color: " + color
                + " | Price: $" + price);
    }
}
