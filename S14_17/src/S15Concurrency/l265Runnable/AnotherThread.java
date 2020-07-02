package S15Concurrency.l265Runnable;

import static S15Concurrency.l264Threads.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE+"Hello from another thread"+currentThread().getName());
    }
}
