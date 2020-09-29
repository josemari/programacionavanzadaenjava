package org.jomaveger.examples.chapter6.philosophers;

public class DiningPhilosophers {
    
    private final static int N = 5;
    
    private final static Philosopher[] philosophers = new Philosopher[N];
    
    public static void main(String[] args) {

        for (int i = 0; i < N; i++) {
            philosophers[i] = new Philosopher(i);
        }
        
        Philosopher.philosophers = philosophers;

        for (Thread t : philosophers) {
            t.start();
        }
    }
}
