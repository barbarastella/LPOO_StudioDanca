package br.edu.ifsul.cc.lpoo_studiodanca;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Contratos;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Modalidade;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Pacotes;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Pagamento;
import br.edu.ifsul.cc.lpoo_studiodanca.model.FormaPgto;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistenciaModalidade {
    
 PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaModalidade() {}

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaModalidade() throws Exception {

        
         // teste de modalidade
        
       /* Modalidade m = new Modalidade();
        m.setDescricao("Dança livre");

        Modalidade m2 = new Modalidade();
        m2.setDescricao("FitDance");

        Modalidade m3 = new Modalidade();
        m3.setDescricao("Street");

        jpa.persist(m);
        jpa.persist(m2);
        jpa.persist(m3);*/
        
      jpa.getModalidades();
        
        /*
        // teste de contrato
        
        Contratos c = new Contratos();
        c.setData_inicio(Calendar.getInstance());
        c.setForma_pgto(FormaPgto.PIX);
        c.setValor_desconto(20.678);
        
        Contratos c2 = new Contratos();
        c2.setData_inicio(Calendar.getInstance());
        c2.setForma_pgto(FormaPgto.DINHEIRO);
        c2.setValor_desconto(15.9385749);
        
        jpa.persist(c);
        jpa.persist(c2);
        
        // teste de pagamento

        Pagamento p = new Pagamento();
        p.setDataPgto(Calendar.getInstance());
        p.setDataVcto(Calendar.getInstance());
        p.setValor(100.489);
        p.setValorPgto(100.489);
        p.setContrato(c2);
        
        Pagamento p2 = new Pagamento();
        p2.setDataPgto(Calendar.getInstance());
        p2.setDataVcto(Calendar.getInstance());
        p2.setValor(200.463728);
        p2.setValorPgto(240.985346);
        p2.setContrato(c);
        
        jpa.persist(p);
        jpa.persist(p2);
        
        // teste de pacote

        Pacotes pc = new Pacotes();
        pc.setDescricao("8x/mês");
        pc.setModalidade(m3);
        pc.setValor(540.00);
        
        Pacotes pc2 = new Pacotes();
        pc2.setDescricao("4x/mês");
        pc2.setModalidade(m3);
        pc2.setValor(300.505);
        
        Pacotes pc3 = new Pacotes();
        pc3.setDescricao("4x/mês");
        pc3.setModalidade(m2);
        pc3.setValor(300.50);
        
        jpa.persist(pc);
        jpa.persist(pc2);
        jpa.persist(pc3);

        Modalidade persistidoModalidade = (Modalidade) jpa.find(Modalidade.class, m.getID());
        Assert.assertEquals(m.getDescricao(), persistidoModalidade.getDescricao()); */
    }
}
