package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "modalidade")
@NamedQueries({
    @NamedQuery(name = "Modalidade.orderbyid", query = "SELECT m FROM Modalidade m ORDER BY m.ID")
})
public class Modalidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;

    @Column(nullable = false, length = 155, name = "descrição")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "modalidade_professor")
    private Professor professor;

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

    @Override
    public String toString() {
        return descricao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
