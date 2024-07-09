package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;

public class Professores extends Pessoas {
    
    @Column(name = "data_admissao")
    private Calendar data_admissao;
    
    @OneToMany
    private List<FolhaPagamento> folha_pgto = new ArrayList();
    
    @OneToMany
    private List<Modalidade> modalidade = new ArrayList();

    public Collection<Modalidade> getModalidade() {
        return modalidade;
    }

    public void setData_admissao(Calendar data_admissao) {
        this.data_admissao = data_admissao;
    }

    public void setFolha_pgto(List<FolhaPagamento> folha_pgto) {
        this.folha_pgto = folha_pgto;
    }

    public void setModalidade(List<Modalidade> modalidade) {
        this.modalidade = modalidade;
    }

    
       
}
