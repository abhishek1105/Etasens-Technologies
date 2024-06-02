package com.abhishek.EtasensAssignment.service;

import com.abhishek.EtasensAssignment.entity.User;
import com.abhishek.EtasensAssignment.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
//    public User findByFirstNameAndId(String firstName, Integer id) {
//        User byFirstName = userRepo.findByFirstName(firstName);
//        Optional<User> byId = userRepo.findById(id);
//        if (byFirstName.getId().equals(byId.get().getId()))
//            return byFirstName;
//        return byFirstName;
//    }

}
