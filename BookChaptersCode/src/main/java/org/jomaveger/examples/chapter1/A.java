package org.jomaveger.examples.chapter1;

public interface A {
    default void doSth(){
        System.out.println("inside A");
    }
}
