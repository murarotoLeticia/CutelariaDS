
package utilitarios;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class ConexaoBD {

    private static final String usuario = "root";
    private static final String senha = "diovanaces";
    private static final String url = "jdbc:mysql://localhost/Cutelaria_Artesanal_atualizado";
    
    public static Connection getConectarBD(){
        Connection conexctar = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexctar = DriverManager.getConnection(url, usuario, senha);
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha Na conexao: "+erro.getMessage());
        }
        
        return conexctar;
    }
    

    
}
