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
        -11: liveLocks

* */

import S15Concurrency.l280ThreadStarvation.ThreadColor;

import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);
    }


}