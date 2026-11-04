/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import appNutritionist.Models.Diet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
/**
 *
 * @author Usuario
 */
public class DietDAOJPA implements DietDAO {
    
    private final EntityManagerFactory emf;

    public DietDAOJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Diet diet) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(diet);
            tx.commit();

        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    @Override
    public Diet findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Diet.class, id);

        } finally {
            em.close();
        }
    }

    @Override
    public List<Diet> listAll() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT p FROM modelDiet p",
                Diet.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public void update(Diet diet) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(diet);
            tx.commit();

        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Diet diet =
                em.find(Diet.class, id);

            if (diet != null) {
                em.remove(diet);
            }

            tx.commit();

        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }
    
}
