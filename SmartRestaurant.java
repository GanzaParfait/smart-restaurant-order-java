import java.util.Scanner;

public class SmartRestaurant {
    public static void main(String[] args) {
        // Constants and Variables
        final double DRINK_PRICE = 15.50; //[cite: 1]
        
        Scanner scanner = new Scanner(System.in); //[cite: 1]

        System.out.print("Enter customer's name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer's age: ");
        int customerAge = scanner.nextInt();

        System.out.print("Enter price of the meal: ");
        double mealPrice = scanner.nextDouble();

        System.out.print("Enter number of drinks ordered: ");
        int drinkCount = scanner.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();

        System.out.print("Enter service rating (from 1 to 5): ");
        int serviceRating = scanner.nextInt();

        // Calculations
        double totalDrinksCost = drinkCount * DRINK_PRICE; //[cite: 1]
        double subtotal = mealPrice + totalDrinksCost; //[cite: 1]

        double discountAmount = 0.0; //[cite: 1]
        // Discount rules: Student 10%, Senior 60+ gets 5%, larger discount wins[cite: 1]
        if (isStudent && customerAge >= 60) {
            discountAmount = (subtotal * 0.10 >= subtotal * 0.05) ? (subtotal * 0.10) : (subtotal * 0.05);
        } else if (isStudent) {
            discountAmount = subtotal * 0.10;
        } else if (customerAge >= 60) {
            discountAmount = subtotal * 0.05;
        }

        double discountedSubtotal = subtotal - discountAmount;

        double tipAmount = 0.0; //[cite: 1]
        if (serviceRating == 4 || serviceRating == 5) { //[cite: 1]
            tipAmount = discountedSubtotal * 0.10; // 10% tip for rating 4 or 5
        } else if (serviceRating < 1 || serviceRating > 5) { //[cite: 1]
            System.out.println("ERROR: Service rating must be between 1 and 5!");
        }

        double finalBill = discountedSubtotal + tipAmount; //[cite: 1]
        int wholeAmount = (int) finalBill; // Type cast final bill to int[cite: 1]

        // Required Receipt Output Layout
        System.out.println("\n--- SMART RESTAURANT RECEIPT ---");
        System.out.println("Customer: " + customerName);
        System.out.println("Meal: $" + mealPrice);
        System.out.println("Drinks: $" + totalDrinksCost);
        System.out.println("Discount: $" + discountAmount);
        System.out.println("Tip: $" + tipAmount);
        System.out.println("Final bill: $" + finalBill);
        System.out.println("Whole amount: $" + wholeAmount);

        scanner.close();
    }
}