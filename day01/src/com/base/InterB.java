package com.base;

public interface InterB {
    public void print(String str);
    public default void A(String str){
        System.out.println(str);
    }
}
