package thread;

/**
 * @author lichaojie
 * @date 2021/10/11 13:56
 * @ClassName MyThread
 **/
public class MyThreadTest {
    static int tickets = 10;

    public class SellTickets implements Runnable{

        @Override
        public void run() {
            // 未加同步时产生脏数据
            while(tickets > 0) {
                synchronized (SellTickets.class){
                    if (tickets <= 0) {
                        System.out.println(Thread.currentThread().getName()+"--->售票结束！");
                        return;
                    }

                    System.out.println(Thread.currentThread().getName()+"--->售出第：  "+tickets+" 票");
                    tickets--;

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (tickets <= 0) {

                System.out.println(Thread.currentThread().getName()+"--->售票结束！");
            }
        }
    }


    public static void main(String[] args) {


        SellTickets sell = new MyThreadTest().new SellTickets();

        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }

}