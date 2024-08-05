package br.edu.ifsul.cc.lpoo_studiodanca.dao;

import br.edu.ifsul.cc.lpoo_studiodanca.model.Modalidade;
import br.edu.ifsul.cc.lpoo_studiodanca.model.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PersistenciaJPA implements InterfacePersistencia {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_studio_danca");
        entity = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public Boolean conexaoAberta() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        EntityManager em = getEntityManager();
        return em.find(c, id);
    }

    @Override
    public void persist(Object o) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                o = em.merge(o);
            }
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    /*public List<Modalidade> getModalidades() {
        return entity.createNamedQuery("Modalidade.orderbyid", Modalidade.class).getResultList();
    }*/
    
      public List<Modalidade> getModalidades() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Modalidade> query
                    = em.createQuery("SELECT m FROM Modalidade m", Modalidade.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      
        public List<Professor> getProfessores() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p", Professor.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addModalidade(String nome) {
        entity.getTransaction().begin();

        Modalidade modalidade = new Modalidade();
        modalidade.setDescricao(nome);

        entity.persist(modalidade);
        entity.getTransaction().commit();
    }
}
