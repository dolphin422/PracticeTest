package practice.spider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018/3/16 22:24
 */
public class SpiderTest {

    @Test
    public void spiderTest() throws IOException {
        for (int i= 0; i < 54 ; i++) {
            //this.getFeiInfo(i);
        }
        this.getFeiInfo(1);
    }



    public void getFeiInfo(int numSize) throws IOException {
        //发送请求Jsoup的静态方法connect，参数是我们要请求的头信息，返回的是Connection对象，
        //connection对象的静态方法date()用于包装请求的参数，我们这里要加的是sqh，返回的仍然是是Connection对象
        //然后是发送信息，调用Connection的post()方法     (此外还有get()方法，详细的信息可以查看jsoup的docs)
        //post()方法返回的是Document对象
      /*  Document doc = Jsoup
            .connect("http://app.sipo.gov.cn:8080/searchfee/searchfee_action.jsp").data("sqh", sqid).post();*/
/*        Document doc = Jsoup
            .connect("http://epub.sipo.gov.cn/patentoutline.action?showType=1&strSources=pip&strWhere=PA%2CIN%2CAGC%2CAGT%2B%3D%27%25%E5%8C%BA%E5%9D%97%E9%93%BE%25%27+or+PAA%2CTI%2CABH%2B%3D%27%E5%8C%BA%E5%9D%97%E9%93%BE%27&numSortMethod=4numIp=0&numIg=0&numUg=0&numDg" +
                "=0&pageSize=20&pageNow=2").get();*/
        //上面的一行也可以用下面的几行代码替换
        Connection conn = Jsoup.connect("http://epub.sipo.gov.cn/patentoutline.action");
        //conn = conn.data("sqh", );
         conn = conn.data("showType", "1")
        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)" +
            " " +"Chrome/59.0.3071.115 Safari/537.36")
             .cookie("_gscu_2029180466","1");
        Document doc = conn.post();
/*       Document doc = Jsoup.connect("http://epub.sipo.gov.cn/patentoutline.action")
            .data("query", "Java")
            .userAgent("Mozilla")
            .cookie("auth", "token")
            .timeout(3000)
            .post();*/
        //得到<tr>标签的类容，select()是类似一个选择器的东西,(".zi_06")表示选择class = zi_06的tr标签
        Elements heads = doc.getElementsByTag("div").select(".cp_box");
        for (Element element : heads) {
            System.out.print(element.text()+"\t");
        }
        System.out.println();
        //下面的原理和上面的一致,至于为什么两个select()的参数不一样是因为我要要选择的内容不同
        //上面的是显示表头信息，下面的是显示表头之下的具体收费信息了
       /* Elements info = doc.getElementsByTag("tr").select(".dixian1");
        int i = 0;
        for (Element element : info) {
            i++;
            System.out.print(element.text()+"\t");
            //因为我知道这个表格只有8列
            if(8==i){
                System.out.println();
                i=0;
            }
        }*/

    }

}
