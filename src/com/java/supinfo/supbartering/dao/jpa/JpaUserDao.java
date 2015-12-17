package com.java.supinfo.supbartering.dao.jpa;

import com.java.supinfo.supbartering.dao.UserDao;
import com.java.supinfo.supbartering.dao.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Alex on 11/12/2015.
 */

@Stateless
public class JpaUserDao implements UserDao {

    private EntityManagerFactory emf;

    public JpaUserDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public User addUser(User user) {
        User result = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
        return result;
    }

    @Override
    public User findUserById(Long id) {
        User result;

        EntityManager em = emf.createEntityManager();
        try {
            result = em.find(User.class, id);
        } catch (NoResultException e) {
            result = null;
        } finally {
            em.close();
        }

        return result;
    }


    @Override
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM User AS u");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public void removeUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(user));
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

}