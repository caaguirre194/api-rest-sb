package com.caaguirre.api.service;

import com.caaguirre.api.model.User;
import com.caaguirre.api.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("postgreSQL") IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.createUser(user);
    }

    public void deleteUser(Long userId){
        userRepository.deleteUser(userId);
    }

    public void updateUser(User user){
        userRepository.updateUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.selectAllUsers();
    }

}
