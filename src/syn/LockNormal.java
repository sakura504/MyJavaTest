package syn;

/**
 * @author lichaojie
 * @date 2021/10/21 14:41
 * @ClassName SynTheard
 **/
public class LockNormal {

    static final transient Object lock = new Object();

    static class LockRunable implements Runnable {
        private int num;
        private LockNormal lockNormal;
        public LockRunable(int num, LockNormal lockNormal) {
            this.num = num;
            this.lockNormal = lockNormal;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (lock){
                    if (num <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "    " + num--);
                }
            }
        }
    }

    public static void main(String[] args) {
        LockNormal lockNormal = new LockNormal();
        LockRunable one = new LockRunable(15, lockNormal);
        LockRunable two = new LockRunable(15, lockNormal);
        new Thread(one).start();
        new Thread(two).start();
    }

}
