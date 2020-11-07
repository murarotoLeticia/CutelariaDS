/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import regrasDeNegocios.Cliente;
import utilitarios.ConexaoBD;


/**
 *
 * @author karolaine
 */
public class ClienteDao {
    
   

    public void inserir(Cliente c ) {
        Connection con = ConexaoBD.getConectarBD();
        String sql = "INSERT INTO cliente (nome_cli,dataNasc_cli ,sexo_cli,rg_cli,cpf_cli,email_cli,telefone_cli,rua_cli,cidade_cli,bairro_cli,numero_casa_cli,senha_cli)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";


           
        try (PreparedStatement stm = con.prepareStatement(sql)) {
               stm.setString(1, c.getNome_cli());
               stm.setString(2, c.getDataNasc_cli());
               stm.setString(3, c.getSexo_cli());
               stm.setString(4, c.getRg_cli());
               stm.setString(5, c.getCpf_cli());
               stm.setString(6, c.getEmail_cli());
               stm.setString(7, c.getTelefone_cli());
               stm.setString(8, c.getRua_cli());
               stm.setString(9, c.getCidade_cli());
               stm.setString(10, c.getBairro_cli());
               stm.setString(11, c.getNumero_casa_cli());
               stm.setString(12, c.getSenha_cli());
             
               stm.executeUpdate();
               stm.close();
               con.close();
            JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR" + ex.getMessage());
            
            
            
            
        }
    }

      public void atualiza(Cliente c) {
        Connection con = ConexaoBD.getConectarBD();
        String sql = "UPDATE cliente set nome_cli=?,dataNasc_cli=? ,sexo_cli=?,rg_cli=?,cpf_cli=?,email_cli=?,telefone_cli=?,rua_cli=?,cidade_cli=?,bairro_cli=?,numero_casa_cli=?,senha_cli=?  WHERE id_cliente=?";

        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, c.getNome_cli());
            stm.setString(2, c.getDataNasc_cli());
            stm.setString(3, c.getSexo_cli());
            stm.setString(4, c.getRg_cli());
            stm.setString(5, c.getCpf_cli());
            stm.setString(6, c.getEmail_cli());
            stm.setString(7, c.getTelefone_cli());
            stm.setString(8, c.getRua_cli());
            stm.setString(9, c.getCidade_cli());
            stm.setString(10, c.getBairro_cli());
            stm.setString(11, c.getNumero_casa_cli());
            stm.setString(12, c.getSenha_cli());
            stm.setInt(13, c.getId_Cliente());
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "registro Atualizar com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar o registro" + ex.getMessage());
        }
        
    
    }

    public void deleter(Cliente c) {
        Connection con = ConexaoBD.getConectarBD();
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "deseja excluir o Cliente?" + c.getNome_cli(), "exclusão", JOptionPane.YES_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setInt(1, c.getId_Cliente());
                stm.executeUpdate();
                stm.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Exclussão realizada com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro " + ex.getMessage());
            }
        }
    }

    public List<Cliente> listarTodos() {
        Connection con = ConexaoBD.getConectarBD();
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            ResultSet resultado = stm.executeQuery();
            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setId_Cliente((resultado.getInt("id_Cliente")));
                c.setNome_cli(resultado.getString("nome_cli"));
                c.setDataNasc_cli(resultado.getString("dataNasc_cli"));
                c.setSexo_cli(resultado.getString("sexo_cli"));
                c.setRg_cli(resultado.getString("rg_cli"));
                c.setCpf_cli(resultado.getString("cpf_cli"));
                c.setEmail_cli(resultado.getString("email_cli"));
                c.setTelefone_cli(resultado.getString("telefone_cli"));
                c.setRua_cli(resultado.getString("rua_cli"));
                c.setCidade_cli(resultado.getString("cidade_cli"));
                c.setBairro_cli(resultado.getString("bairro_cli"));
                c.setNumero_casa_cli(resultado.getString("nume_cli"));
                c.setSenha_cli(resultado.getString("senha_cli"));
                
                
                
        
                lista.add(c);
                JOptionPane.showMessageDialog(null,"listado com sucesso" );
     
            }
                 stm.close();
                 con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO LISTAR " + ex.getMessage());
        }
        return lista;
    }

}

