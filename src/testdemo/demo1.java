package testdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Dog{
    public Dog(String name){
        System.out.println("name:"+name);
    }
    public Dog(){
        System.out.println("hello dog");
    }

}

class f{

    public f(String... args){
        System.out.println("StringArgs");
    }
}

enum RMB{
    YIJIAO("一角",0.1),WUJIAO("五角",0.5),YIYUAN("一元",1.0),WUYUAN("五元",5.0),SHIYUAN("十元",10.0),ERSHIYUAN("二十元",20.0),WUSHIYUAN("五十元",50.0),YIBAIYUAN("一百元",100.0);
    private String name;
    private double value;

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "day01.RMB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }


    RMB(String name, double value){
        this.name = name;
        this.value = value;
    }

    public static void getName(){
        for(RMB rmb:RMB.values()){
            System.out.println(rmb);
        }

    }
}

class pintRmb{
    RMB rmb;

    public pintRmb(RMB rmb){
        this.rmb = rmb;
        System.out.println(rmb);
    }

    public void Rmb(){
        switch (rmb){
            case WUJIAO:
                System.out.println("五角");
                break;
            case YIJIAO:
                System.out.println("一角");
                break;
            case YIBAIYUAN:
                System.out.println("一百元");
                break;
            default:
                System.out.println("rmb");

        }
    }
}


class Static{
    String[] Strings;

    private Static() {
    }

    private static Static static1 = new Static();

    public static Static access(){
        return static1;
    }

    public String[] getStrings(Static static1){

        Strings = new String[10];
        System.out.println("成功创建数组");
        return Strings;
    }
    public String[] getStrings(){
        return null;
    }
}

public class demo1 {
    public String cat;

