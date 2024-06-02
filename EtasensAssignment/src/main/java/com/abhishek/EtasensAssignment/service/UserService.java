package com.abhishek.EtasensAssignment.service;

import com.abhishek.EtasensAssignment.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(User user);

    List<User> getAllUsers();

//    Optional<User> updateUser(Long id, User user);

    User findByFirstName(String firstName);

//    User findById(Integer id);


}
