package practice.basics;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018/3/11 16:42
 */
public class StringTest {

    @Test
    public void SubStringTest() {
        String id = "EP000062895S000062896A0123498765";
        String substring = id.substring(6);
        System.out.println("substring值 ---->" + substring);
        String s1 = id.substring(0, 1);
        String s2 = id.substring(1, 2);
        String s3 = id.substring(2, 11);
        String s4 = id.substring(11, 12);
        String s5 = id.substring(12, 21);
        String s6 = id.substring(21, 22);
        String s7 = id.substring(22, 27);
        String s8 = id.substring(27, 32);

        System.out.println("s1值 ---->" + s1);
        System.out.println("s2值 ---->" + s2);
        System.out.println("s3值 ---->" + s3);
        System.out.println("s4值 ---->" + s4);
        System.out.println("s5值 ---->" + s5);
        System.out.println("s6值 ---->" + s6);
        System.out.println("s7值 ---->" + s7);
        System.out.println("s8值 ---->" + s8);

    }

    public static boolean IsHasSQLInjectUse(String str)  {
        boolean isHasSQLInject = false;

        String reg = ";|<|>|'|\\.\\./|(\\b(union|insert|select|delete|update|drop|alter|truncate|declare|xp_)\\b)";
        Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        str = str.toLowerCase().trim();
        Matcher matcher = sqlPattern.matcher(str);
        if (matcher.find()) {
            System.out.println("未能通过校验的字符为---->:  " + matcher.group(0));
        }else {
            System.out.println("---NEW----校验通过------");
        }
        return isHasSQLInject;
    }
    @Test
    public void SQLTest() {
        String str = "adslkfjadafdintdropocreate_date a../. ./ 2342";
        //isValid(str.toLowerCase().trim());
        IsHasSQLInject(str.toLowerCase().trim());
        IsHasSQLInjectUse(str);
    }



   /* *//***************************************************************************
     * 参数校验
     *
     * @param str
     *//*
    public static void isValid(String str) {

        Matcher matcher = sqlPattern.matcher(str);
        if (matcher.find()) {
            System.out.println("未能通过字符校验有---->:  " + matcher.group(0));
            for(int i=0; i<=matcher.groupCount(); i++){
                System.out.println(i+" -->:  "+matcher.group(i));
            }
        } else {
            System.out.println("校验通过 ---->");

        }
    }
*/
   /* static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*//*)|;|<|>|'|\\.\\./|"
        +
        "(\\b(union|insert|select|delete|update|drop|alter|truncate|declare|xp_)\\b)";

    static String reg1 = ";|<|>|'|\\.\\./|(\\b(union|insert|select|delete|update|drop|alter|truncate|declare|xp_)\\b)";

    static Pattern sqlPattern = Pattern.compile(reg1, Pattern.CASE_INSENSITIVE);*/



    public static void IsHasSQLInject(String str) {

        //字符串中的关键字更具需要添加
        String inj_str = "union|insert|select|delete|update|drop|alter|truncate|declare|xp_|;|<|>|'|../";
        //String inj_str = "union|insert|select|delete|update|drop|alter|truncate|declare|xp_|;|<|>|'|*";
        str = str.toLowerCase().trim();

        String[] inj_str_array = inj_str.split("\\|");

        for (String sql : inj_str_array) {
            if (str.contains(sql)) {
                System.out.println("---OLD----非法字符为: " + sql);
            }
        }

    }
}
