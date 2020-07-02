package S15Concurrency.l268ThreadVariables;

public class Main {
    /**
     * 267
     * setName()
     * Multiple Threads
     *
     * 268
     * -Shared resources between threads
     *
     * The heap is the app memory that all threads share.
     * Every thread has a thread stack and that's memory that only that thread can access
     * So threat 1 cant access the stack of threat 2, but bot can accesss the HEAP
     *
     * So when multiple threads are working with the same object they share the same object,
     * so when one thread changes something of a shared object; the other thread uses the changed object
     *
     */

    public static void main(String[] args) {
        /*
        * As every thread (countdownthread) shares the same countdown, and the countdown has a variable shared
        * they change and print the variable as they found it so it intervenes with the variable of the others threads
        * */

        Countdown countdown = new Countdown();
        CountdownThread thread1 = new CountdownThread(countdown);
        thread1.setName("Thread1");
        CountdownThread thread2 = new CountdownThread(countdown);
        thread2.setName("Thread2");
        CountdownThread thread3 = new CountdownThread(countdown);
        thread3.setName("Thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// this class has a method that prints from 10 to 1, changing color depending of the thread
class Countdown{
    private int i; //268
    public void doCountdown(){
        String color;
        switch(Thread.currentThread().getName()){
            case "Thread1":
                color= ThreadColor.ANSI_CYAN;
                break;
            case "Thread2":
                color= ThreadColor.ANSI_PURPLE;
                break;
            default:
                color= ThreadColor.ANSI_GREEN;
        }

        for(i=10; i>0; i--){
            System.out.println(color+Thread.currentThread().getName()+": i= "+i);
        }
    }
}

// This class is a thread that when it runs it starts a countdown
class CountdownThread extends Thread{
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}
