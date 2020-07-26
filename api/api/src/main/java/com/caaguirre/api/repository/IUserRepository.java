package com.caaguirre.api.repository;

import com.caaguirre.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository {

    Optional<User> findByUsername(String username);

    List<User> selectAllStudents();

    void deleteUser(Long userId);

    void createUser(User user);

    void updateUser(User user);

}
