package cn.xiaozhigang.code.basic.IODemo.regular;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularForIdNum {
    public static void main(String[] args) {
        String patternString = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
        System.out.println(patternString);
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher("370830199319166831");
        System.out.println(matcher.matches());

        Scanner sc = null;
        PrintWriter writer = null;
        try {
            sc = new Scanner(new FileInputStream("id_num.txt"));
            writer = new PrintWriter("id_num_result.txt");

            while(sc.hasNext()) {
                String idNum = sc.nextLine();
                Matcher matcher1 = pattern.matcher(idNum);
                boolean result = matcher1.matches();
                if(!result) {
                    System.out.println(idNum + "\t" + result);
                }
                writer.println(idNum + "\t" + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
            writer.close();
        }



    }
}
