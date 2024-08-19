package Tests;

import static org.junit.jupiter.api.Assertions.*;
import TP2.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    public void setUp() {
        account1 = new BankAccount("Account1");
        account2 = new BankAccount("Account2");
    }

    @Test
    public void testDepositIncreasesBalance() {
        account1.deposit(100);
        assertEquals(100, account1.Account.get("Account1"));
    }

    @Test
    public void testNegativeDepositNotAllowed() {
        account1.deposit(-50);
        assertEquals(0, account1.Account.get("Account1"));
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        account1.deposit(100);
        account1.withdraw(50);
        assertEquals(50, account1.Account.get("Account1"));
    }

    @Test
    public void testNegativeWithdrawNotAllowed() {
        account1.deposit(100);
        account1.withdraw(-50);
        assertEquals(100, account1.Account.get("Account1"));
    }

    @Test
    public void testWithdrawWithoutSufficientBalanceNotAllowed() {
        account1.deposit(50);
        account1.withdraw(100);
        assertEquals(50, account1.Account.get("Account1"));
    }

    @Test
    public void testTransferDecreasesSourceIncreasesDestination() {
        account1.deposit(100);
        account1.transfer(account2, 50);
        assertEquals(50, account1.Account.get("Account1"));
        assertEquals(50, account2.Account.get("Account2"));
    }

    @Test
    public void testTransferWithoutSufficientBalanceNotAllowed() {
        account1.deposit(50);
        account1.transfer(account2, 100);
        assertEquals(50, account1.Account.get("Account1"));
        assertEquals(0, account2.Account.get("Account2"));
    }

    @Test
    public void testTransferToSameAccountNotAllowed() {
        account1.deposit(100);
        account1.transfer(account1, 50);
        assertEquals(100, account1.Account.get("Account1"));
    }

    @Test
    public void testNegativeTransferNotAllowed() {
        account1.deposit(100);
        account1.transfer(account2, -50);
        assertEquals(100, account1.Account.get("Account1"));
        assertEquals(0, account2.Account.get("Account2"));
    }
}
