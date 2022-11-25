package com.overseas.workshopmongo.resources;

import com.overseas.workshopmongo.entities.Post;
import com.overseas.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.findById(id));
    }
}
