package S15Concurrency.l271DeadlocksWaitNotify;

import java.util.Random;
/*
271
    SUMMARY
      -Wait()
      -NotifyAll()
      -Atomic operations: reading and writing reference variables (obj1=obj2), read/write primitive variables


    NOTES
        -We always want to call wait() within a for loop that's testing for a condition, We can't use if, because
            we need constant test if is being notified or not

         -notifyAll() is conventional used instead of notify(), unless We are dealing of a lot of threads

         -There are a lot of atomic operations that happens at once. At thread cant be suspended while doing them

         -Collections arent thread safe. So multiple threads can access at the same time, so We need to
            be responsible of sync the code using the arraylist or another collection; or we can, after creating the
            collection, we can call the collections.synchronizeList and pass it to the collection.
  CODE
       -0: Reader class
       -3: Main337: it doesnt work, because there is no notification between threads
       -Add the wait() and notify()


 */

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        /*//Anonymous way
        new Thread(new Writer(message)).start();
        new Thread(new Reader(message)).start();*/

        Thread thread1 = new Thread(new Writer (message));
        Thread thread2 = new Thread(new Reader (message));
        thread1.start();
        thread2.start();

    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized void write(String message){
        while(!empty){ // while there is a message wait
            try{
                this.wait(); // wait to be notified
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        empty=false;
        this.notifyAll(); // Notify that its finished
        this.message=message;
    }

    public synchronized String read(){
        while(empty){ // while there is no message wait
            try{
                this.wait(); // wait to be notified
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        empty=true;
        this.notifyAll(); // Notify that its finished
        return message;
    }
}

class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message=message;
    }

    public void run(){
        String messages[] = {"Humpty Dumpty sat on a wall", "Humpty Dumpty had a great fall", "All the king's horses and all the king's men", "Couldn't put Humpty together again"};
        Random random = new Random();
        for(int i=0; i<messages.length; i++){
            message.write(messages[i]);
            System.out.println("Message written");
            try{
                int randomNum = random.nextInt(2000);
                System.out.println("Im the WRITER and Im going to wait "+randomNum);
                Thread.sleep(randomNum);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable{
    private Message message;

    public Reader(Message message){
        this.message=message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String latestMessage =message.read(); !latestMessage.equalsIgnoreCase("Finished");
            latestMessage=message.read()){
            System.out.println(latestMessage);
            try{
                int randomNum = random.nextInt(10000);
                System.out.println("Im the READER and Im going to wait "+randomNum);
                Thread.sleep(randomNum);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}