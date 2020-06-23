package S11NamingConventionsL140_151.l145_147Scope;

import java.util.Scanner;

public class X {
    private int x;

    public X(Scanner x){
        this.x=x.nextInt();
    }

    public void x(){
        System.out.println("Method");
        for (int x=0; x<=10; x++){
            System.out.println(this.x + " * "+x+"equals " +(this.x*x));

        }

    }
}
