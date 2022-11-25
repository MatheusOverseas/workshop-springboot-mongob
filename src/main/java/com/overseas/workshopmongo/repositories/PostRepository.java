package com.overseas.workshopmongo.repositories;

import com.overseas.workshopmongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String msg);

    @Query("{ 'title': {$regex: ?0, $options: 'i'}}")
    List<Post> findByTitle(String text);
}
