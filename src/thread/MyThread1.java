package thread;

/**
 * @author lichaojie
 * @date 2021/10/15 14:58
 * @ClassName MyThread
 **/
public class MyThread1 extends Thread {

    private String name;

    public MyThread1(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(name+"第"+i+"次抢到的票");
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("张三");
        myThread1.start();
        MyThread1 myThread2 = new MyThread1("李四");
        myThread2.start();
        MyThread1 myThread3 = new MyThread1("王五");
        myThread3.start();
    }
}
