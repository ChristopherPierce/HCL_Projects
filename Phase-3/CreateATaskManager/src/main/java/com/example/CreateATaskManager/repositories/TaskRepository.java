package com.example.CreateATaskManager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.CreateATaskManager.entities.Task;
import com.example.CreateATaskManager.entities.User;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	public Task findById(int id);
	//public Iterable<Task> findAllByUser(User user);
}