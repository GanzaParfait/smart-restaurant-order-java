import java.util.Scanner;

public class Main {
    private static final int MAX_PIN_ATTEMPTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount(1000.00);
        Customer customer = new Customer("Customer", 1234, account);

        System.out.println("=========================================");
        System.out.println("          WELCOME TO SMART ATM           ");
        System.out.println("=========================================");

        int attempts = 0;
        boolean authenticated = false;

        while (attempts < MAX_PIN_ATTEMPTS && !authenticated) {
            System.out.print("Enter your 4-digit PIN: ");
            String rawPin = scanner.nextLine().trim();

            try {
                int enteredPin = Integer.parseInt(rawPin);
                if (customer.verifyPin(enteredPin)) {
                    authenticated = true;
                    System.out.println("\nAuthentication successful. Welcome, " + customer.getName() + "!");
                } else {
                    attempts++;
                    int remaining = MAX_PIN_ATTEMPTS - attempts;
                    if (remaining > 0) {
                        System.out.println("Incorrect PIN. Attempts remaining: " + remaining);
                    } else {
                        System.out.println("\nMaximum attempts reached. Card locked.");
                    }
                }
            } catch (NumberFormatException e) {
                attempts++;
                int remaining = MAX_PIN_ATTEMPTS - attempts;
                System.out.println("Invalid PIN format. Attempts remaining: " + remaining);
            }
        }

        if (!authenticated) {
            scanner.close();
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n-----------------------------------------");
            System.out.println("                MAIN MENU                ");
            System.out.println("-----------------------------------------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            String rawChoice = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(rawChoice);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number from 1 to 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.printf("\nCurrent Balance: $%.2f%n", customer.getAccount().getBalance());
                    break;

                case 2:
                    System.out.print("\nEnter deposit amount: $");
                    try {
                        double depositAmount = Double.parseDouble(scanner.nextLine().trim());
                        if (customer.getAccount().deposit(depositAmount)) {
                            System.out.printf("Deposited $%.2f. New Balance: $%.2f%n",
                                    depositAmount, customer.getAccount().getBalance());
                        } else {
                            System.out.println("Error: Deposit amount must be greater than $0.00.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid amount entered.");
                    }
                    break;

                case 3:
                    System.out.print("\nEnter withdrawal amount: $");
                    try {
                        double withdrawAmount = Double.parseDouble(scanner.nextLine().trim());
                        if (customer.getAccount().withdraw(withdrawAmount)) {
                            System.out.printf("Withdrew $%.2f. New Balance: $%.2f%n",
                                    withdrawAmount, customer.getAccount().getBalance());
                        } else if (withdrawAmount <= 0) {
                            System.out.println("Error: Withdrawal amount must be greater than $0.00.");
                        } else {
                            System.out.printf("Error: Insufficient balance. Available: $%.2f%n",
                                    customer.getAccount().getBalance());
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid amount entered.");
                    }
                    break;

                case 4:
                    customer.getAccount().printTransactionHistory();
                    break;

                case 5:
                    System.out.println("\nThank you for using Smart ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Error: Invalid option. Choose 1 to 5.");
                    break;
            }
        }

        scanner.close();
    }
}