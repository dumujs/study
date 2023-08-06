package com.pyj;

import java.util.Arrays;
import java.util.Random;

public class Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[arr.length];
        arr2[2] = 2;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }
        System.out.println(Arrays.toString(strArr) + strArr.getClass().getName());
        System.out.println(strArr[0].getClass().getName());
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
        int num = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[num];
            arr[num] = temp;
        }
        System.out.println(Arrays.toString(arr) + arr.length);
    }

    public static void sum() {
        System.out.println("sum");
    }
}
