package com.overseas.workshopmongo.services;

import com.overseas.workshopmongo.entities.Post;
import com.overseas.workshopmongo.repositories.PostRepository;
import com.overseas.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> p = postRepository.findById(id);
        return p.orElseThrow(() -> new ObjectNotFoundException("Post not found. Id: " + id));
    }
}
