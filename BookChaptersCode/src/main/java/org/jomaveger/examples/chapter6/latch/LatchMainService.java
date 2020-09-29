package org.jomaveger.examples.chapter6.latch;

import java.util.concurrent.CountDownLatch;

public class LatchMainService extends Thread {
	
    private CountDownLatch latch;

    public LatchMainService(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            System.out.println("Servicio principal esperando que servicios"
            		+ " auxiliares se inicien...");
            latch.await();
            System.out.println("Servicio principal ha iniciado...");
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}