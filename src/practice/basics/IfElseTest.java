package practice.basics;

import org.junit.Test;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018.07.03 18:58
 */
public class IfElseTest {

    @Test
    public void ifElseTest(int a) {

        if (a > 5) {
            System.out.println("a值 >5 ---->");
        } else if (a > 10) {
            System.out.println("a值 >10 ---->");
        } else if (a > 15) {
            System.out.println("a值 >15 ---->");
        }
    }

    @Test
    public void switchCaseIntTest(int str) {
        switch (str) {
        case 5:
            System.out.println("5 ---->");
            break;
        case 10:
            System.out.println("10 ---->" );
            break;
        case 15:
            System.out.println("15 ---->");
            break;
        default:
            System.out.println("int值 ---->");
        }
        System.out.println("intTest ---->");
    }

    @Test
    public void switchCaseStrTest(String str) {
        switch (str) {
        case "a":
            System.out.println("a值 ---->");
            break;
        case "b":
            System.out.println("b值 ---->" );
            break;
        case "x":
            System.out.println("x值 ---->");
            break;
        case "z":
            System.out.println("z值 ---->");
            break;
        default:
            System.out.println("abxz值 ---->");
        }
        System.out.println("strTest ---->");
    }
}
