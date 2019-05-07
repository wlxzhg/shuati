package cn.xiaozhigang.code.Basic.BasicGramer.reflex;

class ReflexTest {
    private String name = "test";
    private int age = 10;

    public int addAge(int step) {
        age += step;
        return age;
    }

    public void modifyName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ReflexTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
