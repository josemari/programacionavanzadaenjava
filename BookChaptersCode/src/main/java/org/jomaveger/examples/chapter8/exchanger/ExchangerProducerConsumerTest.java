package org.jomaveger.examples.chapter8.exchanger;

import java.util.concurrent.Exchanger;
import java.util.ArrayList;

public class ExchangerProducerConsumerTest {
	
    public static void main(String[] args) {
    
    	Exchanger<ArrayList<Integer>> exchanger = new Exchanger<>();

        // El productor generara 5 numeros enteros cada vez  
        ExchangerProducer producer = new ExchangerProducer(exchanger, 5);
        ExchangerConsumer consumer = new ExchangerConsumer(exchanger);

        producer.start();
        consumer.start();
    }
}
