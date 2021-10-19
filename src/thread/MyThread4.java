package thread;

/**
 * @author lichaojie
 * @date 2021/10/15 14:58
 * @ClassName MyThread
 **/
public class MyThread4 implements Runnable {

    private int pickNum = 10;

    @Override
    public void run() {

        while (true){
            synchronized (MyThread4.class){
                if (pickNum <= 0){
                    System.out.println(Thread.currentThread().getName()+"窗口暂停售票!!!");
                    return;
                }

                System.out.println(Thread.currentThread().getName()+"窗口---》售出第" + pickNum-- + "张票");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        new Thread(myThread4,"一号窗口").start();
        new Thread(myThread4,"二号窗口").start();
        new Thread(myThread4,"三号窗口").start();
        new Thread(myThread4,"四号窗口").start();
    }
}
