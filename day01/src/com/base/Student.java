package com.base;

import java.util.Objects;

//public class Student implements Cloneable{
public class Student implements Cloneable{
    private String name;
    private int age;

    public String teacher = "teacher";

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Student(String name) {
        this.name = name;
    }

    private Student(int age) {
        this.age = age;
    }

    public Student() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public void setAge(int age) {
        this.age = age;
    }

    public void swim(Swim swim) {
        System.out.println(swim.getClass());
        swim.swim();
    }
}
