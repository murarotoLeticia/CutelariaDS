/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocios;

/**
 *

 */
public class Produto {
    private int id_produto; 
    private String nome_pro; 
    private String quantidade_pro;
    private String modelo_pro; 
    private String tipo_pro;
    private float valor_pro;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_pro() {
        return nome_pro;
    }

    public void setNome_pro(String nome_pro) {
        this.nome_pro = nome_pro;
    }

    public String getQuantidade_pro() {
        return quantidade_pro;
    }

    public void setQuantidade_pro(String quantidade_pro) {
        this.quantidade_pro = quantidade_pro;
    }

    public String getModelo_pro() {
        return modelo_pro;
    }

    public void setModelo_pro(String modelo_pro) {
        this.modelo_pro = modelo_pro;
    }

    public String getTipo_pro() {
        return tipo_pro;
    }

    public void setTipo_pro(String tipo_pro) {
        this.tipo_pro = tipo_pro;
    }

    public float getValor_pro() {
        return valor_pro;
    }

    public void setValor_pro(float valor_pro) {
        this.valor_pro = valor_pro;
    }

 
    
    
}
