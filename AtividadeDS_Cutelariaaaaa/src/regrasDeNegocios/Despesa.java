
package regrasDeNegocios;

import java.sql.Date;


public class Despesa {
    private int id_desp; 
    private String nome_desp; 
    private Double valor_desp;
    private String data_desp;
    private String formapag_desp; 

    public int getId_desp() {
        return id_desp;
    }

    public void setId_desp(int id_desp) {
        this.id_desp = id_desp;
    }

    public String getNome_desp() {
        return nome_desp;
    }

    public void setNome_desp(String nome_desp) {
        this.nome_desp = nome_desp;
    }

    public Double getValor_desp() {
        return valor_desp;
    }

    public void setValor_desp(Double valor_desp) {
        this.valor_desp = valor_desp;
    }

    public String getData_desp() {
        return data_desp;
    }

    public void setData_desp(String data_desp) {
        this.data_desp = data_desp;
    }

    public String getFormapag_desp() {
        return formapag_desp;
    }

    public void setFormapag_desp(String formapag_desp) {
        this.formapag_desp = formapag_desp;
    }

    

    
}
