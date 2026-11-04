/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import appNutritionist.Models.DietDetail;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
/**
 *
 * @author Usuario
 */
public class DietDetailDAOJPA implements DietDetailDAO {
    
    private final EntityManagerFactory emf;

    public DietDetailDAOJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(DietDetail dietDetail) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(dietDetail);
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
    public DietDetail findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(DietDetail.class, id);

        } finally {
            em.close();
        }
    }

    @Override
    public List<DietDetail> listAll() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT p FROM modelDietDetail p",
                DietDetail.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public void update(DietDetail dietDetail) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(dietDetail);
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

            DietDetail dietDetail =
                em.find(DietDetail.class, id);

            if (dietDetail != null) {
                em.remove(dietDetail);
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
