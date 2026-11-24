// Program 3: Encapsulation with getters and setters
// File: BankAccount.java

public class BankAccount {
    // Private attributes - hidden from outside classes
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String holder, String number, double startBalance) {
        accountHolder = holder;
        accountNumber = number;
        if (startBalance >= 0) {
            balance = startBalance;
        } else {
            balance = 0;
        }
    }

    // Getters (read access)
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setters (controlled write access)
    public void setAccountHolder(String holder) {
        if (holder != null && !holder.trim().isEmpty()) {
            accountHolder = holder;
        } else {
            System.out.println("Invalid name. Not updated.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Withdrawal failed. Check amount/balance.");
        }
    }

    public void displayAccount() {
        System.out.println("Holder: " + accountHolder
                + " | Account: " + accountNumber
                + " | Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Prince Parfait", "ACC1001", 500.0);

        System.out.println("--- Before transactions ---");
        acc.displayAccount();

        acc.deposit(200.0);
        acc.withdraw(100.0);
        acc.setAccountHolder("Prince P. GANZA");

        System.out.println("--- After transactions ---");
        acc.displayAccount();

        // Direct access to balance is not allowed:
        // acc.balance = 99999; // ERROR if uncommented
        System.out.println("Balance read safely with getter: $" + acc.getBalance());
    }
}
