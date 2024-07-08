package com.springboot.sample;

public class SingletonClass {

    private SingletonClass(){}

    private static class LazyHolder{
        private static SingletonClass INSTANCE = new SingletonClass();
    }

    public static SingletonClass getInstance(){

        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {

        SingletonClass singletonClass = getInstance();


    }
}
