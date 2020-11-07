
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utilitarios.ConexaoBD;
import regrasDeNegocios.Caixa;


public class CaixaDao {
     public void inserir (Caixa c){
     Connection con = ConexaoBD.getConectarBD();
     String sql= "INSERT INTO caixa(data_caixa, saldoIn_caixa , totalRec_caixa,totalPag_caixa, saldoFin_caixa )"
             +"VALUES(?,?,?,?,?)";
     try(PreparedStatement stm = con.prepareStatement(sql)){
     
         stm.setString(1, c.getData_caixa());
         stm.setDouble(2, c.getSaldoIn_caixa());
         stm.setDouble(3, c.getTotalRec_caixa());
         stm.setDouble(4, c.getTotalPag_caixa());
         stm.setDouble(5, c.getSaldoFin_caixa());
         stm.executeUpdate();
         con.close();
         JOptionPane.showMessageDialog(null,"cadastrado com sucesso!");
         
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null,"Erro ao Cadastrar"+ex.getMessage());
     }
     
    }
    public void atualizar(Caixa c){
        Connection con = ConexaoBD.getConectarBD(); 
        String sql= "UPDATE caixa SET data_caixa=?, saldoIn_caixa=?,  totalRec_caixa=?, totalPag_caixa=?,saldoFin_caixa=? WHERE id_caixa=?"; 
        try(PreparedStatement stm= con.prepareStatement(sql)){
        
            stm.setString(1, c.getData_caixa());
            stm.setDouble(2, c.getSaldoIn_caixa());
            stm.setDouble(3, c.getTotalRec_caixa());
            stm.setDouble(4, c.getTotalPag_caixa());
            stm.setDouble(5, c.getSaldoFin_caixa());
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
         
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar"+ ex.getMessage()); 
            
        }
    }
    public void deletar(Caixa c){
        Connection con = ConexaoBD.getConectarBD();
        String sql ="DELETE FROM caixa WHERE id_caixa=?"; //passar o parametro;
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o produto"+c.getData_caixa()+"?", "Exclusão", JOptionPane.YES_NO_OPTION);//janela de confirmação
        if(opcao==JOptionPane.YES_OPTION){//retorna zero
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setInt(1,c.getId_caixa());
                stm.executeUpdate();
                stm.close();//fechou o prepared
                con.close();//fechou a conecção
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
                
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao Excluir"+ ex.getMessage());
                
            }
            
        }
        
    }
    public List<Caixa> listarTodos(){//REORNA UMA LISTA DO OBJETO produto
        Connection con = ConexaoBD.getConectarBD();
        List<Caixa>lista = new ArrayList<>(); //criado uma lista
        String sql = "SELECT *FROM caixa"; 
        try(PreparedStatement stm = con.prepareStatement(sql)){ //preparar a sql
            ResultSet resultado= stm.executeQuery();
            while (resultado.next()){
                Caixa c = new Caixa();
                c.setId_caixa(resultado.getInt("id_caixa"));//igual do banco 
                c.setData_caixa(resultado.getString("data_caixa"));
                c.setSaldoIn_caixa(resultado.getDouble("saldoIn_caixa"));
                c.setTotalRec_caixa(resultado.getDouble("totalRec_caixa"));
                c.setTotalPag_caixa(resultado.getDouble("totalPag_caixa")); 
                c.setSaldoFin_caixa(resultado.getDouble("saldoFin_caixa"));
               
                lista.add(c);
             }
            stm.close();
            stm.close();
       }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao retornar"+ ex.getMessage());
       }
        return lista; 
    }
    
    
}
