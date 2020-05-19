package com.wangming.algorithm.thread;

//管理懒汉式的线程安全问题 使用同步机制
//对于一般的方法内使用同步机制考虑使用this
//对于 static 静态方法而言
class Singleton {
    private Singleton() {
    }

    public static Singleton singleton = null;

    public static Singleton getSingleton() {


        if (singleton == null) { //提高效率
            //Singleton.class => 返回的类对象
            synchronized (Singleton.class) {
                //线程同步
                //由于同一个时间只能有一个线程访问共享数据 效率变低 但是尽管如此仍需要使用同步
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void setSingleton(Singleton singleton) {
        Singleton.singleton = singleton;
    }
}

public class Lang_Day2_Thread_Singleton {

    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();

        System.out.println(singleton1 == singleton2);
    }
}
