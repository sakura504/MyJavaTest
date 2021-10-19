package state;

/**
 * @author lichaojie
 * @date 2021/10/19 15:23
 * @ClassName MyThreadSleep
 **/
public class MyThreadSleep implements Runnable {

    //票数
    private int pickNum = 10;

    @Override
    public void run() {
        while (true){
            if (pickNum <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->抢到的第" + pickNum-- + "张票");
        }
    }

    public static void main(String[] args) {
        MyThreadSleep myThreadSleep = new MyThreadSleep();
        new Thread(myThreadSleep,"张三").start();
        new Thread(myThreadSleep,"李四").start();
        new Thread(myThreadSleep,"王五").start();
    }
}
