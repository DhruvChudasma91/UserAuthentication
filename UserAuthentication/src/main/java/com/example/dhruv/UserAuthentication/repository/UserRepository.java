package com.example.dhruv.UserAuthentication.repository;

import com.example.dhruv.UserAuthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
