
package regrasDeNegocios;

import java.sql.Date;


public class Estoque {
    private int id_es; 
    private String nome_es; 
    private int quantidade_es;
    private String tipo_es;
    private String data_es;
    private String entrada_es; 
    private String saida_es;

    public int getId_es() {
        return id_es;
    }

    public void setId_es(int id_es) {
        this.id_es = id_es;
    }

    public String getNome_es() {
        return nome_es;
    }

    public void setNome_es(String nome_es) {
        this.nome_es = nome_es;
    }

    public int getQuantidade_es() {
        return quantidade_es;
    }

    public void setQuantidade_es(int quantidade_es) {
        this.quantidade_es = quantidade_es;
    }

    public String getTipo_es() {
        return tipo_es;
    }

    public void setTipo_es(String tipo_es) {
        this.tipo_es = tipo_es;
    }

    public String getData_es() {
        return data_es;
    }

    public void setData_es(String data_es) {
        this.data_es = data_es;
    }

    public String getEntrada_es() {
        return entrada_es;
    }

    public void setEntrada_es(String entrada_es) {
        this.entrada_es = entrada_es;
    }

    public String getSaida_es() {
        return saida_es;
    }

    public void setSaida_es(String saida_es) {
        this.saida_es = saida_es;
    }

    
}
