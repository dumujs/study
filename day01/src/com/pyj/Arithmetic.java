package com.pyj;

import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        // +
        System.out.println(1+1);
        System.out.println(1+1.01);
        System.out.println(1.1+1.01);
        System.out.println(1.1-1.01);
        // -
        System.out.println(10-1);
        // *
        System.out.println(1.1*1.01);
        // /
        System.out.println(1.7/1.1);
        System.out.println(10/2);
        System.out.println(10.0/3);
        System.out.println(10.3%3);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i;
        String s = String.valueOf(num);
        System.out.println(s.length());
        int j = s.length();
        while (j > 0) {
            System.out.println(s.charAt(s.length() - j));
            j --;
        }
        while (num > 0) {
            i = num % 10;
            System.out.println(i);
            num = num / 10;
        }
        /* 计算System.out.println */
        int a = 10;
        double d = 12.30;
        System.out.println(a + d);
        byte b1 = 11;
        byte b2 = 12;
        int sum = b1 + b2;
        //数据类型转换
        System.out.println(sum);
        byte sumByte =  (byte) (b1 + b2);
        System.out.println((char) sumByte);
        System.out.println(String.valueOf(true));
        //ASCII码表encoding
        char c1 = 'a';
        int num1 = 0;
        System.out.println(num1 + c1);
        // -- ++
        int addNum = 1;
        addNum = addNum ++ + (addNum --);
        System.out.println(addNum);
    }
    static void log(String s) {
        System.out.println(s);
    }
}
