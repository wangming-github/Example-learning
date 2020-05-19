package com.wangming.algorithm.polymorphism;

import org.junit.Test;

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


public class PersonTest {

    //什么是多态
    @Test
    public void test1() {

        Person person = new Person();
        person.eat();
        Person man = new Man();
        man.eat();

        System.out.println("==========对象的多态==========");
        Person man1 = new Man();
        man1.eat(); //编译看左边，执行看右边。
        System.out.println(man1.id);//1000?1001

        Person man2 = new Woman();
        man2.eat(); //编译看左边，执行看右边。
        System.out.println(man2.id);//1000?1002
    }


}

class Person {
    int id = 1000;
    String name;
    int age;

    public void eat() {
        System.out.println("吃饭");
    }

    public void walk() {
        System.out.println("走路");
    }
}


class Man extends Person {

    int id = 1001;
    boolean isSmoking;

    public void tackMoney() {
        System.out.println("挣钱");
    }

    public void eat() {
        System.out.println("多吃饭....");
    }

    public void walk() {
        System.out.println("霸气走路");
    }
}

class Woman extends Person {

    int id = 1003;
    boolean isbBauty;

    public void goShopping() {
        System.out.println("购物");
    }

    public void eat() {
        System.out.println("少吃饭....");
    }

    public void walk() {
        System.out.println("窈窕走路....");
    }
}
