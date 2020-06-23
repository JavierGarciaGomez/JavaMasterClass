package S15Concurrency.l282LiveLockAndSlippedConditions;

/*
282

    -SUMMARY
        -FairLock
        -FirstLock

    -NOTES
        -Often occurs due to theat priority
        -LiveLock the thread never progress but they are not block

    -CODE
        -0: main

* */

public class Main {
    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();



    }


}