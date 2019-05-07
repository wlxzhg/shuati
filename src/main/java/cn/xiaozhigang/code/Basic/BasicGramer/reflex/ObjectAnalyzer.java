package cn.xiaozhigang.code.Basic.BasicGramer.reflex;

import java.lang.reflect.Field;

public class ObjectAnalyzer {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("cn.xiaozhigang.code.Basic.BasicGramer.reflex.ReflexTest");
        Field fieldName = clazz.getDeclaredField("name");
        //因为是私有属性，需要设置访问权限
        fieldName.setAccessible(true);

        ReflexTest reflexTest = new ReflexTest();
        System.out.println(fieldName.get(reflexTest));
        //设置对象reflexTest的name属性为hello
        fieldName.set(reflexTest, "hello");
        System.out.println(reflexTest);

        Field fieldAge = clazz.getDeclaredField("age");
        fieldAge.setAccessible(true);
        //注意目标类的age属性为int类型，是基本数据类型。而Filed.get方法返回的是Object
        //所以这里用了getInt方法来得到其值
        int age = fieldAge.getInt(reflexTest);
        System.out.println(age);
        fieldAge.set(reflexTest,11);
        System.out.println(reflexTest);
    }
}
