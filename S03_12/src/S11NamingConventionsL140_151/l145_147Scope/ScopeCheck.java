package S11NamingConventionsL140_151.l145_147Scope;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck2 created, publicVar = " + publicVar + ": privateVar = " + privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void timesTwo() {
        System.out.println("*****STARTING TWO TIMES METHOD*******");
        System.out.println("Using method variable");
        int privateVar = 2;
        for (int i=0; i<5; i++) {
            System.out.println(i + " times two is " + i * privateVar);
        }
        System.out.println("Using class variable");
        for (int i=0; i<5; i++) {
            System.out.println(i + " times two is " + i * this.privateVar);
        }

    }

    public class InnerClass {
        public int privateVar = 3;

        public InnerClass() {
            System.out.println("InnerClass created, privateVar is " + privateVar);
        }

        public void timesTwo() {
            System.out.println("CALLING FROM INNERCLASS THE OUTER CLASS METHOD");
            ScopeCheck.this.timesTwo();
            System.out.println("CALLING FROM INNERCLASS THE INNERCLASS METHOD WITH CLASS VARIABLE");
            for (int i=0; i<5; i++) {
                System.out.println(i + " times two is " + i * ScopeCheck.this.privateVar);
            }
            System.out.println("CALLING FROM INNERCLASS THE INNERCLASS METHOD WITH INNERCLASS VARIABLE");
            for (int i=0; i<5; i++) {
                System.out.println(i + " times two is " + i * privateVar);
            }
        }

    }
}
