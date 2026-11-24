public class BankAccount {
    private static final int MAX_TRANSACTIONS = 100;

    private double balance;
    private final String[] transactionHistory;
    private int transactionCount;

    public BankAccount(double initialBalance) {
        this.balance = Math.max(0.0, initialBalance);
        this.transactionHistory = new String[MAX_TRANSACTIONS];
        this.transactionCount = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        recordTransaction(String.format("Deposit    | +$%.2f | Balance: $%.2f", amount, balance));
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        recordTransaction(String.format("Withdrawal | -$%.2f | Balance: $%.2f", amount, balance));
        return true;
    }

    private void recordTransaction(String entry) {
        if (transactionCount < MAX_TRANSACTIONS) {
            transactionHistory[transactionCount] = entry;
            transactionCount++;
        }
    }

    public void printTransactionHistory() {
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
    }
}