package br.com.SistemaVendas.model;

import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JTextField;

public class Utilitarios {

    public void LimpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }

}
