package practice.dataanalysis;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018/3/25 9:09
 */
public class DataAnalysisTest {

    @Test
    public void writeToExcel() throws IOException {
        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二部，在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet("专利列表");
        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("专利名");
        cell = row.createCell(1);
        cell.setCellValue("申请公布号");
        cell = row.createCell(2);
        cell.setCellValue("申请公布日");
        cell = row.createCell(3);
        cell.setCellValue("申请号");
        cell = row.createCell(4);
        cell.setCellValue("申请日");
        cell = row.createCell(5);
        cell.setCellValue("申请人");
        cell = row.createCell(6);
        cell.setCellValue("发明人");
        cell = row.createCell(7);
        cell.setCellValue("摘要");



        //第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
        List<PatentVo> alldata = getData();
        for (int i = 0; i < alldata.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            PatentVo user = alldata.get(i);
            //创建单元格设值
            row1.createCell(0).setCellValue(user.getName());
            row1.createCell(1).setCellValue(user.getPublishNum());
            row1.createCell(2).setCellValue(user.getPublishDate());
            row1.createCell(3).setCellValue(user.getApplicationNum());
            row1.createCell(4).setCellValue(user.getApplicationDate());
            row1.createCell(5).setCellValue(user.getApplicant());
            row1.createCell(6).setCellValue(user.getInventor());
            row1.createCell(7).setCellValue(user.getSimpleContent());
        }

        //将文件保存到指定的位置
        try {
            FileOutputStream fos = new FileOutputStream("D:\\DamonJT\\桌面\\专利0326.xls");
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    public  List<PatentVo> getData() throws IOException {
        List<PatentVo> allVO = new ArrayList<>();
        File input = new File("D:\\01工作文件\\区块链专利列表\\区块链专利");
        File[] files = input.listFiles();
        for (File file : files ) {
            List<PatentVo> fileInfo = this.getFileInfo(file);
            allVO.addAll(fileInfo);
        }
        return allVO;

       /*
        int i = 0;
        for (PatentVo patentVo : fileInfo) {
            System.out.println("i值 ---->" + i + "-------------------------------------");
            System.out.println("patentVo.toString()值 ---->" + patentVo.toString());
            System.out.println("i值 ---->" + i++ + "--------------------------------------");
        }*/
    }


    public List<PatentVo> getFileInfo(File input) throws IOException {

        Document doc = Jsoup.parse(input, "utf-8", "");

        //得到<tr>标签的类容，select()是类似一个选择器的东西,(".zi_06")表示选择class = zi_06的tr标签
        Elements heads = doc.getElementsByTag("div").select(".cp_linr");
        //int i = 1;
        List<PatentVo> patentVoList = new ArrayList<>();
        for (Element element : heads) {
            PatentVo patentVo = new PatentVo();
            Elements h1 = element.getElementsByTag("h1");
            String name = h1.text();
            if (name.contains("区块链")) {
                String substringName = name.substring(name.indexOf("]") + 1);
                patentVo.setName(substringName);
               /* System.out.println
                    ("------" + i + "--------------------------start-------------------------------------");
*/
                // System.out.println("name值 ---->" + name);
                Elements li = element.getElementsByTag("li");
                for (Element eli : li) {
                    String text = eli.text();
                    if (text.contains("申请公布号")) {
                        String substring = text.substring(text.indexOf("：") + 1);

                        patentVo.setPublishNum(substring);
                    }
                    if (text.contains("申请公布日")) {
                        String substring = text.substring(text.indexOf("：") + 1);
                        patentVo.setPublishDate(substring);
                    }
                    if (text.contains("申请号")) {
                        String substring = text.substring(text.indexOf("：") + 1);
                        patentVo.setApplicationNum(substring);
                    }
                    if (text.contains("申请日")) {
                        String substring = text.substring(text.indexOf("：") + 1);
                        patentVo.setApplicationDate(substring);
                    }
                    if (text.contains("申请人")) {
                        String substring = text.substring(text.indexOf("：") + 1);
                        patentVo.setApplicant(substring);
                    }
                    if (text.contains("发明人")) {
                        String substring = text.substring(text.indexOf("：") + 1);
                        patentVo.setInventor(substring);
                    }

                    // System.out.println("text值 ---->" + text);
                }
                Elements div = element.getElementsByTag("div").select(".cp_jsh");
                String tit = div.text();
                String substringTit = tit.substring(tit.indexOf("：") + 1);
                // System.out.println("tit值 ---->" + tit);
                patentVo.setSimpleContent(substringTit);
                patentVoList.add(patentVo);
               /* System.out.println
                    ("---------" + i++ + "-------------------------end-----------------------------------");
           */
            }
        }
        return patentVoList;
    }
}
