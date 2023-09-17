package com;

import com.base.Student;
import com.base.Swim;

import java.lang.reflect.*;

public class ReflexTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取字节码对象
        Class c = Class.forName("com.base.Student");
        Class c1 = Student.class;
        Class c2 = new Student().getClass();
        System.out.println(c == c1);
        System.out.println(c == c2);
        /**
         * 1. Construct
         */
        Constructor<Student>[] constructors = c.getConstructors();
        for (Constructor<Student> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<Student>[] cons = c.getDeclaredConstructors();
        for (Constructor<Student> con : cons) {
            System.out.println(con);
        }
        Constructor con = c.getConstructor();
        System.out.println(con);
        Constructor con2 = c.getConstructor(String.class, int.class);
        System.out.println(con2);
        System.out.println(con2.newInstance("Student", 12));
        Constructor con3 = c.getDeclaredConstructor(int.class);
        System.out.println(con3);
        // 临时放开权限
        con3.setAccessible(true);
        System.out.println(con3.newInstance(12));

        /**
         * 2. Field
         */
        Student s = new Student("pyj", 30);
        System.out.println(s);
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        System.out.println(f.get(s));
        f.set(s, "new PYJ");
        System.out.println(s);

        /**
         * 3. Method
         */
        {
            Student s1 = new Student("pyj", 30);
            Method[] mArr = c.getDeclaredMethods();
            for (Method method : mArr) {
                System.out.println(method);
            }
            Method[] mArr2 = c.getMethods();
            for (Method method : mArr2) {
                System.out.println(method);
            }

            Method swim = c.getMethod("swim", Swim.class);
            Class<?>[] parameterTypes = swim.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }

            Parameter[] parameters = swim.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter);
            }
        }
        /**
         * 4. 反射应用
         */

    }
}
