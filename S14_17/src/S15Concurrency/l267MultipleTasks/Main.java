package S15Concurrency.l267MultipleTasks;

public class Main {
    /**
     * 267
     * setName()
     * Multiple Threads
     */

    public static void main(String[] args) {
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

class Countdown{
    public void doCountdown(){
        String color;

        switch(Thread.currentThread().getName()){
            case "Thread1":
                color=ThreadColor.ANSI_CYAN;
                break;
            case "Thread2":
                color=ThreadColor.ANSI_PURPLE;
                break;
            default:
                color=ThreadColor.ANSI_GREEN;
        }

        for(int i=10; i>0; i--){
            System.out.println(color+Thread.currentThread().getName()+": i= "+i);
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
