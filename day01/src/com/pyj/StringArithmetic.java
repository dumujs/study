package com.pyj;

import java.util.Scanner;

public class StringArithmetic {
    public static void main(String[] args) {
        String str = "ab";
        String st = new String("ab");
        String str1 = "ab";
        String str2 = "cd";
        String str3 = "abc";
        String str4 = "d";
        char[] c = {97, 98, 99, 100};
        String strC = new String(c);
        System.out.println("==" + (str1 + str2 == str3 + str4));
        System.out.println("==" + (str1 == str));
        System.out.println("==" + (str1 == st));
        System.out.println("==" + strC.equals(str3 + str4));
        // 键盘录入与直接赋值比较
        //Scanner sc = new Scanner(System.in);
        //String strSc = sc.next();
        String str5 = "abc";
        //System.out.println(str5 == strSc);
        for (int i = 0; i < str5.length(); i++) {
            System.out.println(str5.charAt(i));
        }
        int[] intArr = {1, 2,3 ,4,5,6,7,8,9,10,11};
        System.out.println(ArrayToString(intArr));
        System.out.println(Integer.valueOf('0'));
        System.out.println('4' - '0');
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append('a');
        }
        System.out.println("123" + sb);
        //下面很慢
        //String s = "";
        //for (int i = 0; i < 1000000; i++) {
        //    s += "a";
        //}
        //System.out.println("123" + s);
    }
    static String ArrayToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        str += "]";
        return str;
    }
}
