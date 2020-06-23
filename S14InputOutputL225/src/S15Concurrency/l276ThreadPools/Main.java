package S15Concurrency.l276ThreadPools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static S15Concurrency.l272_273JavaUtilConcurrent.Main.EOF;


/*276
    SUMMARY
        -Thread pools: is a managed set of threats
        -ExecutorService class
        -FixedThreadPool
        -submit()
        -callable object of type future

    NOTES
        -

    CODE
        -5: Executor services
        -9: anonymous callable class

* */

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock(); // 274

        ExecutorService executorService = Executors.newFixedThreadPool(3); // 276 3, because there are 3 threads

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        executorService.execute(producer); //276
        executorService.execute(consumer1); //276
        executorService.execute(consumer2); //276

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN+"Im printed from the callable class");
                return "this is the callable result";
            }
        });

        try {
            future.get();
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }

        executorService.shutdown(); // 276
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try{ // 275
                    buffer.add(num);
                } finally{
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");
        bufferLock.lock();
        try{ // 275
            buffer.add("EOF");
        } finally{
            bufferLock.unlock();
        }
    }
}


class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock=bufferLock;
    }

    public void run() {
        int lockCounter = 0; // 275

        while (true) {
            if(bufferLock.tryLock()){ // tryLock()
                try{ //275
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color+"the counter = "+ lockCounter);
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            }else{ //275
                lockCounter++;
            }
        }

    }
}