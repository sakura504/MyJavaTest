package testdemo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class demo2 {

    public static void main(String[] args) {
//        Dog dog = new Dog();
        String f = "[x]";
        List<String> list = Arrays.asList("1", "2", "3");
        String s = String.join(f, list);


        System.out.println(s);
        List<String> list1 = Arrays.asList(s.split(f));
        System.out.println(list1);

        BigDecimal newCount = new BigDecimal(120);
        BigDecimal lastCount = new BigDecimal(100);
        BigDecimal one = new BigDecimal(1);

        BigDecimal divide = newCount.divide(lastCount, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal growthRatio = divide.multiply(new BigDecimal(100));
        System.out.println(growthRatio);

        
    }

}
