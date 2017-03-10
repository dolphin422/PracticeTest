package interview.practice.file;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

    /**
     * Created by DamonJT on 2017/3/9 0009.
     */
public class IOTest {

    public static void main(String[] args) {
        File file = new File("E://test");
        ReadSubdirectory(file);
    }


    public static void ReadSubdirectory(File myDir) {
        // 判断myDir是否为文件目录
        if (myDir.isDirectory()) {
            File[] subFile = myDir.listFiles();
            for (int i = 0; i < subFile.length; i++) {
                // 如果列表下含有子目录
                if (subFile[i].isDirectory()) {
                    ReadSubdirectory(subFile[i]);
                } else {
                    ReadSubFile(subFile[i]);
                }
            }
        }
    }
    // 统计当前文件中数字 字母 空格的个数 和 文件行数
    public static void ReadSubFile(File file) {
        int numCount = 0;// 数字个数
        int letterCount = 0;// 字母个数
        int spaceCount = 0;// 空格个数
        int lineCount = 0;//行数
        int uniChar = 0;
        try {
            FileInputStream input = new FileInputStream(file);
            while ((uniChar = input.read()) != -1) {
                if (uniChar >= 48 && uniChar <= 57) {// 判断是否是数字
                    numCount++;
                } else if ((uniChar >= 65 && uniChar <= 90) || (uniChar >= 97 && uniChar <= 122)) {// 判断是否是字母
                    letterCount++;
                } else if (uniChar == 32) {// 判断是否是空格
                    spaceCount++;
                }
            }
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while(buffer.readLine() != null) {
                lineCount++;
            }
            System.out.println(file.getAbsolutePath());
            System.out.println(" 数字个数 : " + numCount);
            System.out.println(" 字母个数 : " + letterCount);
            System.out.println(" 空格个数 : " + spaceCount);
            System.out.println(" 行数数 : " + lineCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void fileToStdout1() {

        String s;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("E://test//hello.txt"));
            while ((s = in.readLine()) != null){

                System.out.println(s);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileToStdout2() {

        int b;
        FileReader in = null;
        try {
            in = new FileReader("E://test//hello.txt");
            while ((b = in.read()) != -1){
                System.out.print((char)b);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileAToFileB() {

        int b;
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            //不加路径,默认路径为项目路径/interviewpractice/下
            in = new FileInputStream("E://test//hello.txt");
            out = new FileOutputStream("E://test//copy.txt");
            while ((b = in.read()) != -1){
                out.write(b);
            }
            out.flush();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scannerTest() {

        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        for (char c : ch){
            System.out.println("----c值 = "+c);
        }
    }

    @Test
    public void stdinToFile() throws IOException {
        Scanner in = new Scanner(System.in);
        FileWriter out = new FileWriter("E://test//stdinToFile.txt");
        String s;
        while (!(s = in.nextLine()).equals("Q")){
            out.write(s + "\n");
        }
        out.flush();
        out.close();
        in.close();
    }

    @Test
    public void stdinTest() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String hello = null;
        try {
            hello = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hello);
    }
        //just test git and github



}
