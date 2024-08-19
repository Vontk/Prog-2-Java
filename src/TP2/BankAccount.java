package TP2;
import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    public Map<String, Float> Account;
    public final String accountName;
    public BankAccount(String accountName) {
        this.Account = new HashMap<>();
        this.Account.put(accountName, 0f);
        this.accountName = accountName;
    }
    public void deposit(float amount) {
        if (amount > 0) {
            float newBalance = this.Account.get(accountName) + amount;
            Account.put(accountName, newBalance);
        }
    }
    public void withdraw(float amount) {
        if (amount > 0 && this.Account.get(accountName) > amount) {
            float newBalance = this.Account.get(accountName) - amount;
            Account.put(accountName, newBalance);
        }
    }
    public void transfer(BankAccount destination, float amount) {
        if (amount > 0 && Account.get(accountName) > amount && destination != null  && destination != this) {
            this.withdraw(amount);
            destination.deposit(amount);
        }
    }
}
