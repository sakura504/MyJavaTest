package state;

/**
 * @author lichaojie
 * @date 2021/10/19 16:22
 * @ClassName MyThreadPriority
 **/
public class MyThreadPriority {

    public static void main(String[] args) {
        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority,"线程1");
        Thread thread2 = new Thread(myPriority,"线程2");
        Thread thread3 = new Thread(myPriority,"线程3");
        Thread thread4 = new Thread(myPriority,"线程4");
        Thread thread5 = new Thread(myPriority,"线程5");
        Thread thread6 = new Thread(myPriority,"线程6");
        Thread thread7 = new Thread(myPriority,"线程7");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        thread2.setPriority(2);
        thread2.start();

        thread3.setPriority(5);
        thread3.start();

        thread4.setPriority(Thread.MIN_PRIORITY);
        thread4.start();

        thread5.setPriority(Thread.NORM_PRIORITY);
        thread5.start();

        thread6.setPriority(-1);
        thread6.start();

        thread7.setPriority(11);
        thread7.start();
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}
