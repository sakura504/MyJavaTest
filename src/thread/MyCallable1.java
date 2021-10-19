package thread;

import java.util.concurrent.*;

/**
 * @author lichaojie
 * @date 2021/10/15 16:08
 * @ClassName MyCallable
 **/
public class MyCallable1 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+"第"+i+"次抢到的票");
        }
        return true;
    }

    private String name;

    public MyCallable1(String name){
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        MyCallable1 myCallable1 = new MyCallable1("张三");
        MyCallable1 myCallable2 = new MyCallable1("李四");
        MyCallable1 myCallable3 = new MyCallable1("王五");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> f1 = ser.submit(myCallable1);
        Future<Boolean> f2 = ser.submit(myCallable2);
        Future<Boolean> f3 = ser.submit(myCallable3);

        //获取结果
        Boolean rs1 = f1.get();
        Boolean rs2 = f2.get();
        Boolean rs3 = f3.get();

        //关闭服务
        ser.shutdownNow();
    }
}
