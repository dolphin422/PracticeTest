package practice.basics;

import org.junit.Test;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018/3/11 12:10
 */
public class NumberChangeTest {

    @Test
    public void changeIntTODouble () {
        String numStr = "21345";
        Double numDou = (Integer.valueOf(numStr))/1000.000;
        System.out.println("numDou值 ---->" + numDou );
    }

    @Test
    public void numToStringBelowZeor() {
        int a = -5;
        String s = String.valueOf(a);
        System.out.println("s值 ---->" + s );
        StringBuffer changeInfoBuffer = new StringBuffer("");
        Integer changeScore = 10;
        if(changeScore >= 0) {
            changeInfoBuffer.append("A");
            changeInfoBuffer.append(String.valueOf(changeScore));
        } else {
            changeInfoBuffer.append("S");
            changeInfoBuffer.append(String.valueOf(-changeScore));
        }
        Integer i = 12345;
        changeInfoBuffer.append(i);
        System.out.println("值 ---->" +  changeInfoBuffer.toString() );
    }
}
