package br.edu.ifsul.cc.lpoo_studiodanca.dao;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.InterfacePersistencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenciaJPA implements InterfacePersistencia {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_studio_danca");
        entity = factory.createEntityManager();
    }
    
    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }

    
    
}
