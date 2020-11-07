

package regrasDeNegocios;

import java.sql.Date;


public class Pagamento {
    private int id_pag; 
    private String forma_pag; 
    private String data_pag;
    private Double valor_pag;
    private int quantidade_pag; 

    public int getId_pag() {
        return id_pag;
    }

    public void setId_pag(int id_pag) {
        this.id_pag = id_pag;
    }

    public String getForma_pag() {
        return forma_pag;
    }

    public void setForma_pag(String forma_pag) {
        this.forma_pag = forma_pag;
    }

    public String getData_pag() {
        return data_pag;
    }

    public void setData_pag(String data_pag) {
        this.data_pag = data_pag;
    }

    public Double getValor_pag() {
        return valor_pag;
    }

    public void setValor_pag(Double valor_pag) {
        this.valor_pag = valor_pag;
    }

    public int getQuantidade_pag() {
        return quantidade_pag;
    }

    public void setQuantidade_pag(int quantidade_pag) {
        this.quantidade_pag = quantidade_pag;
    }

   
    
}
