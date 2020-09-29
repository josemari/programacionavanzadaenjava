package org.jomaveger.examples.chapter6.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBank1 implements Bank {

	private final double[] cuentas;
	private Lock cerrojo;
	
	public SynchronizedBank1(int n, double saldoInicial) {
		cerrojo = new ReentrantLock();
		cuentas = new double[n];
		for(int i = 0; i < cuentas.length; i++)
			cuentas[i] = saldoInicial;
	}
	
	@Override
	public void transferencia(int de, int para, double cantidad) {
		cerrojo.lock();
		
		try {
			if (cuentas[de] < cantidad) return;
			
			System.out.print(Thread.currentThread());
			
			cuentas[de] = cuentas[de] - cantidad;
			
			System.out.printf(" %10.2f de %d para %d", cantidad, de, para);
			
			cuentas[para] = cuentas[para] + cantidad;
			
			System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
		} finally {
			cerrojo.unlock();
		}
	}

	@Override
	public double getSaldoTotal() {
		cerrojo.lock();
		try {
			double sum = 0;
			
			for (double a: cuentas)
				sum += a;
			
			return sum;
		} finally {
			cerrojo.unlock();
		}
	}

	@Override
	public int size() {
		return cuentas.length;
	}
}
