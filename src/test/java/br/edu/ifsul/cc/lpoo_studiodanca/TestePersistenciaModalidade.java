package br.edu.ifsul.cc.lpoo_studiodanca;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Modalidade;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistenciaModalidade {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaModalidade() {
    }

    @Before // o que fazer ANTES da persistência
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After // o que fazer DEPOIS da persistência
    public void tearDown() {
        jpa.fecharConexao();
    }
    
    @Test
    public void testePersistenciaModalidade() throws Exception
    {
        // criar um objeto Modalidade
        Modalidade m = new Modalidade();
        m.setDescricao("Dança live");
        
        // persistir objeto
        jpa.persist(m);
        
        // buscar objeto persistido
        Modalidade persistidoModalidade = (Modalidade)jpa.find(Modalidade.class, m.ID);
        
        // verificar se o objeto persistido é igual ao criado
        Assert.assertEquals(m.getDescricao(), persistidoModalidade.getDescricao());
    }
}
