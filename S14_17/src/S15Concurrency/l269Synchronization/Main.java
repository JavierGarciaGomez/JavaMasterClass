package S15Concurrency.l269Synchronization;

public class Main {
    /**
     * 267
     * setName()
     * Multiple Threads
     *
     * 268
     * The heap is the app memory that all threads share.
     * Every thread has a thread stack and that's memory that only that thread can access
     * So threat 1 cant access the stack of threat 2, but bot can accesss the HEAP
     *
     * So when multiple threads are working with the same object they share the same object,
     * so when one thread changes something of a shared object; the other thread uses the changed object
     *
     * 269
     * Synchronized
     * What synchronized does is preventing threads to interfere with each other
     * We can synchronize methods and statements. When a method is syncronized onlye one thread can execute that at a time,
     * so when the thread is executing it all other threats that want to execute it will suspend until the thread exits it
     *
     * To synchronize a method is needed just to add it to the declaration
     *
     * We can't synchronize constructors
     *
     * So there are 2 ways to prevent a RACE CONDITION:
     *      -first to synchronize method as above
     *      -second synchronie a block of statements rather than an entire method. So we can
     *          synchronize a block of code that works with an object to get the lock (just one synchronized can hold the lock
     *
     * When whe want to sync using an object We have to use an object that threads will share, so they both compete for
     *      the same lock.
     *
     * When using a local object variable the object reference is stored in the thread stack, but the objects values
     *      are stored on the heap.
     *
     *
     * Code changes:
     *      each thread will have its own countdown: now there is no interference, in the sense that they dont share the variable
     *          but the threads executes at the sametime
     *
     *      Then we synchronize the doCountdown() method and now each thread has to wait for the other to finish.
     *
     *      7 synchronize the color. We have the interference again because We are using a local variable that is
     *          stored in the thread stack. Each thread creates a copy of the local variable and each copy is an
     *          object that has own lock.
     *
     *      10 synchronize this instead of color
     *
     */

    public static void main(String[] args) {

        Countdown countdown = new Countdown();
        CountdownThread thread1 = new CountdownThread(countdown);
        thread1.setName("Thread1");
        CountdownThread thread2 = new CountdownThread(countdown);
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();
    }
}

class Countdown{
    private int i; //268

    // 269 SYNCHRONIZED
//    public synchronized void doCountdown(){
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

        // synchronization on a local variable
//        synchronized (color) {
        //sync this
        synchronized (this) {

            for(i=10; i>0; i--){
                System.out.println(color+Thread.currentThread().getName()+": i= "+i);
            }
        }
    }
}

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
