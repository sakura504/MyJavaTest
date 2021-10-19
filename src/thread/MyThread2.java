package thread;

/**
 * @author lichaojie
 * @date 2021/10/15 14:58
 * @ClassName MyThread
 **/
public class MyThread2 implements Runnable {

    private String name;

//    public MyThread2(String name){
//        this.name = name;
//    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"第"+i+"次抢到的票");
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread1 = new MyThread2();
        new Thread(myThread1,"张三").start();
        //MyThread2 myThread2 = new MyThread2("李四");
        //new Thread(myThread2).start();
        //MyThread2 myThread3 = new MyThread2("王五");
        //new Thread(myThread3).start();
    }
}
