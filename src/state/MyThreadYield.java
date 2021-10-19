package state;

/**
 * @author lichaojie
 * @date 2021/10/19 15:05
 * @ClassName MyThreadStop
 **/
public class MyThreadYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"张三").start();
        new Thread(myYield,"李四").start();
        new Thread(myYield,"王五").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println("线程开始执行了..."+Thread.currentThread().getName());
        Thread.yield();
        System.out.println("线程执行结束了..."+Thread.currentThread().getName());
    }
}


