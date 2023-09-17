package com.api;

import com.base.Student;

import java.util.SimpleTimeZone;

public class ObjectApi {
    public static final String name = "ObjectApi";
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s = new Student();
        s.setName("name");
        s.setAge(10);
        Student s1 = new Student();
        s1.setName("name");
        s1.setAge(10);
        System.out.println(s.equals(s1));
        System.out.println(s.toString());
        Student s2 = (Student) s.clone();
        System.out.println(s2.toString());
    }
}
