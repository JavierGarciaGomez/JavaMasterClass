package S11NamingConventionsL140_151.l148AccessModifiers;

public class Main implements Accessible{

    public static void main(String[] args) {
	    Account timsAccount = new Account("Tim");
        timsAccount.deposit(1000);
        timsAccount.withdraw(500);
        timsAccount.withdraw(-200);
        timsAccount.deposit(-20);
        timsAccount.calculateBalance();
        //timsAccount.balance = 5000;

        System.out.println("Balance on account is " + timsAccount.getBalance());
        //timsAccount.transactions.add(4500);
        timsAccount.calculateBalance();

        Accessible accessible = new Main();
        accessible.methodA();


    }

    @Override
    public void methodA() {
        int value;
        value = SOME_CONSTANT+10;
        System.out.println(value);
    }

    @Override
    public void methodB() {

    }

    @Override
    public boolean methodC() {
        return false;
    }
}
