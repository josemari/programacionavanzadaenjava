package org.jomaveger.examples.chapter7.swing;

import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });
    }
}
