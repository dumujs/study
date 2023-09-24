package com.pyj;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

@MyAnnatation
public class AnnotationTest {
    @Override
    public String toString() {
        return "AnnatationTest{}";
    }

    @Deprecated()
    public static void test() {
        System.out.println("Deprecated");
    }
    @MyAnnatation
    @SuppressWarnings("all")
    public void list() {

        List list = new ArrayList();
    }

    public static void main(String[] args) {

        test();
    }
}

@Target(value= {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnatation{
    String[] value() default {};
    String name() default "annotation";
}
