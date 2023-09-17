package com.api;

import com.pyj.Array;
import com.sun.corba.se.spi.protocol.ForwardException;

import java.util.*;
import java.util.function.Consumer;

public class CollectionTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        Iterator<Integer> iterator = arr.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Collection<Integer> col = new HashSet<>();
        col.add(0);
        col.add(2);
        col.add(5);
        col.add(4);
        Iterator<Integer> it = col.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (Integer integer : col) {
            System.out.println(integer);
        }
        Collection<String> strList = new ArrayList<>();
        strList.add("aaaa");
        strList.add("bb");
        strList.add("cc");
        strList.add("dd");
        strList.forEach(s -> System.out.println(s));
    }
}
