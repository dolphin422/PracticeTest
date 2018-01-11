package practice.designpattern.chainofresponsibility;

/**
 * 责任链模式
 * Created by DamonJT on 2018/1/11 0011.
 */
public abstract class Handler {

    public final static int FATHER_LEVEL_REQUEST =1;
    public final static int  HUSBAND_LEVEL_REQUEST = 2;
    public final static int  SON_LEVEL_REQUEST = 3;


    private int level = 0;
    private Handler nextHandler;
    public Handler (int _level)  {
        this.level = _level;
    }

    public final void  HandleMessage() {
        System.out.println("-----level值=" + level + "," + "当前类 = Handler.HandleMessage()");
    }
}
