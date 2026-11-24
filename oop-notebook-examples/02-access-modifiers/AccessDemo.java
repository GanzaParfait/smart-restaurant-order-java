// Program 2c: Demonstrate access modifiers
// File: AccessDemo.java

public class AccessDemo {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setCarDetails("Toyota", 2022, "Blue", 18500.0, 4);
        myCar.showCar();

        // public field - accessible
        System.out.println("Public brand from main: " + myCar.brand);

        // protected field - accessible (same package)
        System.out.println("Protected year from main: " + myCar.year);

        // default field - accessible (same package)
        System.out.println("Default color from main: " + myCar.color);

        // private field - NOT accessible directly
        // System.out.println(myCar.price); // ERROR if uncommented
        System.out.println("Private price via getter: $" + myCar.getPrice());
    }
}
