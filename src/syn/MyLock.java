package syn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichaojie
 * @date 2021/10/21 16:51
 * @ClassName MyLock
 **/
public class MyLock {

    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(testLock,"线程一").start();
        new Thread(testLock,"线程二").start();
        new Thread(testLock,"线程三").start();
    }
}


class TestLock implements Runnable{

    private int ticketNums = 10;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            reentrantLock.lock();
            try {
                if (ticketNums > 0){
                    try {
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName() + ticketNums--);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }finally {
                reentrantLock.unlock();
            }

        }
    }
}