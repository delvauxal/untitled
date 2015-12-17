package com.java.supinfo.supbartering.dao;

import com.java.supinfo.supbartering.dao.entity.User;
import java.util.List;

/**
 * Created by Alex on 11/12/2015.
 */

public interface UserDao {
    User addUser(User user);
    List<User> getAllUsers();
    public User findUserById(Long id);
    public void removeUser(User findUserById);
    public void updateUser(User user);
}
