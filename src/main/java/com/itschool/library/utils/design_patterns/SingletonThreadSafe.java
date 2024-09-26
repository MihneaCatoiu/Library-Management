package com.itschool.library.utils.design_patterns;

public class SingletonThreadSafe {

    private static volatile SingletonThreadSafe instance;

    private SingletonThreadSafe() {
    }

    static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}

class Test1 {
    public static void main(String[] args) {
        SingletonThreadSafe singleton1 = SingletonThreadSafe.getInstance();
        System.out.println(singleton1);
    }
}