package interview.practice.file;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.*;

public class AlibabaProtocalTest {

    
    /**
     * 反例 
     * 不要在foreach循环里进行元素的remove/add操作
     * @Test
     */
    @Test
    public void foreachRemove(){
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        System.out.println("before remove "+a.toString());
        for (String temp : a) {
            if ("4".equals(temp)) {
                a.remove(temp);
                System.out.println("temp is "+temp);
                System.out.println("removing "+a.toString());
            }
        }
        System.out.println("after remove "+a.toString());
    }

    @Test
    public void iteratorRemove() {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        System.out.println("before remove "+a.toString());
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if ("2".equals(temp)) {
                it.remove();
                System.out.println("temp is "+temp);
                System.out.println("removing "+a.toString());
            }
        }
        System.out.println("after remove "+a.toString());
    }

    @Test
    public void aboutSet() {
        Set<String> b = new HashSet<String>();
        boolean add1 =b.add("1");
        boolean add2 =b.add("2");
        boolean add3 =b.add("3");
        boolean add4 =b.add("2");
        System.out.println("add1 is = "+add1);
        System.out.println("add2 is = "+add2);
        System.out.println("add3 is = "+add3);
        System.out.println("add4 is = "+add4);
        
    }
    
    @Test
    public void getCurrentTime(){
        //获取当前 毫秒数
        long currentTimeMillis = System.currentTimeMillis();
        //获取更精确的纳秒级时间值
        long nanoTime = System.nanoTime();
        //JDK8中 Instant类
        Instant instantNow = Instant.now();

        System.out.println("curentTimeMillis ---> "+currentTimeMillis);
        System.out.println("nanoTime ---> "+nanoTime);
        //instantNow 为GMT时间,非北京时间,+8后为北京时间
        System.out.println("instantNow ---> "+instantNow);

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        //获取当前GMT时间
        Instant instant = clock.instant();
        //legacyDate为北京时间
        Date legacyDate = Date.from(instant);
        System.out.println("----instant值 = "+instant);
        System.out.println("----millis值 = "+millis);
        System.out.println("----legacyDate值 = "+legacyDate);
    }


    @Test
    public void equalsTest(){
        Integer a = null;
        Integer b = null;

        //该情况下 ,==的判断结果 cd为true ef为false,所以不要用==比较,-128~127的数值为true,其他为false
        Integer c = 99;
        Integer d = 99;
        Integer e = 139;
        Integer f = 139;
        //该情况下,==判断结果全为false,比较的内存地址,new出来的不同对象,地址不同
        //Integer c = new Integer(99);
        //Integer d = new Integer(99);
        //Integer e = new Integer(139);
        //Integer f = new Integer(139);

        boolean ab1 ;
        //boolean ab2 ;

        boolean cd = (c == d);
        boolean ef = (e == f);
        //a为null时,正常执行,均为null时,结果为true
        ab1 = Objects.equals(a, b);
        //a为null时,报NPE异常
        //ab2 = a.equals(b);
        System.out.println("----DamonJT-------ab1值=" + ab1 + "," + "当前类=AlibabaProtocalTest.equalsTest()");
        //System.out.println("----DamonJT-------ab2值=" + ab2 + "," + "当前类=AlibabaProtocalTest.equalsTest()");
        System.out.println("----DamonJT-------cd值=" + cd + "," + "当前类=AlibabaProtocalTest.equalsTest()");
        System.out.println("----DamonJT-------ef值=" + ef + "," + "当前类=AlibabaProtocalTest.equalsTest()");

    }

    @Test
    public void  stringSplitTest() {
        //需做最后一个分隔符后有无内容的检查,否则会有NPE风险
        String str = "a, b, c,,";
        String[] ary = str.split(",");
        //预期大于3,结果等于3
        System.out.println(ary.length);
    }

    @Test
    public void listToArrayTest() {
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        System.out.printf("----array值=%s%n", Arrays.toString(array));
    }

    @Test
    public void arrayToListTest() {
        String[] str = new String[] { "a", "b" };
        List list = Arrays.asList(str);
        System.out.println("----list值 = "+list);
        //str[0]修改后 list.get[0]随之修改
        str[0] = "gujin";
        System.out.println("----list值 = "+list);
    }

    @Test
    public void randomTest() {
        Random random = new Random();
        int k = random.nextInt();
        long g = random.nextLong();
        System.out.println("----k值 = "+k);
        System.out.println("----g值 = "+g);
        //两步生成0~15之内整数  [0,15)
        int aInt = random.nextInt();
        int bInt = Math.abs(aInt % 15);
        //直接生成
        int cInt = random.nextInt(15);
        System.out.println("--[0,15)--bInt值 = "+bInt);
        System.out.println("--[0,15)--cInt值 = "+cInt);

        int dInt = random.nextInt(15) + 20;
        System.out.println("--[20,35)--dInt值 = "+dInt);
    }


}
