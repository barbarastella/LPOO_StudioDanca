package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Alunos extends Pessoas {

    @Column(name = "data_inicio")
    private Calendar data_inicio;
    
    @Column(name = "data_pagamento")
    private Integer data_Pgto;

    public Calendar getDataInicio() {
        return data_inicio;
    }

    public void setDataInicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Integer getDataPgto() {
        return data_Pgto;
    }

    public void setDataPgto(Integer data_Pgto) {
        this.data_Pgto = data_Pgto;
    }
}
