package com.dh.Clase15_SpringMVC.repository;

import com.dh.Clase15_SpringMVC.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}