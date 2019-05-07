package cn.xiaozhigang.code.Basic.IODemo;

import java.io.*;
import java.util.Scanner;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException{
//        testBufferedReader();
        testScanner();
    }

    private static void testBufferedReader() throws IOException{
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("D://test_buffered_reader.txt"),
                        "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }

    private static void testScanner() throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(
                new FileInputStream("D://test_print_writer.txt"),"gb2312"));
        int lineNum = 0;
        while (sc.hasNext()) {
            System.out.println("line " + (++lineNum) + " :");
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
