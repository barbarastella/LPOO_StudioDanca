package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // informa que há uma tabela no BD com nome Modalidade
public class Modalidade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;
    
    @Column(nullable = false, length = 155, name = "Descrição")
    private String descricao;

    public Modalidade(Integer ID, String descricao) {
        this.ID = ID;
        this.descricao = descricao;
    }
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}
