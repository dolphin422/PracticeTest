package interview.practice.file;

import java.util.regex.Pattern;

import org.junit.Test;

public class GetURLFromString {

    public String getURLFromString(String sourceString) {
        //正则表达式
        String regex = "^([(][1-9]\\d*[)][a-zA-Z0-9]+){3,4}([(][0][)])$";
        //判断是否满足格式
        boolean isMatch=Pattern.matches(regex, sourceString);

        //判断方式二
        /* 
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(sourceString);
        boolean isMatch = m.matches();
        */
        
        if (!isMatch) {  //非字符前要不要加空格?
            return sourceString;
        }
        //等待拼接的目标字符串
        StringBuffer destStringBuffer = new StringBuffer();
        //源字符串利用左括号分割
        String[] totalStrings = sourceString.split("[(]");
        int totalLength = totalStrings.length;
        //拆分后最后一个字段为0),不用处理,只循环到 总长度-1 
        for (int i = 0; i < totalLength-1; i++) {
            //判断并排除因切分产生的空字符串
            if (totalStrings[i]!=null && !"".equals(totalStrings[i])) {
                //切分后的字符串再次利用右括号切割,切出前端数字和后端字母
                String[] singleString = totalStrings[i].split("[)]");
                
                int num = Integer.parseInt(singleString[0]);
                //前端数字不等于字母个数,说明格式不满足,原样返回
                if (num != singleString[1].length()) {
                    return sourceString;
                }
                //加取出的字母拼接到目标字符串,并加上"."
                destStringBuffer = destStringBuffer.append(singleString[1]+".");
            }
        }
        //去掉最后的"."
        destStringBuffer = destStringBuffer.deleteCharAt(destStringBuffer.length()-1);
        String destString = destStringBuffer.toString();
        return destString;
    }
    
    @Test
    public void getURLFromStringTest() {
        //Scanner sc =new Scanner(System.in);
        //String sourceString =sc.nextLine();
        //可解析
        String sourceString1 = "(3)www(5)baidu(3)com(0)";
        String sourceString2 = "(2)he(3)12a(3)gov(2)cn(0)";
        //数字超过10
        String sourceString3 = "(12)he1234567890(3)122(3)gov(2)cn(0)";
        //数字与字段内字母个数不同
        String sourceString4 = "(2)headd(3)122(3)gov(2)cn(0)";
        //字段为 2或 5个时
        String sourceString5 = "(2)he(3)122(0)";
        String sourceString6 = "(2)he(3)122(3)gov(2)cn(3)gov(0)";
        //未以(0)结束
        String sourceString7 = "(2)he(3)122(3)gov(2)cn(1)";
        //中间带0的情况
        String sourceString8 = "(2)he(3)122(0)(2)cn(0)";
        //加杂其他字符
        String sourceString9 = "a(2)he(3)1-22(3)gov(2)cn(0)";
        
        String sourceString10 = "(02)he(3)122(3)gov(2)cn(0)";
        
        String destString1 =getURLFromString(sourceString1);
        String destString2 =getURLFromString(sourceString2);
        String destString3 =getURLFromString(sourceString3);
        String destString4 =getURLFromString(sourceString4);
        String destString5 =getURLFromString(sourceString5);
        String destString6 =getURLFromString(sourceString6);
        String destString7 =getURLFromString(sourceString7);
        String destString8 =getURLFromString(sourceString8);
        String destString9 =getURLFromString(sourceString9);
        String destString10 =getURLFromString(sourceString10);
        System.out.println(sourceString1+"  ==1==>  "+destString1);
        System.out.println(sourceString2+"  ==2==>  "+destString2);
        System.out.println(sourceString3+"  ==3==>  "+destString3);
        System.out.println(sourceString4+"  ==4==>  "+destString4);
        System.out.println(sourceString5+"  ==5==>  "+destString5);
        System.out.println(sourceString6+"  ==6==>  "+destString6);
        System.out.println(sourceString7+"  ==7==>  "+destString7);
        System.out.println(sourceString8+"  ==8==>  "+destString8);
        System.out.println(sourceString9+"  ==9==>  "+destString9);
        System.out.println(sourceString10+"  ==10==>  "+destString10);
    }
}
