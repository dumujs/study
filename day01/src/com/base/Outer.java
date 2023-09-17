package com.base;

public class Outer {
    private String name;
    public void show() {
        System.out.println("outer" + this.name);
        Inner inner = new Inner();
        inner.show();
    }
    class Inner {
        String innerName;
        public void show() {
            System.out.println("inner" + name);
        }
    }
}
