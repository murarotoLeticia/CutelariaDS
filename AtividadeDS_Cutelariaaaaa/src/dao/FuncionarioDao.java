
package dao;

import regrasDeNegocios.Funcionario;
import utilitarios.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class FuncionarioDao {
    
    public void cadastrar(Funcionario f){
        Connection conexao = ConexaoBD.getConectarBD();
        String sql = "INSERT INTO funcionario(nome_fun,sexo_fun,rg_fun,cpf_fun,email_fun,telefone_fun,funcao_fun,rua_fun,cidade_fun,bairro_fun,numero_casa_fun,senha_fun) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement stm = conexao.prepareStatement(sql)){
            stm.setString(1, f.getNome_fun());
            stm.setString(2, f.getSexo_fun());
            stm.setString(3, f.getRg_fun());
            stm.setString(4, f.getCpf_fun());
            stm.setString(5, f.getEmail_fun());
            stm.setString(6, f.getTelefone_fun());
            stm.setString(7, f.getFuncao_fun());
            stm.setString(8, f.getRua_fun());
            stm.setString(9, f.getCidade_fun());
            stm.setString(10, f.getBairro_fun());
            stm.setInt(11, f.getNumero_casa_fun());
            stm.setString(12, f.getSenha_fun());
            stm.executeUpdate();
            stm.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, f.getNome_fun()+" Cadastrado Com Sucesso!");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha ao Cadastrar: "+erro.getMessage());
        }
    }
    
    public void editar(Funcionario f){
        Connection conexao = ConexaoBD.getConectarBD();
        String sql = "UPDATE funcionario SET nome_fun=?,sexo_fun=?,rg_fun=?,cpf_fun=?,email_fun=?,telefone_fun=?,funcao_fun=?,rua_fun=?,cidade_fun=?,bairro_fun=?,numero_casa_fun=?,senha_fun=? Where (id_funcionario=?)";
        try(PreparedStatement stm = conexao.prepareStatement(sql) ){
            stm.setString(1, f.getNome_fun());
            stm.setString(2, f.getSexo_fun());
            stm.setString(3, f.getRg_fun());
            stm.setString(4, f.getCpf_fun());
            stm.setString(5, f.getEmail_fun());
            stm.setString(6, f.getTelefone_fun());
            stm.setString(7, f.getFuncao_fun());
            stm.setString(8, f.getRua_fun());
            stm.setString(9, f.getCidade_fun());
            stm.setString(10, f.getBairro_fun());
            stm.setInt(11, f.getNumero_casa_fun());
            stm.setString(12, f.getSenha_fun());
            stm.executeUpdate();
            stm.close();
            conexao.close();
            JOptionPane.showMessageDialog(null,"Funcionário Atualizado com Sucesso");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha na atualização: "+erro.getMessage());
        }
    }
    
    public void excluir(Funcionario f ){
        Connection conexao = ConexaoBD.getConectarBD();
        String sql = "DELETE FROM funcionario WHERE cod_funcionario=?";
       
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Funcionario secionado?","Excluir Funcionario",JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION){
        try(PreparedStatement stm = conexao.prepareStatement(sql)){
            stm.setInt(1, f.getId_funcionario());
            stm.executeLargeUpdate();
            stm.close();
            conexao.close();
            JOptionPane.showMessageDialog(null,"Funcionario Excluido com Sucesso");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha ao Excluir Funcionario: "+erro.getMessage());

        }
      }
    }
    
    public List<Funcionario> listarTodos(){
        Connection conexao = ConexaoBD.getConectarBD();
        List<Funcionario> lista = new ArrayList<>();
        String slq = "SELECT * FROM funcionario";
        try(PreparedStatement stm = conexao.prepareStatement(slq) ){
            ResultSet resultado = stm.executeQuery();
            while(resultado.next()){
                Funcionario f = new Funcionario();
                f.setId_funcionario(resultado.getInt("id_funcionario"));
                f.setNome_fun(resultado.getString("nome_fun"));
                f.setSexo_fun(resultado.getString("sexo_fun"));
                f.setRg_fun(resultado.getString("rg_fun"));
                f.setCpf_fun(resultado.getString("cpf_fun"));
                f.setEmail_fun(resultado.getString("email_fun"));
                f.setTelefone_fun(resultado.getString("telefone_fun"));
                f.setFuncao_fun(resultado.getString("funcao_fun"));
                f.setRua_fun(resultado.getString("rua_fun"));
                f.setCidade_fun(resultado.getString("cidade_fun"));
                f.setBairro_fun(resultado.getString("bairro_fun"));
                f.setNumero_casa_fun(resultado.getInt("numero_casa_fun"));
                f.setSenha_fun(resultado.getString("senha_fun"));
                lista.add(f);
            }
                stm.close();
                conexao.close();
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha na Listagem: "+erro.getMessage());
        }
   
        return lista;
        
    }
    
    public Funcionario login (String cpf, String senha){
     Connection conexao = ConexaoBD.getConectarBD();
     Funcionario f = new Funcionario();
     String sql = "SELECT * FROM funcionario WHERE cpf_fun = ? and senha_fun = md5(?)";
        try(PreparedStatement smt = conexao.prepareStatement(sql)){
          smt.setString(1, f.getCpf_fun());
          smt.setString(2, f.getSenha_fun());
          ResultSet resultado = smt.executeQuery();
          resultado.next();
            if (resultado.getInt("id_funcionario") > 0 ) {
                
                f.setId_funcionario(resultado.getInt("id_funcionario"));
                f.setNome_fun(resultado.getString("nome_fun"));
                f.setSexo_fun(resultado.getString("sexo_fun"));
                f.setRg_fun(resultado.getString("rg_fun"));
                f.setCpf_fun(resultado.getString("cpf_fun"));
                f.setEmail_fun(resultado.getString("email_fun"));
                f.setTelefone_fun(resultado.getString("telefone_fun"));
                f.setFuncao_fun(resultado.getString("funcao_fun"));
                f.setRua_fun(resultado.getString("rua_fun"));
                f.setCidade_fun(resultado.getString("cidade_fun"));
                f.setBairro_fun(resultado.getString("bairro_fun"));
                f.setNumero_casa_fun(resultado.getInt("numero_casa_fun"));
                f.setSenha_fun(resultado.getString("senha_fun"));
            }else{
            JOptionPane.showMessageDialog(null, "USUÁRIO OU SENHA INCORRETO! ");

            }
        } catch (Exception ex) {
           // JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR AO USUÁRIO"+ ex.getMessage());
        }
        return f;
        }
        
            
    
    
    
    }

