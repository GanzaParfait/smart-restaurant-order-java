import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args) {
        // Constants
        final int CORRECT_PIN = 1234;
        final int MAX_ATTEMPTS = 3;
        final int MAX_TRANSACTIONS = 100;

        Scanner scanner = new Scanner(System.in);

        // Account & Transaction History State
        double balance = 1000.00; // Initial starting balance
        String[] transactionHistory = new String[MAX_TRANSACTIONS];
        int transactionCount = 0;

        // ---------------------------------------------------------
        // 1. AUTHENTICATION SYSTEM (while loop + max 3 attempts)
        // ---------------------------------------------------------
        int attempts = 0;
        boolean isAuthenticated = false;

        System.out.println("=========================================");
        System.out.println("          WELCOME TO SMART ATM           ");
        System.out.println("=========================================");

        while (attempts < MAX_ATTEMPTS && !isAuthenticated) {
            System.out.print("Enter your 4-digit PIN: ");
            String pinInput = scanner.nextLine().trim();

            int enteredPin;
            try {
                enteredPin = Integer.parseInt(pinInput);
            } catch (NumberFormatException e) {
                attempts++;
                int remaining = MAX_ATTEMPTS - attempts;
                System.out.println("Invalid input. Numbers only. Attempts remaining: " + remaining);
                continue;
            }

            if (enteredPin == CORRECT_PIN) {
                isAuthenticated = true;
                System.out.println("\nLogin successful! Welcome back.");
            } else {
                attempts++;
                int remaining = MAX_ATTEMPTS - attempts;
                if (remaining > 0) {
                    System.out.println("Incorrect PIN. Attempts remaining: " + remaining);
                } else {
                    System.out.println("\nMaximum attempts reached. Your card has been locked for security.");
                }
            }
        }

        // Terminate early if authentication failed
        if (!isAuthenticated) {
            scanner.close();
            return;
        }

        // ---------------------------------------------------------
        // 2. MAIN MENU LOOP (while loop until user chooses Exit)
        // ---------------------------------------------------------
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
            System.out.print("Select an option (1-5): ");

            String choiceInput = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid menu number (1-5).");
                continue;
            }

            switch (choice) {
                case 1:
                    // Check Balance
                    System.out.printf("\nCurrent Account Balance: $%.2f%n", balance);
                    break;

                case 2:
                    // Deposit Money
                    System.out.print("\nEnter amount to deposit: $");
                    double depositAmount;
                    try {
                        depositAmount = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid amount entered.");
                        break;
                    }

                    if (depositAmount <= 0) {
                        System.out.println("Error: Deposit amount must be greater than $0.00.");
                    } else {
                        balance += depositAmount;
                        System.out.printf("Successfully deposited $%.2f. New balance: $%.2f%n", depositAmount, balance);

                        // Save to transaction history array
                        if (transactionCount < MAX_TRANSACTIONS) {
                            transactionHistory[transactionCount] = String.format(
                                "Deposit    | +$%.2f | Balance: $%.2f", depositAmount, balance
                            );
                            transactionCount++;
                        } else {
                            System.out.println("Note: Transaction history log is full; newest entry not recorded.");
                        }
                    }
                    break;

                case 3:
                    // Withdraw Money
                    System.out.print("\nEnter amount to withdraw: $");
                    double withdrawAmount;
                    try {
                        withdrawAmount = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid amount entered.");
                        break;
                    }

                    if (withdrawAmount <= 0) {
                        System.out.println("Error: Withdrawal amount must be greater than $0.00.");
                    } else if (withdrawAmount > balance) {
                        System.out.printf("Error: Insufficient funds! Available balance: $%.2f%n", balance);
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f%n", withdrawAmount, balance);

                        // Save to transaction history array
                        if (transactionCount < MAX_TRANSACTIONS) {
                            transactionHistory[transactionCount] = String.format(
                                "Withdrawal | -$%.2f | Balance: $%.2f", withdrawAmount, balance
                            );
                            transactionCount++;
                        } else {
                            System.out.println("Note: Transaction history log is full; newest entry not recorded.");
                        }
                    }
                    break;

                case 4:
                    // View Transaction History (for loop)
                    System.out.println("\n=========================================");
                    System.out.println("           TRANSACTION HISTORY           ");
                    System.out.println("=========================================");
                    if (transactionCount == 0) {
                        System.out.println("No transactions recorded yet.");
                    } else {
                        for (int i = 0; i < transactionCount; i++) {
                            System.out.println((i + 1) + ". " + transactionHistory[i]);
                        }
                    }
                    System.out.println("=========================================");
                    break;

                case 5:
                    // Exit
                    System.out.println("\nThank you for using Smart ATM. Have a great day!");
                    running = false;
                    break;

                default:
                    System.out.println("Error: Invalid option. Please choose between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}