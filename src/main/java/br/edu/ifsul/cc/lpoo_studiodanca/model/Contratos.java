package br.edu.ifsul.cc.lpoo_studiodanca.model;
    
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contratos")
public class Contratos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;
    
    @Column(nullable = false, name = "data_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_inicio;
    
    @Column(name = "Valor_desconto", columnDefinition = "decimal(12,2)")
    private double valor_desconto;
    
    @Column(nullable = false, name = "forma_pagamento")
    @Enumerated(EnumType.STRING)
    private FormaPgto forma_pgto;

    @OneToMany(mappedBy = "contratos", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private Collection<ItensContrato> itensContrato;
    
    public Contratos() {
        this.data_inicio = Calendar.getInstance();
    }

    public Integer getID() {
        return ID;
    }

    public Calendar getData_inicio() {
        return data_inicio;
    }

    public double getValor_desconto() {
        return valor_desconto;
    }

    public FormaPgto getForma_pgto() {
        return forma_pgto;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public void setValor_desconto(double valor_desconto) {
        this.valor_desconto = valor_desconto;
    }

    public void setForma_pgto(FormaPgto forma_pgto) {
        this.forma_pgto = forma_pgto;
    }

    public Collection<ItensContrato> getItensContrato() {
        return itensContrato;
    }

    public void setItensContrato(List<ItensContrato> itensContrato) {
        this.itensContrato = itensContrato;
    }
}

    