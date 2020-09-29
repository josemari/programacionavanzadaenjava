package org.jomaveger.examples.chapter1;

public interface BankAccount {

    Double getBalance();

    void deposit(final Double amount);

    void withdraw(final Double amount);
}
