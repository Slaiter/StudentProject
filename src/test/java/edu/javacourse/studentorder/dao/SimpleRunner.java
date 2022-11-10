package edu.javacourse.studentorder.dao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleRunner
{
    public static void main(String[] args) {
        SimpleRunner simpleRunner = new SimpleRunner();

        simpleRunner.runTests();
    }

    private void runTests() {
        try {
            Class cl = Class.forName("edu.javacourse.studentorder.dao.DictionaryDaoImplTest");

            Constructor constructor = cl.getConstructor();
            Object entity = constructor.newInstance();

            Method[] methods = cl.getMethods();
            for (Method m : methods) {
                Test ann = m.getAnnotation(Test.class);
                if (ann != null) {
                    m.invoke(entity);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
