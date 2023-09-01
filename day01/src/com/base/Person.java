package com.base;

public class Person extends AbstractPerson {
    public Person() {
    }

    public Person(String name, int age) {
        super(name, age);
    }

    @Override
    public void say(String message) {
        System.out.println("人名叫" + this.getName() + "说了" + message);
    }
}
