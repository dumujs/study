package com.pyj;

public class BaseDataType {

    public static void main(String[] args) {
        int n = 5;
        log(n);
        long ln = 111111L;
        log(ln);
        byte bn = 127;
        log(bn);
        float f = 1.000F;
        log(f);
        double d = 9.99999999;
        log(d);
        short b = 999;
        log(b);
        char c = 'a';
        log(c);
        boolean flag = n == d;
        String str = "你好，菜鸟";
        log(str);
        // java.lang.Void是一个不可实例化的占位符类，用来表示一个引用代表Java关键字void的Class对象
        log("java.lang.Void是一个不可实例化的占位符类，用来表示一个引用代表Java关键字void的Class对象");
    }

    static <T> void log(T val) {
        System.out.println("输入class名：" + val.getClass().getName());
        System.out.println(val);
    }
    static <T> void log() {
        System.out.println("无数据");
    }
}
