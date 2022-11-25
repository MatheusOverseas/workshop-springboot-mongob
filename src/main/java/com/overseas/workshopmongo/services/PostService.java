package com.overseas.workshopmongo.services;

import com.overseas.workshopmongo.entities.Post;
import com.overseas.workshopmongo.repositories.PostRepository;
import com.overseas.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> p = postRepository.findById(id);
        return p.orElseThrow(() -> new ObjectNotFoundException("Post not found. Id: " + id));
    }

    public List<Post> findByTitle(String msg){
        return postRepository.findByTitle(msg);
    }

    public List<Post> fullSearch(String msg, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
        return postRepository.fullSearch(msg, minDate, maxDate);
    }
}
