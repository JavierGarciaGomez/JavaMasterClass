package S11NamingConventionsL140_151.l145_147Scope;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String privateVar = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        // privateVar has the same name but different scopes
        System.out.println("scopeInstance privateVar is " + scopeInstance.getPrivateVar());
        System.out.println(privateVar);
        System.out.println("ScopeInstance publicVar is "+ scopeInstance.publicVar);


        scopeInstance.timesTwo();
        System.out.println("***********************************");

        // calling inner class
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();

        //147 Challenge
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce a number");
        X x = new X(new Scanner(System.in));
        x.x();

    }
}