package br.com.SistemaVendas.jdbc;

import javax.swing.JOptionPane;

public class TestaConexao {
    
    public static void main(String[] args) {
        
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null,"Conectado com sucesso");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Falha na conexão " + erro);
        }
        
    }
 
}
