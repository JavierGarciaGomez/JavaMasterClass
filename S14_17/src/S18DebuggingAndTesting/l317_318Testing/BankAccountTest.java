package S18DebuggingAndTesting.l317_318Testing;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance=account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail("This test has yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00,  BankAccount.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00,  BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isCheking_true(){
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00,  BankAccount.SAVINGS);
//        assertEquals(true, account.isCHECKING());
//        assertTrue(account.isCHECKING());
        assertTrue(account.isCHECKING(), "********The account is NOT a checking account*********");

    }

}