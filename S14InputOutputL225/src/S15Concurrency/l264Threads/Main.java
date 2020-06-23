package S15Concurrency.l264Threads;

import static S15Concurrency.l264Threads.ThreadColor.ANSI_GREEN;
import static S15Concurrency.l264Threads.ThreadColor.ANSI_PURPLE;

public class Main {
    /*
    * 264
    * Contents
    * -Thread
    * -start()
    * -anonymousThread
    *
    * The order of the threads is defined by the OS, unless We define it by code
    *
    * Running a thread in an anonymous class is useful when You just want to run it once.
    * But if you want more is better to have a class that extends from Thread and have various instances
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

    }
}
