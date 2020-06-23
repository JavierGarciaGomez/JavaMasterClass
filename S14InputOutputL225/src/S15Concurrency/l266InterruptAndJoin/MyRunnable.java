package S15Concurrency.l266InterruptAndJoin;

import static S15Concurrency.l265Runnable.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED+"Hello from my Runnable's implementation");

    }
}
