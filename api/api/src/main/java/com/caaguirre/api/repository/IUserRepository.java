package com.caaguirre.api.repository;

import com.caaguirre.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

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
    User getOne(Long id);

    /**
     * get all users
     * @return
     */
    List<User> findAll();

    /**
     * delete user by his id
     * @param userId
     * @return
     */
    int delete(Long userId);

    /**
     * create a user
     * @param user
     */
    int save(User user);

    /**
     * update a user
     * @param user
     */
    void update(User user);

}
