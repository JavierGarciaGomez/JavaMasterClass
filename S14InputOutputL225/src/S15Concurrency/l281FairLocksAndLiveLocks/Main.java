package S15Concurrency.l281FairLocksAndLiveLocks;

/*
281

    -SUMMARY
        -FairLock
        -FirstLock


    -NOTES
        -Often occurs due to theat priority
        -LiveLock the thread never progress but they are not block

    -CODE

* */

import S15Concurrency.l280ThreadStarvation.ThreadColor;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static ReentrantLock lock = new ReentrantLock(true); // the parameter true is a fairLock

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(S15Concurrency.l280ThreadStarvation.ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(S15Concurrency.l280ThreadStarvation.ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(S15Concurrency.l280ThreadStarvation.ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(S15Concurrency.l280ThreadStarvation.ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t5.setPriority(10);
        t4.setPriority(8);
        t3.setPriority(6);
        t2.setPriority(4);
        t1.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable{
        private int runCount =1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i=0; i<25; i++){
                synchronized (lock){
                    lock.lock();
                    try{
                        System.out.format(threadColor+ "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                        // execute critcal section of code
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

}