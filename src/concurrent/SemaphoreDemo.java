package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 40个线程读取文件数据入库
 * 但是数据库连接只有10个，所以需要做限制
 */
public class SemaphoreDemo {
    private static final int COUNT = 40;
    private static Executor executor = Executors.newFixedThreadPool(COUNT);
    private static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i=0; i< COUNT; i++) {
            executor.execute(new Task(semaphore));
        }
    }

}
class Task implements Runnable {
    Semaphore semaphore;
    public Task(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            //读取文件操作
            semaphore.acquire();
            // 存数据过程
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}