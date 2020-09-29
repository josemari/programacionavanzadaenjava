package org.jomaveger.examples.chapter6;

public final class Counter2 {

    private long value = 0;

    public long getValue() {
        synchronized(this) {
            return value;   
        }
    }

    public long increment() {
        synchronized(this) {
            return ++value;    
        }
    }
}
