package org.jomaveger.examples.chapter8.swing;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class GeneraPrimos extends SwingWorker<ArrayList<Integer>, Integer> {
    
    private DefaultListModel modeloLista;
    private JProgressBar barraProgreso;
    private JButton botonInicio, botonParada;

    public GeneraPrimos(DefaultListModel modeloLista, JProgressBar barraProgreso, JButton botonInicio, JButton botonParada) {
        this.modeloLista = modeloLista;
        this.barraProgreso = barraProgreso;
        this.botonInicio = botonInicio;
        this.botonParada = botonParada;
    }
    
    protected ArrayList<Integer> doInBackground() {
        Integer valorTemp = new Integer(1);
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100 && !isCancelled(); j++) {
                valorTemp = encuentraSiguientePrimo(valorTemp.intValue());
            }
            publish(new Integer(i));
            lista.add(valorTemp);
        }
        return lista;
    }

    @Override
    protected void process(java.util.List<Integer> lista) {
        if (!isCancelled()) {
            Integer parteCompletada = lista.get(lista.size() - 1);
            barraProgreso.setValue(parteCompletada.intValue());
        }
    }
    
    @Override
    protected void done() {
        if (!isCancelled()) {
            try {
                ArrayList<Integer> results = get();
                for (Integer i : results) {
                    modeloLista.addElement(i.toString());
                }
                this.botonInicio.setEnabled(true);
                this.botonParada.setEnabled(false);
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private Integer encuentraSiguientePrimo(int num) {
        do {
            if (num % 2 == 0) {
                num++;
            } else {
                num = num + 2;
            }
        } while (!esPrimo(num));
        return new Integer(num);
    }

    private boolean esPrimo(int num) {
        int i;
        for (i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
