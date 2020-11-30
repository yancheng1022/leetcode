package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 王者荣耀 10个人全部加载完毕后才能开始游戏
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int count = 10;
        CyclicBarrier cb = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("全部加载完毕");
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int x = 0; x < count; x++) {
            executorService.execute(new Worker(cb));
        }
    }
}

class Worker extends Thread {
    CyclicBarrier cyclicBarrier;

    public Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 已加载完");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
