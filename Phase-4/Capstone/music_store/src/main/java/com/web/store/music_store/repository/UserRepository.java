package com.web.store.music_store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.store.music_store.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByUsername(String name);
	//public User findByEmail(String email);

}
