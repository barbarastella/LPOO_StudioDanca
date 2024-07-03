package br.edu.ifsul.cc.lpoo_studiodanca;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import org.junit.Test;

public class TestePersistencia {

    @Test
    public void testeConexao()
    {
        PersistenciaJPA jpa = new PersistenciaJPA();
        
        if (jpa.conexaoAberta())
            System.out.println("Conexão com o BD realizada com sucesso!");
        else 
            System.out.println("Falha ao conectar ao BD!");
    } 
}
