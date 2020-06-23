package S11NamingConventionsL140_151.l149_151Static;

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    // this can be used for stealing password
    @Override
    public void storePassword() {
        System.out.println("Saving password as " + this.decryptedPassword);
    }
}
