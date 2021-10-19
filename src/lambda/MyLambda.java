package lambda;

/**
 * @author lichaojie
 * @date 2021/10/19 14:23
 * @ClassName MyLambda
 **/
public class MyLambda {

    //静态内部类
    public static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("我的是Like类2");
        }
    }

    public static void main(String[] args) {
        ILike like1 = new Like1();
        like1.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        //局部内部类
        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("我的是Like类3");
            }
        }

        ILike like3 = new Like3();
        like3.lambda();


        //匿名内部类 没有类的名称，必须借助接口和父类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("我的是Like类4");
            }
        };
        like4.lambda();

        //用lambda简化
        ILike like5 = () -> {System.out.println("我的是Like类5");};
        like5.lambda();

        Runnable runnable = () -> {
            System.out.println("我的一个线程");
        };

        new Thread(runnable).start();
    }
}

//接口
interface ILike{
    void lambda();
}

//实现类
class Like1 implements ILike{

    @Override
    public void lambda() {
        System.out.println("我的是Like类1");
    }
}
