package com.learning.team5shopstrumenti.interfaccie;

import com.learning.team5shopstrumenti.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByFirstName(String firstName);
}