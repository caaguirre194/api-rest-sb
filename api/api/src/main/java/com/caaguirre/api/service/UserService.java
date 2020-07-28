package com.caaguirre.api.service;

import com.caaguirre.api.common.EmailValidator;
import com.caaguirre.api.model.User;
import com.caaguirre.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;

    private final EmailValidator emailValidator;

    @Autowired
    public UserService(@Qualifier("postgreSQL") IUserRepository userRepository, EmailValidator emailValidator) {
        this.userRepository = userRepository;
        this.emailValidator = emailValidator;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Long userId){
        userRepository.delete(userId);
    }

    public void updateUser(User user){
        userRepository.update(user);
    }

    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

}
