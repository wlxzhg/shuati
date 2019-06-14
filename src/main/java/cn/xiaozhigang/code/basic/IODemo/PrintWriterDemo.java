package cn.xiaozhigang.code.basic.IODemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * 文本格式输出。PrintWriter类
 * */
public class PrintWriterDemo {

    public static void main(String[] args) throws IOException {
        System.out.println(Charset.forName("gb2312"));
        testPrintWriter1();
    }

    /**
     * 简单的输出测试
     * */
    private static void testPrintWriter1() throws IOException {
        PrintWriter pw = new PrintWriter("D://test_print_writer.txt","gb2312");

        for(int i = 0; i < 10; i++)
            pw.println("你好，世界！");
        pw.flush();
        pw.close();
    }
}
