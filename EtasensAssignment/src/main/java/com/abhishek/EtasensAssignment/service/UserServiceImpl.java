package com.abhishek.EtasensAssignment.service;

import com.abhishek.EtasensAssignment.entity.User;
import com.abhishek.EtasensAssignment.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findByFirstName(String firstName) {
        return userRepo.findByFirstName(firstName);
    }

//    @Override
//    public User findById(Integer id) {
//        Optional<User> result = userRepo.findById(id);//
//        User user = null;
//
//        if (result.isPresent()) user = result.get();
//        else throw new RuntimeException("Did not find employee id - " + id);
//        return user;
//    }




}
