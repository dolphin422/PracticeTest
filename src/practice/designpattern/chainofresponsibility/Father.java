package practice.designpattern.chainofresponsibility;

/**
 * 子类
 * Created by DamonJT on 2018/1/11 0011.
 */
public class Father extends Handler{
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);

    }

}
