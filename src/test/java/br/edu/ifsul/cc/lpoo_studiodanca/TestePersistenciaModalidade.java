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

        Modalidade m = new Modalidade();
        m.setDescricao("Dança Livre");

        Modalidade m2 = new Modalidade();
        m2.setDescricao("FitDance");

        Modalidade m3 = new Modalidade();
        m3.setDescricao("Gluteos");

        jpa.persist(m);
        jpa.persist(m2);
        jpa.persist(m3);
        
        Contratos c = new Contratos();
        c.setData_inicio(Calendar.getInstance());
        c.setForma_pgto(FormaPgto.PIX);
        jpa.persist(c);

        Pagamento p1 = new Pagamento();
        p1.setDataPgto(Calendar.getInstance());
        p1.setDataVcto(Calendar.getInstance());
        p1.setValor(200.463728);
        p1.setValorPgto(240.985346);
        p1.setContrato(c);
        jpa.persist(p1);

        Pacotes pc = new Pacotes();
        pc.setDescricao("testando pacotes");
        pc.setModalidade(m3);
        pc.setValor(540.94767);
        jpa.persist(pc);

        Modalidade persistidoModalidade = (Modalidade) jpa.find(Modalidade.class, m.getID());
        Assert.assertEquals(m.getDescricao(), persistidoModalidade.getDescricao());

    }
}
