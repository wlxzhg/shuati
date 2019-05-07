package cn.xiaozhigang.code.Basic.IODemo;

import java.io.IOException;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) throws IOException{
        testScanner();
    }

    private static void testScanner() throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            System.out.println(line);
        }
    }
}
