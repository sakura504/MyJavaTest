package state;

/**
 * @author lichaojie
 * @date 2021/10/19 16:03
 * @ClassName MyThreadState
 **/
public class MyThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程以结束！！！");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println("观察初始状态" + state);

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println("观察初次启动状态" + state);

        //判读线程是否终止 不终止一直执行
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }

    }
}
