package S18DebuggingAndTesting.l317_318Testing;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;
    public static final int CHECKING =1;
    public static final int SAVINGS =2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType=accountType;
    }

    // the branch argument is true if the customer is performing the transaction
    // at a branch with a teller. False if is in the atm
    public double deposit(double amount, boolean branch){
        balance +=amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch){
        balance-=amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isCHECKING() {
        return accountType==CHECKING;

    }
}
