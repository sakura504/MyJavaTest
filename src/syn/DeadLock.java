package syn;

/**
 * @author lichaojie
 * @date 2021/10/21 15:06
 * @ClassName DeadLock
 **/
public class DeadLock {

    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(1, "张三");
        Makeup makeup2 = new Makeup(0, "李四");
        new Thread(makeup1).start();
        new Thread(makeup2).start();
    }
}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

class Makeup implements Runnable{

    //需要的资源只有一份公用
    static Lipstick lipstick =  new Lipstick();
    static Mirror mirror =  new Mirror();


    int choice;//选择
    String name;

    Makeup(int choice,String name){
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(this.name + "获取口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(this.name + "获取镜子的锁");
                }
            }
        }else {
            synchronized (mirror){
                System.out.println(this.name + "获取镜子的锁");
                Thread.sleep(1000);
                synchronized (lipstick){
                    System.out.println(this.name + "获取口红的锁");
                }
            }
        }
    }
}
