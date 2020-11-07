
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import regrasDeNegocios.Produto;
import regrasDeNegocios.Estoque;
import utilitarios.ConexaoBD;


public class EstoqueDao {
        public void inserir (Estoque e){
     Connection con = ConexaoBD.getConectarBD();
     String sql= "INSERT INTO estoque(nome_es, quantidade_es,  tipo_es, data_es, entrada_es, saida_es )"
             +"VALUES(?,?,?,?,?,?)";
     try(PreparedStatement stm = con.prepareStatement(sql)){
     
         stm.setString(1, e.getNome_es());
         stm.setInt(2, e.getQuantidade_es());
         stm.setString(3, e.getTipo_es());
         stm.setString(4, e.getData_es());
         stm.setString(5, e.getEntrada_es());
         stm.setString(6, e.getSaida_es());
         stm.executeUpdate();
         con.close();
         JOptionPane.showMessageDialog(null,"cadastrado com sucesso!");
         
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null,"Erro ao Cadastrar"+ex.getMessage());
     }
     
    }
        public void atualizar(Estoque e){
        Connection con = ConexaoBD.getConectarBD(); 
        String sql= "UPDATE estoque SET nome_es=?, quantidade_es=?,  tipo_es=?,data_es=?,entrada_es=?, saida_es=? WHERE id_es=?"; 
        try(PreparedStatement stm= con.prepareStatement(sql)){
        
            stm.setString(1, e.getNome_es());
            stm.setInt(2, e.getQuantidade_es());
            stm.setString(3, e.getTipo_es());
            stm.setString(4, e.getData_es());
            stm.setString(5, e.getEntrada_es());
            stm.setString(6, e.getSaida_es());
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
         
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar"+ ex.getMessage()); 
            
        }
    }
    public void deletar(Estoque e){
        Connection con = ConexaoBD.getConectarBD();
        String sql ="DELETE FROM estoque WHERE id_es=?"; //passar o parametro;
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o produto"+e.getNome_es()+"?", "Exclusão", JOptionPane.YES_NO_OPTION);//janela de confirmação
        if(opcao==JOptionPane.YES_OPTION){//retorna zero
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setInt(1,e.getId_es());
                stm.executeUpdate();
                stm.close();//fechou o prepared
                con.close();//fechou a conecção
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
                
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao Excluir"+ ex.getMessage());
                
            }
            
        }
        
    }
    public List<Estoque> listarTodos(){//REORNA UMA LISTA DO OBJETO produto
        Connection con=ConexaoBD.getConectarBD();
        List<Estoque>lista = new ArrayList<>(); //criado uma lista
        String sql = "SELECT *FROM estoque"; 
        try(PreparedStatement stm = con.prepareStatement(sql)){ //preparar a sql
            ResultSet resultado= stm.executeQuery();
            while (resultado.next()){
                Estoque e = new Estoque();
                e.setId_es(resultado.getInt("id_es"));//igual do banco 
                e.setNome_es(resultado.getString("nome_es"));
                e.setQuantidade_es(resultado.getInt("quantidade_es"));
                e.setTipo_es(resultado.getString("tipo_es"));
                e.setData_es(resultado.getString("data_es")); 
                e.setEntrada_es(resultado.getString("entrada_es"));
                e.setSaida_es(resultado.getString("saida_es"));
               
                lista.add(e);
             }
            stm.close();
            stm.close();
       }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao retornar"+ ex.getMessage());
       }
        return lista; 
    }
    
    
}

    
    

