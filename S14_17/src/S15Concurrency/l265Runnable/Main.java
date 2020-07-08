package S15Concurrency.l265Runnable;

import static S15Concurrency.l264Threads.ThreadColor.*;

public class Main {
    /*
    * 265
    * Contents
    * -Runnable
    * -Anonymous class that implements Runnable
    * -setName() from Threads
    * -sleep() stop executing from some time
    * -
    *
    * The runnable interface, the vantage is that only requires us to implement a single method: run
    *
    * A common mistake is to call the run() instead of start()
    * */
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the main thread. ");
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.start();
        System.out.println("Hello again from the main thread. ");

        // Anonymous thread
        new Thread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN+"Hello from the anonymous class");
            }
        }.start();

        // 265 Class with runnable
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        // Anonymous with Runnable
        Thread anonymousWithRunnable = new Thread(new MyRunnable()){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN+"Hello from the anonymous class's implementation");
            }
        };
        anonymousWithRunnable.start();

        AnotherThread anotherThread2 = new AnotherThread();
        anotherThread2.setName("== Another Thread ==");
        anotherThread2.start();
        anotherThread2.run(); // This is not running from the AnotherTread class, but from Server

        // sleep()
        new SleepThread().start();




    }
}
