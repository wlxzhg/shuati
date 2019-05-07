package cn.xiaozhigang.code.Basic.JDK8NewFeature;

public class InterfaceDemo {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return a + 1;
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(100));
    }
}

interface Formula {
    //计算
    double calculate(int a);

    //求平方根
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
