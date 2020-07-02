package S15Concurrency.l270ProducerAndConsumer;

import java.util.Random;


/**
 * 270
 *
 * -Reentrant syncronization
 * -Critical section
 * -Thread-safe
 * -Syncronized methods
 *      -wait()
 *      -notify()
 *      -notifyAll()
 *
 * We can also synchronize static methods and use static objects and when We do that the lock thad used
 * is owned by the class object associated with the objects class.
 *
 * Synchronization is reentrant what that means is that if a thread acquires an object lock and within
 * the synchronized code it calls a method that's using the same object to synchronize some code
 * the thread can keep executing because it already has the lock
 *
 * Se dice que una zona de exclusión mutua es reentrante cuando un mismo thread puede
 * dquirir el mismo cerrojo varias veces; es decir, cuando un thread no se excluye a sí mismo.
 * En java, el mecanismo synchonized es reentrante.
 *
 * CRYTICAL SECTION refers to the code that's referencing a shared resource like a variable.
 * Only one thread at a time should be able to execute a critical section.
 *
 * THREAD-SAFE it means that a class or a method has been synchronized in all the critical sections so that
 * the developpers doesnt have to worry about the interferences
 *
 * None of the UI components are thread safe in JavaFX
 *
 * When we sync code we sync just the code that needs to be sync as the for in the example
 *
 * -----------------
 * Code
 *      -4: create project. Two threads: one that produces messages and the other to receive them
 *          Create class Message with sync read() and sync write().
 *      -7: create class Writer
 *
 *
 *
 * Producer - Consumer
 * Pretending that We are reading and writing messages
 *
 */

public class Main {

    public static void main(String[] args) {
    }
}

class Message {
    /* empty is true when there is no message to read; the consumer can read before there is no other written msg
     *
     * The methods are sync because We dont want to be possible to a thread to run either method
     * */

    private String message;
    private boolean empty = true;

    public synchronized void write(String message){
        while(!empty){

        }
        empty=false;
        this.message=message;
    }

    public synchronized String read(){
        while(empty){

        }
        empty=true;
        return message;
    }


}

class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message=message;
    }

    public void run(){
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };
        Random random = new Random();

        for(int i=0; i<messages.length; i++){ // loop through the msgs
            message.write(messages[i]); // write a message
            try{
                Thread.sleep(random.nextInt(2000)); // sleep a random period of time
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        message.write("Finished"); // after finishing the loop write this
    }
}