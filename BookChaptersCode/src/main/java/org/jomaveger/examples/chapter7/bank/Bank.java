package org.jomaveger.examples.chapter7.bank;

public interface Bank {

	void transferencia(int de, int para, double cantidad);
	
	double getSaldoTotal();
	
	int size();
}
