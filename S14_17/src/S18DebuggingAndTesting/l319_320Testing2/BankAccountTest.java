package S18DebuggingAndTesting.l319_320Testing2;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private String message="*******TEST FAILED*******";
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass(){
        System.out.println("This executes before all");
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("This executes before each");
    }


    @org.junit.jupiter.api.Test
    void deposit() {
        double balance=account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0, message);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0, message);
    }

/*
    @org.junit.jupiter.api.Test(expected=IllegalArgumentException.class)
    void withdraw_notBranch() {
        double balance = account.withdraw(600.00, false);

        Exception exception = assertThrows(IllegalArgumentException.class, account.withdraw(600.00, false));

        assertEquals(400.00, balance, 0, message);
        assertThrows(IllegalArgumentException.class, balance, message);
    }
*/
    @org.junit.jupiter.api.Test
    public void withraw_notBranch() throws Exception{
        try{
            account.withdraw(600.00, false);
            fail("Should have thrown an IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }
    }


    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isCheking_true(){
        assertTrue(account.isCHECKING(), "********The account is NOT a checking account*********");
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown(){
        System.out.println("count = "+count++);
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterClass(){
        System.out.println("Executed after all. Total count: "+count);
    }


}