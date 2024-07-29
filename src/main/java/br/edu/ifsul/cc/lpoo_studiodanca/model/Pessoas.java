package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Pessoas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "aniversario")
    private Calendar data_aniversario;
    
    @Column(name = "e-mail")
    private String email;
    
    @Column(name = "endereço")
    private String endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Calendar getDataAniversario() {
        return data_aniversario;
    }

    public void setDataAniversario(Calendar data_aniversario) {
        this.data_aniversario = data_aniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
