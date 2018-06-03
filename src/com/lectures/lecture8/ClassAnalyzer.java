package com.lectures.lecture8;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassAnalyzer {
    public static void analyzeClass(Class clazz) {
        System.out.println("Class :\t"+clazz.getSimpleName());
        analyzeConstructor(clazz);
        analyzeFields(clazz);
        analyzeMethods(clazz);
        analyzeClassAnnotations(clazz);
        analyzeTransaction(clazz, "","");
    }


    private static void analyzeTransaction(Class clazz, String ... methodNames) {
        for (Method method : clazz.getMethods()) {
            if (methodNames != null) {
                for (Annotation annotation : method.getAnnotations())
                    if (annotation instanceof Transaction) {
                        System.out.println("Transaction is started");
                        try {
                            method.invoke(new Object());
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Transaction is ended");
                    }
            }
        }
    }

    private static void analyzeMethods(Class clazz) {
        StringBuilder text = new StringBuilder(500);
        for (Method method : clazz.getDeclaredMethods()) {
            if (notObjectMethod(method)) {
                text.append("Method: ").append(method.getName()).append("\n")
                        .append("\t").append("Return type: ").append(method.getReturnType().getSimpleName()).append("\n")
                        .append("\t").append("Parameters name: ").append(Arrays.stream(method.getParameters()).map(Parameter::getName).collect(Collectors.joining(", "))).append("\n");
            }
        }
        System.out.println(text);
    }
    private static void analyzeConstructor(Class clazz) {
        StringBuilder text = new StringBuilder(200);
        for (Constructor constructor : clazz.getConstructors()) {
            text.append("Constructor: ").append(constructor.getName()).append("\n")
                    .append("\t").append("Count of parameters: ").append(constructor.getParameterCount()).append("\n")
                    .append("\t").append("Parameters : ").append(Arrays.stream(constructor.getParameters()).map(Parameter::getName).collect(Collectors.joining(", "))).append("\n");
        }
        System.out.println(text);
    }
    private static void analyzeFields(Class clazz) {
        StringBuilder text = new StringBuilder(500);
        for (Field field : clazz.getDeclaredFields()) {
                text.append("Field: ").append(field.getName()).append("\n")
                        .append("\t").append("Return type: ").append(field.getType().getSimpleName()).append("\n");
        }
        System.out.println(text);
    }

    private static boolean notObjectMethod(Method method) {
        return !("equals".equals(method.getName()) || "toString".equals(method.getName()) ||
                "wait".equals(method.getName()) || "notify".equals(method.getName()) ||
                "notifyAll".equals(method.getName()) || "hashCode".equals(method.getName())) ;
    }

    private static void analyzeClassAnnotations(Class clazz, String... methodNames) {
        System.out.println("Annotation for class: \t"+clazz.getSimpleName());
        for (Method method : clazz.getMethods()) {
            if (methodNames != null)
            for (Annotation annotation : clazz.getDeclaredAnnotations()) {
                System.out.println("Analyze annotation :");
                printAnnotation(annotation);
            }
        }
    }

    private static void printAnnotation(Annotation annotation) {
        analyzeClass(annotation.getClass());
    }
}
