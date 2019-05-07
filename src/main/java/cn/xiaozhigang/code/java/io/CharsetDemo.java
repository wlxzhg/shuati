package cn.xiaozhigang.code.java.io;

import java.nio.charset.Charset;
import java.util.Map;

public class CharsetDemo {
    public static void main(String[] args) {
        Map<String,Charset> charsetMap = Charset.availableCharsets();
        for (String name : charsetMap.keySet()) {
            System.out.println(name);
        }

        Charset charset = Charset.forName("utf-8");

    }
}
