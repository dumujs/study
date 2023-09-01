package com.pyj;

public class Student {
    private String name;
    private int age;
    void say() {
        System.out.println(name + "今年" + age + "岁");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        if (age >=0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println(age + "数据非法");
        }
    }
}
