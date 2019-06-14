package cn.xiaozhigang.code.basic.BasicGramer.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        String str = "hello";
        Class c1 = str.getClass(); //通过getClass方法获取class对象
        System.out.println(c1.getName());

        Class c2 = ReflexTest.class; //通过类的静态属性获取class对象
        System.out.println(c2.getName());
        ReflexTest obj = (ReflexTest) c2.newInstance();
        System.out.println(obj);

        Class c3 = Class.forName("cn.xiaozhigang.code.basic.BasicGramer.reflex.ReflexTest");
        System.out.println(c3.getName());

        System.out.println("abc".getClass().getName());

        String name = Class.forName("java.lang.String").getName();
        System.out.println(name);

        Field[] fields = c3.getDeclaredFields();
        System.out.println(c3.getName() + "的属性有：");
        for(Field f : fields)
            System.out.println(f.getName());
        Method[] methods = c3.getDeclaredMethods();
        System.out.println(c3.getName() + "的方法有：");
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        Constructor[] constructors = c3.getDeclaredConstructors();
        System.out.println(c3.getName() + "的构造方法有：");
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }

    }
}
