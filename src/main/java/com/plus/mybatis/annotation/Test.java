package com.plus.mybatis.annotation;

@TestAnnotation(id = 2345, sayHello = "345678----0000")
public class Test {

    public static void main(String[] args) {
        boolean annotationPresent = Test.class.isAnnotationPresent(TestAnnotation.class);
        if(annotationPresent){
            TestAnnotation annotation = Test.class.getAnnotation(TestAnnotation.class);

            System.out.println(annotation.id());
            System.out.println(annotation.sayHello());
        }
    }
}
