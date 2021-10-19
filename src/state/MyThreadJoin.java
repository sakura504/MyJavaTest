package state;

/**
 * @author lichaojie
 * @date 2021/10/19 15:47
 * @ClassName MyThreadJoin
 **/
public class MyThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip线程来了"+i);
        }
    }

    public static void main(String[] args) {
        MyThreadJoin myThreadJoin = new MyThreadJoin();
        Thread thread = new Thread(myThreadJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if(i == 200){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main" + i);
        }
    }
}
