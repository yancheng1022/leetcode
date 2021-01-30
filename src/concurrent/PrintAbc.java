package concurrent;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import javafx.scene.shape.StrokeLineCap;

import java.util.Currency;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAbc {

    public static void main(String[] args) {
        //wait notify
//        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1, 10);
//        new Thread(() -> {
//            syncWaitNotify.print(1, 2, "A");
//        }).start();
//        new Thread(() -> {
//            syncWaitNotify.print(2, 3, "B");
//        }).start();
//        new Thread(() -> {
//            syncWaitNotify.print(3, 1, "C");
//        }).start();

        //await signal
        SyncAwaitSignal syncAwaitSignal = new SyncAwaitSignal(10);
        Condition condition1 = syncAwaitSignal.newCondition();
        Condition condition2 = syncAwaitSignal.newCondition();
        Condition condition3 = syncAwaitSignal.newCondition();

        new Thread(()->{
            syncAwaitSignal.print(condition1,condition2,"A");
        }).start();
        new Thread(()->{
            syncAwaitSignal.print(condition2,condition3,"B");
        }).start();
        new Thread(()->{
            syncAwaitSignal.print(condition3,condition1,"C");
        }).start();
        syncAwaitSignal.start(condition1);

    }
}

class SyncWaitNotify {
    private int flag;
    private int loopNumber;

    public SyncWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int cur, int next, String str) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (this.flag != cur) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = next;
                this.notifyAll();
            }
        }
    }
}


class SyncAwaitSignal extends ReentrantLock {
    private final int loopNumber;

    public SyncAwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void start(Condition condition){
        this.lock();
        try {
            condition.signal();
        }finally {
            this.unlock();
        }
    }

    public void print(Condition cur, Condition next, String str) {
        for (int i=0;i<loopNumber;i++){
            this.lock();
            try {
                cur.await();
                System.out.print(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                this.unlock();
            }
        }
    }
}