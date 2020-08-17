package com.com.wkp.misctest;

/**
 * @Description DESC
 * @Date 2020/8/13 11:37 下午
 * @Created by wangkunpeng
 */
public enum Singleton {
    INSTANCE;

    private Singleton() {
        System.out.println("枚举创建对象了");
    }

    public static void test() {
        Singleton t1 = Singleton.INSTANCE;
        Singleton t2 = Singleton.INSTANCE;
        System.out.print("t1和t2的地址是否相同：" + (t1 == t2));
    }

    public static void main(String[] args) {
        test();
    }

}