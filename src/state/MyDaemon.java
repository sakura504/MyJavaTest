package state;

/**
 * @author lichaojie
 * @date 2021/10/19 16:42
 * @ClassName MyDaemon
 **/
public class MyDaemon {

    public static void main(String[] args) {
        You you = new You();
        God god = new God();

        Thread godThread = new Thread(god);
        godThread.setDaemon(true); //默认是false表示用户线程，true为守护线程
        godThread.start();

        new Thread(you).start();
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝是永生的！！");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你已经活了"+i+"天");
        }
        System.out.println("bye world");
    }
}
