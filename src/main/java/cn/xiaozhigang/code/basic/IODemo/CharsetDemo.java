package cn.xiaozhigang.code.basic.IODemo;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

public class CharsetDemo {
    public static void main(String[] args) {
//        Charset cset = Charset.forName("ISO-8859-1");
//
//        Set<String> aliases = cset.aliases();
//
//        for (String alias : aliases) {
//            System.out.println(alias);
//        }

        SortedMap<String,Charset> map = Charset.availableCharsets();

        for (Map.Entry<String, Charset> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
