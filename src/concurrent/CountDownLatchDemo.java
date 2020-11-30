package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 三个子线程执行完后才执行主线程
 * 和join的区别？
 * 控制力度更细，比如可以在子线程执行一部分后coutdown，就不一定要等到线程执行完成
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executorService.execute(new Work(countDownLatch));
        executorService.execute(new Work(countDownLatch));
        executorService.execute(new Work(countDownLatch));
        countDownLatch.await();
        System.out.println("主线程执行完");
    }

}
class Work implements Runnable{
    CountDownLatch countDownLatch;
    public Work(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"执行结束");
        countDownLatch.countDown();
    }
}
