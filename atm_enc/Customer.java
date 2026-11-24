public class Customer {
    private final String name;
    private final int pin;
    private final BankAccount account;

    public Customer(String name, int pin, BankAccount account) {
        this.name = name;
        this.pin = pin;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }
}