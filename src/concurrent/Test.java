package concurrent;

public class Test implements Runnable{
    Object object = new Object();
    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"获取对象锁,接下来调用sleep阻塞");
            try {
//                Thread.currentThread().sleep(10000);
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        }
    }
}
