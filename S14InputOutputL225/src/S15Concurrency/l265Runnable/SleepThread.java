package S15Concurrency.l265Runnable;

import static S15Concurrency.l265Runnable.ThreadColor.ANSI_BLUE;

public class SleepThread extends Thread {
    @Override
    public void run() {
        try{
            Thread.sleep(4000);

        } catch (InterruptedException exception) {
            exception.printStackTrace();
            System.out.println(ANSI_BLUE+"Another thread woke me up");
        }
        System.out.println(ANSI_BLUE+"The sleep has passed. Now I'm awake");
    }
}
