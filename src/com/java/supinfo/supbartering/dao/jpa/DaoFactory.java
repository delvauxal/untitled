package com.java.supinfo.supbartering.dao.jpa;

import com.java.supinfo.supbartering.dao.ProductDao;
import com.java.supinfo.supbartering.dao.UserDao;
import com.java.supinfo.supbartering.dao.util.PersistenceManager;

/**
 * Created by Alex on 16/12/2015.
 */


public class DaoFactory {
    private static JpaUserDao userService;
    private static JpaProductDao productService;



    public static UserDao getUserDao() {
        if (userService == null) {
            userService = new JpaUserDao(PersistenceManager.getEntityManagerFactory());
        }
        return userService;
    }

    public static ProductDao getProductDao() {
        if (productService == null) {
            productService = new JpaProductDao(PersistenceManager.getEntityManagerFactory());
        }
        return productService;
    }
}