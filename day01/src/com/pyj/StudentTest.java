package com.pyj;

public class StudentTest {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("pengyongjiang");
        st.setAge(25);
        st.say();
        Student student = new Student();
        student.setAge(800);
        student.setName("伊姆");
        student.say();
        System.out.println(student.getName());
        System.out.println(student.getAge());

    }
}
