
package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // informa que há uma tabela no BD com nome Pagamento
@Table(name = "pagamento")
public class Pagamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;
    
    @Column(nullable = false, name = "Data_Vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataVcto;
    
    @Column(name = "Valor", precision = 10, scale = 2)
    private double valor;
    
    @Column(name = "Valor_Pagamento", precision = 10, scale = 2)
    private double valorPgto;
    
    @Column(name = "Data_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPgto;
    
    @ManyToOne
    @JoinColumn(name = "Contratos", referencedColumnName = "id", nullable = false)
    private Contratos contrato;

    public Integer getID() {
        return ID;
    }

    public Calendar getDataVcto() {
        return dataVcto;
    }

    public double getValor() {
        return valor;
    }

    public double getValorPgto() {
        return valorPgto;
    }

    public Calendar getDataPgto() {
        return dataPgto;
    }

    public Contratos getContrato() {
        return contrato;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setDataVcto(Calendar dataVcto) {
        this.dataVcto = dataVcto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setValorPgto(double valorPgto) {
        this.valorPgto = valorPgto;
    }

    public void setDataPgto(Calendar dataPgto) {
        this.dataPgto = dataPgto;
    }

    public void setContrato(Contratos contrato) {
        this.contrato = contrato;
    }
}