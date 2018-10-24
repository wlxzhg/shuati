package cn.xiaozhigang.code.Basic.OOP.Extend;

public class Son extends Father{
    @Override
    public void eat() {
        System.out.println("son is eating");
    }

    public void eat(String food) {
        System.out.println("son is eating " + food);
    }

    public Son() {
        super();
        name = "Tom";
    }

    public static void main(String[] args) {
        Father people = new Son();
        people.eat();

        Son son = new Son();
        people = son;
        people.eat();

        System.out.println(people.name);
        son.eat("apple");
    }
}
