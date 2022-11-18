package com.overseas.workshopmongo.repositories;

import com.overseas.workshopmongo.entities.User;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
