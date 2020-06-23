package S11NamingConventionsL140_151.l149_151Static;

/**
 * Created by dev on 20/11/2015.
 */
public class Password {
    private static final int key = 1234567;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        /* The ^ is a bitwise operator as & and |
            ^ XOR it takes 1 when any of the values is one, but not both
            & AND it takes 1 when both values are one
            | OR it takes 1 when either of the values is one
         */
        return password ^ key;
    }

    public void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Nope, you cannot come in");
            return false;
        }
    }
}
