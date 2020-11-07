/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import regrasDeNegocios.Produto;
import utilitarios.ConexaoBD;

/**
 *
 
 */
public class ProdutoDao {
    public void inserir (Produto p){
     Connection con = ConexaoBD.getConectarBD();
     String sql= "INSERT INTO produto(nome_pro,quantidade_pro, modelo_pro,tipo_pro, valor_pro )VALUES(?,?,?,?,?)";
     try(PreparedStatement stm = con.prepareStatement(sql)){
     
         stm.setString(1, p.getNome_pro());
         stm.setString(2, p.getQuantidade_pro());
         stm.setString(3, p.getModelo_pro());
         stm.setString(4, p.getTipo_pro());
         stm.setFloat(5, p.getValor_pro());
         stm.executeUpdate();
         con.close();
         JOptionPane.showMessageDialog(null,"cadastrado com sucesso!");
         
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null,"Erro ao Cadastrar"+ex.getMessage());
     }
     
    }
    public void atualizar(Produto p){
        Connection con = ConexaoBD.getConectarBD(); 
        String sql= "UPDATE Produto SET nome_pro=?,quantidade_pro =?,  modelo_pro=?, tipo_pro=?, valor_pro=? WHERE id_produto=?"; 
        try(PreparedStatement stm= con.prepareStatement(sql)){
        
            stm.setString(1, p.getNome_pro());
            stm.setString(2, p.getQuantidade_pro());
            stm.setString(3, p.getModelo_pro());
            stm.setString(4, p.getTipo_pro());
            stm.setFloat(5, p.getValor_pro());
            stm.setInt(6, p.getId_produto());
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
         
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar"+ ex.getMessage()); 
            
        }
    }
    public void deletar(Produto p){
        Connection con = ConexaoBD.getConectarBD();
        String sql ="DELETE FROM Produto WHERE id_produto=?"; //passar o parametro;
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o produto"+p.getNome_pro()+"?", "Exclusão", JOptionPane.YES_NO_OPTION);//janela de confirmação
        if(opcao==JOptionPane.YES_OPTION){//retorna zero
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setInt(1,p.getId_produto());
                stm.executeUpdate();
                stm.close();//fechou o prepared
                con.close();//fechou a conecção
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
                
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao Excluir"+ ex.getMessage());
                
            }
            
        }
        
    }
    public List<Produto> listarTodos(){//REORNA UMA LISTA DO OBJETO produto
        Connection con=ConexaoBD.getConectarBD();
        List<Produto>lista = new ArrayList<>(); //criado uma lista
        String sql = "SELECT *FROM Produto"; 
        try(PreparedStatement stm = con.prepareStatement(sql)){ //preparar a sql
            ResultSet resultado= stm.executeQuery();
            while (resultado.next()){
                Produto p = new Produto();
                p.setId_produto(resultado.getInt("id_produto"));//igual do banco 
                p.setNome_pro(resultado.getString("nome_pro"));
                p.setQuantidade_pro(resultado.getString("quantidade_pro"));
                p.setModelo_pro(resultado.getString("modelo_pro"));
                p.setTipo_pro(resultado.getString("tipo_pro")); 
                p.setValor_pro(resultado.getFloat("valor_pro"));
               
                lista.add(p);
             }
            stm.close();
            stm.close();
       }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao retornar"+ ex.getMessage());
       }
        return lista; 
    }
    
    
}
