package cn.xiaozhigang.code.Basic.BasicGramer.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args) {
        String name = null;
        if(args.length != 0) {
            name = args[0];
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入类名，（如java.lang.Integer）:");
            name = sc.next();
            sc.close();
        }

        try {
            Class clazz = Class.forName(name);
            String modifier = Modifier.toString(clazz.getModifiers());
            if(modifier.length() > 0)
                System.out.print(modifier + " ");
            System.out.print(name);
            Class superClass = clazz.getSuperclass();
            if(superClass != null && superClass != Object.class) {
                System.out.print(" extends " + superClass.getName());
            }
            System.out.println(" {");
            System.out.println("\t//Declare方法列表");
            printDeclareMethods(clazz);
            System.out.println("\t//Declare构造方法列表");
            printDeclareConstructors(clazz);
            System.out.println("\t//Declare属性列表");
            printDeclareField(clazz);
            System.out.print("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printDeclareMethods(Class clazz) {
        if(clazz == null) throw new IllegalArgumentException("入参不能为null");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods) {
            String modifier = Modifier.toString(m.getModifiers());
            System.out.print("\t");
            if(modifier.length() > 0)
                System.out.print(modifier + " ");
            System.out.print(m.getReturnType().getName() + " " + m.getName() + "(");
            Class[] parameters = m.getParameterTypes();
            for(int i = 0; i < parameters.length; i++) {
                if(i > 0)
                    System.out.print(",");
                System.out.print(parameters[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printDeclareConstructors(Class clazz) {
        if(clazz == null) throw new IllegalArgumentException("入参不能为null");

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor c : constructors) {
            System.out.print("\t");
            String modifier = Modifier.toString(c.getModifiers());
            if(modifier.length() > 0)
                System.out.print(modifier + " ");
            System.out.print(c.getName() + "(");
            Class[] parameters = c.getParameterTypes();
            for(int i = 0; i < parameters.length; i++) {
                if(i > 0)
                    System.out.print(",");
                System.out.print(parameters[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printDeclareField(Class clazz) {
        if(clazz == null)
            throw new IllegalArgumentException("入参不能为null");
        Field[] fields = clazz.getDeclaredFields();
        for(Field f  : fields) {
            System.out.print("\t");
            String modifier = Modifier.toString(f.getModifiers());

            if(modifier.length() > 0)
                System.out.print(modifier + " ");
            Class type = f.getType();
            System.out.print(type.getName() + " ");
            System.out.println(f.getName() + ";");
        }
    }
}
