package br.edu.ifsul.cc.lpoo_studiodanca.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_contrato")
public class ItensContrato implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;
     
    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contratos contrato;
    
    @ManyToOne
    @JoinColumn(name = "pacote_id")
    private Pacotes pacote;
}
    
