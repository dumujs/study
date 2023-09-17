package com.pyj;

import com.base.Student;
import com.base.Swim;

public class SwimTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.swim(new Swim() {
            @Override
            public void swim() {
                System.out.println("swim");
            }
        });
        student.swim(new Swim() {
            @Override
            public void swim() {
                System.out.println("swim");
            }
        });
        student.swim(new Swim() {
            @Override
            public void swim() {
                System.out.println("swim");
            }
        });
    }
}
