package practice.basics;


/**
 * Created by DamonJT on 2017/3/9 0009.
 */
public class InitTest extends SubInitTest {

    int v = 1;

    public InitTest(){
        super(2);
    }

    @Override
    public void init(int v) {
        this.v = v;
        System.out.println("set v = "+v);
    }

    public static void main(String[] args) {
        InitTest c = new InitTest();
        System.out.println("main v = "+c.v);
    }
    /* 输出结果
     * set v = 2
     * main v = 1
     * 原因：
     * int v = 1; 的执行顺序是 先定义一个变量v, int v
     * 然后执行父类的构造方法，构造方法返回后 设置v的值为1。 v=1;
     * 所以在父类的构造方法内设置变量的值是无效的。
     */
    /*
     * Java api里没有这个方法的，是自定义的方法，为了不造成构造方法的代码过长，就把一些初始化工作操作放在Init中！
     */
}

