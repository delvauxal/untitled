package com.java.supinfo.supbartering.dao.jpa;

import com.java.supinfo.supbartering.dao.ProductDao;
import com.java.supinfo.supbartering.dao.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Alex on 11/12/2015.
 */

public class JpaProductDao implements ProductDao {

    private EntityManagerFactory emf;

    public JpaProductDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Product addProduct(Product product) {
        Product result = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(product);
            em.getTransaction().commit();
            result = product;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
        return result;
    }

    @Override
    public Product findProductById(Long id) {
        Product result;

        EntityManager em = emf.createEntityManager();
        try {
            result = em.find(Product.class, id);
        } catch (NoResultException e) {
            result = null;
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public List<Product> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaQuery<Product> criteriaQuery = em.getCriteriaBuilder()
                    .createQuery(Product.class);
            criteriaQuery.from(Product.class);
            return em.createQuery(criteriaQuery).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Product> getCheaperProducts() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT p FROM Product AS p WHERE p.price <= 100");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(product);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public void removeProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(product));
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

}