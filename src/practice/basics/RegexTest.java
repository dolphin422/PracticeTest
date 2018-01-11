package practice.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {
    @Test
    public void chineseCharRegexTest() {
        String regex = "^(张|赵|王)";
        Pattern pattern = Pattern.compile(regex);
        String text = "王小丫";
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            System.out.println("找到了: " + matcher.group(0));
        }else{
            System.out.println("找不到");
        }
    }
    
    
    @Test
    public void chineseCharRegexTest2() {
        String regex = "[\\u4e00-\\u9fa5]+";
        Pattern pattern = Pattern.compile(regex);
        
        String text = "张小丫lxy李小二";
        Matcher matcher = pattern.matcher(text);
        //每调用一次matcher.find 就向下查寻一次
        while (matcher.find()) {
            System.out.println("找到了: " + matcher.group(0));
        }
    }
    
    /*
    * 首先要弄清Java正则表达式中的捕获组的概念。捕获组也就是Pattern中以括号对“()”分割出的子Pattern。
    * 至于为什么要用捕获组呢，主要是为了能找出在一次匹配中你更关心的部分。
    * 捕获组可以通过从左到右计算其开括号来编号。例如，在表达式 "(x)(y\\w*)(z)" 中，存在三个这样的组：  
    * 1.   x
    * 2.   y\\w*
    * 3.   z
    * 组零始终代表整个表达式。
    * 之所以这样命名捕获组是因为在匹配中，保存了与这些组匹配的输入序列的每个子序列。
    * 捕获的子序列稍后可以通过 Back 引用在表达式中使用，也可以在匹配操作完成后从匹配器获取。
    * 以 (?) 开头的组是纯的非捕获 组，它不捕获文本，也不针对组合计进行计数
    */
    @Test
    public void groupTest() {
        String regex = "(x)(y\\w*)(z)";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        String input = "exy123z,xy456z";
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println(m.group(0));
        }
    }

}
