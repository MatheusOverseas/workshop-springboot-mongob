package com.overseas.workshopmongo.repositories;

import com.overseas.workshopmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String msg);
}
