package testdemo;

import java.math.BigDecimal;

/**
 * @author lichaojie
 * @date 2021/10/18 14:01
 * @ClassName MyTest4
 **/
public class MyTest4 {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(2);
        BigDecimal b = new BigDecimal(3);

        System.out.println(a.compareTo(b) <= 0);
    }
}

