package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pacotes")
public class Pacotes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;
    
    @Column(nullable = false, length = 155, name = "Descrição")
    private String descricao;
    
    @Column(precision = 10, columnDefinition = "decimal(12,2)")
    private double valor;
    
    @ManyToOne
    @JoinColumn(name = "modalidade_id", columnDefinition = "decimal(12,2)")
    private Modalidade modalidade;

    public Integer getID() {
        return ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
