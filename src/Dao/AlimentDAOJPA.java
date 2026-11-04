/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import appNutritionist.Models.Aliment;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
/**
 *
 * @author Usuario
 */
public class AlimentDAOJPA implements AlimentDAO {
    
    private final EntityManagerFactory emf;

    public AlimentDAOJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Aliment aliment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(aliment);
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
    public Aliment findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Aliment.class, id);

        } finally {
            em.close();
        }
    }

    @Override
    public List<Aliment> listAll() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT p FROM modelAliment p",
                Aliment.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public void update(Aliment aliment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(aliment);
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

            Aliment aliment =
                em.find(Aliment.class, id);

            if (aliment != null) {
                em.remove(aliment);
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
