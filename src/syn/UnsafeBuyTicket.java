package syn;

/**
 * @author lichaojie
 * @date 2021/10/20 14:52
 * @ClassName UnsafeBuyTicket
 **/
//不安全的买票
public class UnsafeBuyTicket{

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"张三").start();
        new Thread(buyTicket,"李四").start();
        new Thread(buyTicket,"王五").start();
    }

}

class BuyTicket implements Runnable{

    private int ticketNum = 10;

    private boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buy();
        }
    }

    private synchronized void buy(){
        if (ticketNum <= 0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"买到的第"+ticketNum--+"张票");
    }
}
