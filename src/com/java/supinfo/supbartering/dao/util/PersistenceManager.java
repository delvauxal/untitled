package com.java.supinfo.supbartering.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Created by Alex on 16/12/2015.
 */

public class PersistenceManager {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PU");
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}