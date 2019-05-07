package cn.xiaozhigang.code.Basic.BasicGramer;

public class Test {
    public static Test t1 = new Test();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args) {
        Test t2 = new Test();

        System.out.println("abv".getClass().getName());

        Integer a = 10;
        try {
            System.out.println(Class.forName("java.lang.Integer").getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
