package Dao;

import appNutritionist.Models.Patient;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


public class PatientDAOJPA implements PatientDAO {

    private final EntityManagerFactory emf;

    public PatientDAOJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Patient patient) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(patient);
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
    public Patient findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Patient.class, id);

        } finally {
            em.close();
        }
    }

    @Override
    public List<Patient> listAll() {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT p FROM modelPatient p",
                Patient.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public void update(Patient patient) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(patient);
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

            Patient patient =
                em.find(Patient.class, id);

            if (patient != null) {
                em.remove(patient);
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