package org.jomaveger.examples.chapter1;

public interface C extends A {
    default void doSth(){
        System.out.println("inside C");
    }
}