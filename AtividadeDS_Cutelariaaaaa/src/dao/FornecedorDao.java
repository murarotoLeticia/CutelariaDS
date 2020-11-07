
package dao;

import regrasDeNegocios.Fornecedor;
import utilitarios.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class FornecedorDao {
    
    public void cadastrar(Fornecedor f){
        Connection conexao = ConexaoBD.getConectarBD();
        String sql = "INSERT INTO fornecedor(nome_for,cnpj_for,email_for,telefone_for,material_fornecido,rua_for,cidade_for,bairro_for,numero_lugar_for) VALUES (?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement stm = conexao.prepareStatement(sql)){
            stm.setString(1, f.getNome_for());
            stm.setString(2, f.getCnpj_for());
            stm.setString(3, f.getTelefone_for());
            stm.setString(4, f.getEmail_for());
            stm.setString(5, f.getMaterial_fornecido());
            stm.setString(6, f.getRua_for());
            stm.setString(7, f.getCidade_for());
            stm.setString(8, f.getBairro_for());
            stm.setString(9, f.getNumero_lugar_for());
            stm.executeUpdate();
            stm.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, f.getNome_for()+" Cadastrado Com Sucesso!");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha ao Cadastrar: "+erro.getMessage());
        }
    }
    
    public void atualiza(Fornecedor c) {
        Connection con = ConexaoBD.getConectarBD();
        String sql = "UPDATE cliente set nome_for=?,cnpj_for=? ,telefone_for=?,email_for=?,rua_for=?,material_fornecido=?  WHERE id_cliente=?";

        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, c.getNome_for());
            stm.setString(2, c.getCnpj_for());
            stm.setString(3, c.getTelefone_for());
            stm.setString(4, c.getEmail_for());
            stm.setString(5, c.getRua_for());
            stm.setString(6, c.getMaterial_fornecido());
            stm.setInt(7, c.getId_fornecedor());
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "registro Atualizar com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "erro ao atualizar o registro" + ex.getMessage());
        }
        
    
    }

    
    public void editar(Fornecedor f){
        Connection conexao = ConexaoBD.getConectarBD();
        String sql = "UPDATE fornecedor SET nome_for=?,cnpj_for=?,email_for=?,telefone_for=?,material_fornecido=?,rua_for=?,cidade_for=?,bairro_for=?,numero_lugar_for=? Where (id_fornecedor=?)";
        try(PreparedStatement stm = conexao.prepareStatement(sql) ){       
            stm.setString(1, f.getNome_for());
            stm.setString(2, f.getCnpj_for());
            stm.setString(3, f.getTelefone_for());
            stm.setString(4, f.getEmail_for());
            stm.setString(5, f.getMaterial_fornecido());
            stm.setString(6, f.getRua_for());
            stm.setString(7, f.getCidade_for());
            stm.setString(8, f.getBairro_for());
            stm.setString(9, f.getNumero_lugar_for());
            stm.setInt(10, f.getId_fornecedor());
            stm.executeUpdate();
            stm.close();
            conexao.close();
            JOptionPane.showMessageDialog(null,"Fornecedor Atualizado com Sucesso");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha na atualização: "+erro.getMessage());
        }
    }
    

    
    
    
    public void excluir(Fornecedor f ){
        Connection conexao = ConexaoBD.getConectarBD();
        String sql = "DELETE FROM fornecedor WHERE id_fornecedor=?";
       
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Fornecedor secionado?","Excluir Fornecedor",JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION){
        try(PreparedStatement stm = conexao.prepareStatement(sql)){
            stm.setInt(1, f.getId_fornecedor());
            stm.executeLargeUpdate();
            stm.close();
            conexao.close();
            JOptionPane.showMessageDialog(null,"Fornecedor Excluido com Sucesso");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha ao Excluir Fornecedor: "+erro.getMessage());

        }
      }
    }
    
    public List<Fornecedor> listarTodos(){
        Connection conexao = ConexaoBD.getConectarBD();
        List<Fornecedor> lista = new ArrayList<>();
        String slq = "SELECT * FROM fornecedor";
        try(PreparedStatement stm = conexao.prepareStatement(slq) ){
            ResultSet resultado = stm.executeQuery();
            while(resultado.next()){
                Fornecedor f = new Fornecedor();
                f.setId_fornecedor(resultado.getInt("id_fornecedor"));
                f.setNome_for(resultado.getString("nome_for"));
                f.setCnpj_for(resultado.getString("cnpj"));
                f.setTelefone_for(resultado.getString("telefone_for"));
                f.setEmail_for(resultado.getString("email_for"));
                f.setMaterial_fornecido(resultado.getString("material_fornecido"));
                f.setRua_for(resultado.getString("rua_for"));
                f.setCidade_for(resultado.getString("cidade_for"));
                f.setBairro_for(resultado.getString("bairro_for"));
                f.setNumero_lugar_for(resultado.getString("numero_lugar_for"));
                
                lista.add(f);
            }
                stm.close();
                conexao.close();
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha na Listagem: "+erro.getMessage());
        }
   
        return lista;
        
    }
    
}
