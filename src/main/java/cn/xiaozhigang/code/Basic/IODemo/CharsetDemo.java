package cn.xiaozhigang.code.Basic.IODemo;

import java.nio.charset.Charset;
import java.util.Set;

public class CharsetDemo {
    public static void main(String[] args) {
        Charset cset = Charset.forName("ISO-8859-1");

        Set<String> aliases = cset.aliases();

        for (String alias : aliases) {
            System.out.println(alias);
        }
    }
}
