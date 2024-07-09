package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "folha_pagamento")
public class FolhaPagamento  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;
    
    @Column(name = "data_pagamento")
    private Calendar data_pgto;
    
    @Column(name = "valor_receber")
    private Double valor_receber;
    
    public void calcularFolhaMes(){}

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public Calendar getDataPgto() {
        return data_pgto;
    }

    public void setDataPgto(Calendar data_pgto) {
        this.data_pgto = data_pgto;
    }

    public Double getValorReceber() {
        return valor_receber;
    }

    public void setValorReceber(Double valor_receber) {
        this.valor_receber = valor_receber;
    }
    
    
}
