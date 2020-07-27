package com.caaguirre.api.controller;

import com.caaguirre.api.model.User;
import com.caaguirre.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody @Valid User user){
        userService.createUser(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping
    public void updateUser(@RequestBody @Valid User user){
        userService.updateUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() { return userService.selectAllUsers(); }

}
