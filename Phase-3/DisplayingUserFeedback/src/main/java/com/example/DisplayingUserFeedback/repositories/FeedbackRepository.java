package com.example.DisplayingUserFeedback.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.DisplayingUserFeedback.entities.*;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

}