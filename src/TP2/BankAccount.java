package TP2;

public class BankAccount {
    private float balance;
    public BankAccount(String accountName, float balance) {
        this.balance = balance;
        balance = 0;
    }
    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public void withdraw(float amount) {
        if (amount > 0 && balance > amount) {
            balance -= amount;
        }
    }
    public void transfer(BankAccount destination, float amount) {
        if (amount > 0 && balance > amount && destination != null  && destination != this) {
            balance -= amount;
            destination.deposit(amount);
        }
    }
}
