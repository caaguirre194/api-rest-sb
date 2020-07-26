package com.caaguirre.api.repository;

import com.caaguirre.api.model.User;

import java.util.List;

public interface IUserRepository {

    /**
     * find a user by his username
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * find a user by his id
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * get all users
     * @return
     */
    List<User> selectAllUsers();

    /**
     * delete user by his id
     * @param userId
     * @return
     */
    int deleteUser(Long userId);

    /**
     * create a user
     * @param user
     */
    int createUser(User user);

    /**
     * update a user
     * @param user
     */
    void updateUser(User user);

}
