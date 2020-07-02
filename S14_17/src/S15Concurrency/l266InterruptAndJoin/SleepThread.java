package S15Concurrency.l266InterruptAndJoin;

import static S15Concurrency.l265Runnable.ThreadColor.ANSI_BLUE;
import static S15Concurrency.l265Runnable.ThreadColor.ANSI_CYAN;

public class SleepThread extends Thread {
    @Override
    public void run() {
        try{
            Thread.sleep(4000);

        } catch (InterruptedException exception) {
            System.out.println(ANSI_CYAN+"Another thread woke me up");
            return;

        }
        System.out.println(ANSI_CYAN+"The sleep has passed. Now I'm awake");
    }
}
