package com.api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ArraysApi {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(Arrays.toString(a));
        Integer[] b = {1, 1, 1, 1};
        System.out.println(Arrays.binarySearch(b, 30));
        Random r = new Random();
        for (int i = 0; i < b.length; i++) {
            int rI = r.nextInt(b.length - 1);
            int temp = b[i];
            b[i] = b[rI];
            b[rI] = temp;
        }
        System.out.println(Arrays.toString(b));
        // lambda 表达式
        /**
         * sort 二分查找 + 插入排序
         */
        Arrays.sort(b, (o1, o2) -> {
            System.out.println("o1=" + o1);
            return o1 - o2;
        });
        System.out.println(Arrays.toString(b));

        String[] s = {"afdf", "dfsdf", "fsdf", "dfsdf", ""};
        Arrays.sort(s, (o1, o2) -> {
            System.out.println("o1=" + o1);
            return o1.compareTo(o2);
        });
        System.out.println(Arrays.toString(s));
        /**
         * 不死神兔
         */
        System.out.println(sum(12));

    }
    public static int sum(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        if (i == 2) return 2;
        if (i > 2) {
            return sum(i - 1) + sum(i - 2);
        }
        return 0;
    }
}
