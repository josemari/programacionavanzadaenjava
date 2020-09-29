package org.jomaveger.examples.chapter1;

public interface B {
    default void doSth(){
        System.out.println("inside B");
    }
}
