package com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findById(int id);
}