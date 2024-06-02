package com.abhishek.EtasensAssignment.service;

import com.abhishek.EtasensAssignment.entity.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getAllUsers();

    User findByFirstName(String firstName);

//    User findByFirstNameAndId(String firstName, Integer id);
}
