package com.base;

public interface InterA {
    public void print(String str);
    public default void A(String str){
        System.out.println(str);
    }
}
