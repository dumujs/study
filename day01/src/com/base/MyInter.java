package com.base;

public class MyInter implements InterA, InterB{
    @Override
    public void print(String str) {
        System.out.println(this.getClass().getName() + str);
    }

    @Override
    public void A(String str) {
        InterA.super.A(str);
    }

    public MyInter() {
    }
}
