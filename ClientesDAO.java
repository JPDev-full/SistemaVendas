package br.com.SistemaVendas.dao;

import br.com.SistemaVendas.jdbc.ConnectionFactory;
import br.com.SistemaVendas.model.Clientes;
import br.com.SistemaVendas.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class ClientesDAO {

    private Connection con;
    private Object obj;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarCliente(Clientes obj) {

        try {

            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);
        }
    }

    public void alterarCliente(Clientes obj) {
        
        try {

            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,"
                    +"endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14,obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);
        }

    }

    public void excluirCliente(Clientes obj) {
        
        try {

            String sql = "delete from tb_clientes where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
           
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluído com Sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);
        }

    }

    public List<Clientes> listarClientes() {
        
        try {

            List<Clientes> lista = new ArrayList<>();

            String sql = "select*from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = (ResultSet)stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }
    }
    
    public Clientes consultaPorNome(String nome){
        try {
            
            String sql = "select*from tb_clientes where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = (ResultSet)stmt.executeQuery();
            Clientes obj = new Clientes();
            
            if (rs.next()) {
                

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            
            return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cliente não encontrado");
            return null;
        }
    }

    
   public List<Clientes> buscaClientePorNome(String nome) {
        
        try {

            List<Clientes> lista = new ArrayList<>();

            String sql = "select*from tb_clientes where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = (ResultSet)stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null; 
        }
   } 
   
   public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            
            return obj;
            
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
}

