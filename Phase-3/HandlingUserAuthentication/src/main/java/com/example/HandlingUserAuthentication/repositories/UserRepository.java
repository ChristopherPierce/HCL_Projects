package com.example.HandlingUserAuthentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.HandlingUserAuthentication.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}