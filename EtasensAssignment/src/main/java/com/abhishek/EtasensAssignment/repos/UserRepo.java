package com.abhishek.EtasensAssignment.repos;

import com.abhishek.EtasensAssignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByFirstName(String firstName);
}
