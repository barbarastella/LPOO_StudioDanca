package br.edu.ifsul.cc.lpoo_studiodanca;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import org.junit.Test;

public class TestePersistencia {

    @Test
    public void testeConexao()
    {
        PersistenciaJPA jpa = new PersistenciaJPA();
        
        if (jpa.conexaoAberta())
            System.out.println("\n\nConexão com o BD realizada com sucesso!\n\n");
        else 
            System.out.println("\n\nFalha ao conectar ao BD!\n\n");
    } 
}
