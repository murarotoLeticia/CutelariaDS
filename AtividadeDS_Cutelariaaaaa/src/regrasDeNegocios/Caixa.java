/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocios;


public class Caixa {
    private int id_caixa; 
    private String data_caixa; 
    private Double saldoIn_caixa;
    private Double totalRec_caixa;
    private Double totalPag_caixa; 
    private Double saldoFin_caixa;

    public int getId_caixa() {
        return id_caixa;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    public String getData_caixa() {
        return data_caixa;
    }

    public void setData_caixa(String data_caixa) {
        this.data_caixa = data_caixa;
    }

    public Double getSaldoIn_caixa() {
        return saldoIn_caixa;
    }

    public void setSaldoIn_caixa(Double saldoIn_caixa) {
        this.saldoIn_caixa = saldoIn_caixa;
    }

    public Double getTotalRec_caixa() {
        return totalRec_caixa;
    }

    public void setTotalRec_caixa(Double totalRec_caixa) {
        this.totalRec_caixa = totalRec_caixa;
    }

    public Double getTotalPag_caixa() {
        return totalPag_caixa;
    }

    public void setTotalPag_caixa(Double totalPag_caixa) {
        this.totalPag_caixa = totalPag_caixa;
    }

    public Double getSaldoFin_caixa() {
        return saldoFin_caixa;
    }

    public void setSaldoFin_caixa(Double saldoFin_caixa) {
        this.saldoFin_caixa = saldoFin_caixa;
    }
    
}

