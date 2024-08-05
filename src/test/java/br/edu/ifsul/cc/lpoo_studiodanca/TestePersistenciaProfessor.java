package br.edu.ifsul.cc.lpoo_studiodanca;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Professor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistenciaProfessor {
    
 PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaProfessor() {}

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaProfessor() throws Exception {
       
        Professor prof1 = new Professor();
        prof1.setNome("João");
        jpa.persist(prof1);
        
        Professor prof2 = new Professor();
        prof2.setNome("Ana");
        jpa.persist(prof2);
        
        Professor prof3 = new Professor();
        prof3.setNome("Maria");
        jpa.persist(prof3);
    }
}