    public static void main(String[] args){
        /*String[] string = new String[5];
        for (int i = 0;i<5;i++){
            string[i] = "hello";
        }
        for (int i = 0;i<string.length;i++){
            System.out.println(string[i]);
        }*/

        /*day01.Dog[] dogs = new day01.Dog[5];
        dogs[0] = new day01.Dog("lily");*/
        
       /* String[] s = {"hello","java","spring","boot"};
        day01.f day01.f = new day01.f(new String[]{"hello","java","spring","boot"});

        new day01.f("hello","java","spring","boot");*/

//        day01.RMB.getName();

        /*day01.pintRmb wujiao = new day01.pintRmb(day01.RMB.WUJIAO);
        day01.pintRmb wushiyuan = new day01.pintRmb(day01.RMB.WUSHIYUAN);
        day01.pintRmb yibaiyuan = new day01.pintRmb(day01.RMB.YIBAIYUAN);

        wujiao.Rmb();
        wushiyuan.Rmb();
        yibaiyuan.Rmb();*/

        /*System.out.println(Static.access());
        Static aStatic = Static.access();
        aStatic.getStrings(aStatic);
        aStatic.getStrings();*/

        /*Cat cat = new Cat();
        System.out.println(cat);*/

//         double d = 114.145;
////         BigDecimal b = new BigDecimal(d);
////         d = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
////         System.out.println(d);

//        BigDecimal roughWeight = BigDecimal.valueOf(123.234);
//        //截断位数 根据原料种类中的保留小数位数判断
//        roughWeight = roughWeight.setScale(2, BigDecimal.ROUND_DOWN);
//        System.out.println(roughWeight);

//        String str = "供应中";
//        boolean status = str.contains("否");
//        if(status){
//            System.out.println("包含");
//        }else{
//            System.out.println("不包含");
//        }

//        String time1 = "2021-01-02 19:00:00";
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.parse(time1, dtf2);
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(Duration.between(localDateTime,now).toDays());

//        List<String> tenderReviewExperts = new ArrayList();
//        tenderReviewExperts.add("1");
//        tenderReviewExperts.add("2");
//        tenderReviewExperts.add("3");
//        List<String> userIdList = new ArrayList();
//        userIdList.add("1");
//        userIdList.add("6");
//        userIdList.add("2");
//
//        List<String> list = new ArrayList();
//        for (int a = 0; a < tenderReviewExperts.size(); a++) {
//            for (int b = 0;b<userIdList.size();b++){
//                if (tenderReviewExperts.get(a).equals(userIdList.get(b))) {
//                    userIdList.remove(b);
//                    break;
//                }else if (userIdList.get(b) != null){
//                    list.add(userIdList.get(0));
//                    userIdList.remove(0);
//                }
//            }
//        }
//
//        System.out.println(list);

//        int[] arr = new int[]{1,3,5,8,2,7,4};
//        bubbleSort3(arr);

//        StringBuilder bidEvaluationMajor = new StringBuilder();
//        StringBuilder industryClassification = new StringBuilder();
//        String name = "服务招标-基础工程-服务招标1-基础工程1,服务招标-基础工程-服务招标1-基础工程1";
//        String[] split = name.split(",");
//        for (String s : split) {
//            int index = s.indexOf("-");
//            index = s.indexOf("-", index + 1);
//            bidEvaluationMajor.append(s.substring(0,index));
//            industryClassification.append(s.substring(index + 1 ,s.length()));
//        }
//        System.out.println(split.toString());

//        List<String> str = new ArrayList();
//        str.add("aaa");
//        str.add("bbb");
//        str.add("ccc");
//        System.out.println(str.get(0).substring(1));

//        String str = "123";
//        int a = Integer.parseInt(str);
//        System.out.println(a);

//        String a = " 敢为123 人先 ";
//        String b = "敢为人先";
//
//        List<String> list1 = Arrays.asList("敢为人先", "234", "1234","7898");
//        List<String> list2 = Arrays.asList("123", "234", "1234");
//        List<String> collect = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
//
//        System.out.println(collect);
//
//        String reg = "[^\u4e00-\u9fa5]";
//        a = a.replaceAll(reg, "");
//        System.out.println(a.equals(b));

//            BigDecimal a = new BigDecimal(1);
//            BigDecimal b = new BigDecimal(2);
//        a = a.add(b);
//        System.out.println(a);

//        List<String> list = new ArrayList<String>();
//        list.add("11");
//        list.add("12");
//        list.add("13");
//        list.add("14");
//
//
//        String[] array = list.toArray(new String[0]);
//        System.out.println(Arrays.toString(array));
//
//        String secondaryImgUrl = "http://cdn.djcaigou.com/52BEDC120F79446AA9F5FC9E96DF9B15\\||http://cdn.djcaigou.com/52BEDC120F79446AA9F5FC9E96DF9B15";
//        String str = "a||b||c";
//        String[] strArr = secondaryImgUrl.split("\\|\\|");
//        System.out.println(strArr.length); //这里输出3
//        for (int i = 0; i < strArr.length; ++i){
//            System.out.println(strArr[i]);//这里输出a b c
//        }
//
//        String mobile = "13277982995";
//        if(mobile != null){
//            StringBuilder sb = new StringBuilder(mobile);
//            sb.replace(3, 7, "****");
//            System.out.println(sb.toString());
//        }

//        List<String> idList = new ArrayList<>();
////        for (int i = 0; i < 10; i++) {
////            idList.add(String.valueOf(i));
////        }
////        idList.sort(Collections.reverseOrder());
//
//        System.out.println(idList);

//        Integer a = 8;
//        Integer b = 1;
//        Integer c = a-b;
//        System.out.println("limit "+String.valueOf(c));

        List<String> globalFileSaveList = Arrays.asList("1", "2", "3");
        List<String> goodsGlobalFiles = Arrays.asList( "2", "3","4");

        //保存的七牛云key
        List<String> updateNameList = globalFileSaveList.stream().collect(Collectors.toList());
        //覆盖的七牛云key
        List<String> overNameList = goodsGlobalFiles.stream().collect(Collectors.toList());
        overNameList.removeAll(updateNameList);

    }

    public static int[] bubbleSort3(int[] arr) {
        int low=0;
        int high=arr.length-1;//设置变量的初始值
        while(low<high){
            int f1 =0,f2 =0;//每趟开始时,无记录交换
            for (int i= low; i< high; ++i) {         //正向冒泡,找到最大者
                if (arr[i]> arr[i+1]) {
                    int tmp = arr[i]; arr[i]=arr[i+1];arr[i+1]=tmp;
                    f1=i;
                }
            }
            high = f1;// 记录上次位置
            for (int j=high; j>low; --j) {          //反向冒泡,找到最小者
                if (arr[j]<arr[j-1]) {
                    int tmp = arr[j]; arr[j]=arr[j-1];arr[j-1]=tmp;
                    f2=j;
                }
            }
            low = f2; //修改low值
        }
        System.out.println(arr.toString());
        return arr;
    }

}
class Cat{
    private String move;
    private demo1 demo1 = new demo1();

    Cat(){
        move = "rtf";
    }

    @Override
    public String toString(){
        demo1.cat = "jpg";
        return "move = "+move+"\n"+
                "cat = "+demo1.cat;
    }


}
