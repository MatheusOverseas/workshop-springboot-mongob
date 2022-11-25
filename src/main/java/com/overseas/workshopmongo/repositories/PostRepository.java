package com.overseas.workshopmongo.repositories;

import com.overseas.workshopmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
