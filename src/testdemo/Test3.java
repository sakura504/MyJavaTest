package testdemo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Random;

/**
 * @author lichaojie
 * @date 2021/7/6 8:34
 * @ClassName Test3
 **/
public class Test3 {
    public static void main(String[] args) {
//        List<String> list1 = new ArrayList<String>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        list1.add("5");
//        list1.add("6");
//
//        List<String> list2 = new ArrayList<String>();
//        list2.add("2");
//        list2.add("3");
//        list2.add("7");
//        list2.add("8");
//
//        // 交集
//        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
//        System.out.println("---交集 intersection---");
//        intersection.parallelStream().forEach(System.out :: println);
//
//        // 差集 (list1 - list2)
//        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
//        System.out.println("---差集 reduce1 (list1 - list2)---");
//        reduce1.parallelStream().forEach(System.out :: println);
//
//        // 并集
//        List<String> listAll = list1.parallelStream().collect(toList());
//        List<String> listAll2 = list2.parallelStream().collect(toList());
//        listAll.addAll(listAll2);
//        System.out.println("---并集 listAll---");
//        listAll.parallelStream().forEachOrdered(System.out :: println);
//
//        // 去重并集
//        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
//        System.out.println("---得到去重并集 listAllDistinct---");
//        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);
//
//        System.out.println("---原来的List1---");
//        list1.parallelStream().forEachOrdered(System.out :: println);
//        System.out.println("---原来的List2---");
//        list2.parallelStream().forEachOrdered(System.out :: println);
//
//        String.format("商品[%s]的数量大于限购量%g", "11", new BigDecimal(22));

        LocalDateTime createDateTime = LocalDateTime.now().minusMonths(10);
        LocalDateTime curDateTime = LocalDateTime.now();
        BigDecimal storeOpeningTime = calcTheAnnualDifference(createDateTime,curDateTime);
        System.out.println(storeOpeningTime);

        System.out.println(getStringAndAlphabetRandom(6));
    }

    public static String getStringAndAlphabetRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static BigDecimal calcTheAnnualDifference(LocalDateTime beforeDateTime, LocalDateTime afterDateTime) {
        BigDecimal storeOpeningTime = BigDecimal.ZERO;

        //计算相差年
        BigDecimal afterYear = new BigDecimal(afterDateTime.get(ChronoField.YEAR));
        BigDecimal beforeYear = new BigDecimal(beforeDateTime.get(ChronoField.YEAR));
        storeOpeningTime = afterYear.subtract(beforeYear);

        //计算相差月
        BigDecimal afterMonth = new BigDecimal(afterDateTime.get(ChronoField.MONTH_OF_YEAR));
        BigDecimal beforeMonth = new BigDecimal(beforeDateTime.get(ChronoField.MONTH_OF_YEAR));
        BigDecimal month = afterMonth.subtract(beforeMonth).divide(new BigDecimal(12), 1, BigDecimal.ROUND_HALF_DOWN);

        return storeOpeningTime.add(month);
    }
}
