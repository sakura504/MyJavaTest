package state;

/**
 * @author lichaojie
 * @date 2021/10/19 15:05
 * @ClassName MyThreadStop
 **/
public class MyThreadStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            if (i >= 900){
                stop();
            }
            System.out.println("Thread....run" + i++);
        }

    }

    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        MyThreadStop myThreadStop = new MyThreadStop();
        new Thread(myThreadStop).start();
    }
}
