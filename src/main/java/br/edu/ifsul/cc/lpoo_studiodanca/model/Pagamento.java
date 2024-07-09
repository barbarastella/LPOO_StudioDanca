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

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;

    @Column(nullable = false, name = "data_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataVcto;

    @Column(name = "valor", columnDefinition = "decimal(12,2)")
    private double valor;

    @Column(name = "valor_pagamento", columnDefinition = "decimal(12,2)")
    private double valorPgto;

    @Column(name = "data_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPgto;

    @ManyToOne
    @JoinColumn(name = "contratos", referencedColumnName = "id", nullable = false)
    private Contratos contrato;

    public void gerarPgto(Integer mes) {
        if (mes <= dataVcto.get(Calendar.DAY_OF_MONTH)) {
            setDataPgto(Calendar.getInstance());
        } else {
            setDataPgto(null);
        }
    }

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
