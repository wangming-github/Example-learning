package com.wangming.algorithm.polymorphism;

import org.junit.Test;

import java.sql.Connection;

/**
 * 面向对象特征三：多态（封装 继承 多态）
 * 理解为一个事物的多种形态：父类的引用指向子类的对象
 * 虚拟方法调用：子类中定义了与父类同名同参数的方法，在多态的情况下，将此时父类的方法称为虚拟方法。
 * 在编译期：只能调用父类声明的方法，但是实际执行是子类重写父类的方法。
 * 对象多态性只适用于方法，不适用于属性。
 * <p>
 * 使用前提：
 * 1> 要有类的继承（extends）关系
 * 2> 子类重写父类同名同参方法
 * <p>
 * 重载/重写
 * 重载:同名方法，不同参数。在方法调用之前就确定要调用的方法。
 * 重写:要等到方法调用的那一刻，解释运行器才知道要调用的方法。（晚绑定）
 */

//举例 1
public class AnimalTest {

    public static void fun(Animal animal) {
        System.out.println("Animal");
        animal.eat();
        animal.shout();
    }

    //
    //public static void fun(Dog animal) {
    //    System.out.println("Dog");
    //    animal.eat();
    //    animal.shout();
    //}
    //
    //
    //public static void fun(Cat animal) {
    //    System.out.println("Cat");
    //    animal.eat();
    //    animal.shout();
    //}


    //什么是多态
    @Test
    public void test1() {


        //NEW 子类对象即为多态
        fun(new Dog());
        fun(new Cat());

    }

}


class Animal {
    public void eat() {
        System.out.println("动物 进食...");
    }

    public void shout() {
        System.out.println("动物 嚎叫...");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗 吃骨头...");
    }

    public void shout() {
        System.out.println("汪汪汪...");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫 吃鱼...");
    }

    public void shout() {
        System.out.println("喵喵喵...");
    }
}


//举例 2
class Order {
    public void mathod(Object o) {

    }
}


//举例 3
class Driver {
    //各种DB数据库连接
    public void doData(Connection connection) {//connection = new  MySQLConnection();//connection = new  OricleConnection();
        //connection.method1();
        //connection.method2();
        //connection.method3();
    }
}