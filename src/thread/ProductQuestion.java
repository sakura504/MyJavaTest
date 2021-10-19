package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichaojie
 * @date 2021/10/13 16:37
 * @ClassName ProductQuestion
 **/
public class ProductQuestion {
    public static void main(String[] args) {
        //创造两个线程，分别进行商品的生产和商品的消费
        Product product = new Product();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    product.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    product.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    product.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    product.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}
//资源类：
class Product{
    private int num=0;
    Lock lock=new ReentrantLock();
    Condition notNull=lock.newCondition();
    //等待-业务-通知
    //不使用synchronized修饰的话，会报错，IllegalMonitorStateException - 如果当前线程不是此对象的监视器的所有者。 抛出以表示线程已尝试在对象的监视器上等待或通知其他线程等待对象的监视器，而不拥有指定的监视器。
    public synchronized void produce() throws InterruptedException {
        while (num!=0){
            //商品个数不为0，当前线程需要等待
            this.wait();
        }
        //为0则操作
        num++;
        System.out.println(Thread.currentThread().getName()+"生产商品，当前剩余商品："+num);
        //通知可以进行消费
        this.notifyAll();//通知其他线程可以进行商品的消费
    }

    public synchronized void buy() throws InterruptedException {
        while(num==0){
            //此时没有商品，需要等待
            this.wait();
        }
        //不为0则可以进行操作
        num--;
        System.out.println(Thread.currentThread().getName()+"消费商品，当前剩余商品："+num);
        this.notifyAll();//通知其他线程可以生产商品
    }
}

