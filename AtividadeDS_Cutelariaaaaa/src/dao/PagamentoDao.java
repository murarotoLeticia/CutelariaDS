
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import regrasDeNegocios.Caixa;
import regrasDeNegocios.Pagamento;
import utilitarios.ConexaoBD;

public class PagamentoDao {
    public void inserir (Pagamento p) {
     Connection con = ConexaoBD.getConectarBD();
     String sql= "INSERT INTO pagamento(forma_pag, data_pag , valor_pag,quantidade_pag )"
             +"VALUES(?,?,?,?)";
     try(PreparedStatement stm = con.prepareStatement(sql)){
     
         stm.setString(1, p.getForma_pag());
         stm.setString(2, p.getData_pag());
         stm.setDouble(3, p.getValor_pag());
         stm.setInt(4, p.getQuantidade_pag());
         
         stm.executeUpdate();
         con.close();
         JOptionPane.showMessageDialog(null,"cadastrado com sucesso!");
         
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null,"Erro ao Cadastrar"+ex.getMessage());
     }
     
    }
    public void atualizar(Pagamento p){
        Connection con = ConexaoBD.getConectarBD(); 
        String sql= "UPDATE pagamento SET forma_pag=?, data_pag=? , valor_pag=? ,quantidade_pag=? WHERE id_pag=?"; 
        try(PreparedStatement stm= con.prepareStatement(sql)){
        
            stm.setString(1, p.getForma_pag());
            stm.setString(2, p.getData_pag());
            stm.setDouble(3, p.getValor_pag());
            stm.setInt(4, p.getQuantidade_pag());
          
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
         
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar"+ ex.getMessage()); 
            
        }
    }
    public void deletar(Pagamento p){
        Connection con = ConexaoBD.getConectarBD();
        String sql ="DELETE FROM pagamento WHERE id_pag=?"; //passar o parametro;
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja excluir o produto"+p.getData_pag()+"?", "Exclusão", JOptionPane.YES_NO_OPTION);//janela de confirmação
        if(opcao==JOptionPane.YES_OPTION){//retorna zero
            try(PreparedStatement stm = con.prepareStatement(sql)){
                stm.setInt(1,p.getId_pag());
                stm.executeUpdate();
                stm.close();//fechou o prepared
                con.close();//fechou a conecção
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
                
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao Excluir"+ ex.getMessage());
                
            }
            
        }
        
    }
    public List<Pagamento> listarTodos(){//REORNA UMA LISTA DO OBJETO produto
        Connection con=ConexaoBD.getConectarBD();
        List<Pagamento>lista = new ArrayList<>(); //criado uma lista
        String sql = "SELECT *FROM pagamento"; 
        try(PreparedStatement stm = con.prepareStatement(sql)){ //preparar a sql
            ResultSet resultado= stm.executeQuery();
            while (resultado.next()){
                Pagamento p = new Pagamento();
                p.setId_pag(resultado.getInt("id_pag"));//igual do banco 
                p.setData_pag(resultado.getString("data_pag"));
                p.setForma_pag(resultado.getString("forma_pag"));
                p.setValor_pag(resultado.getDouble("valor_pag"));
                p.setQuantidade_pag(resultado.getInt("quantidade_pag")); 
               
               
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
