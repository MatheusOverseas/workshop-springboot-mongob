package com.overseas.workshopmongo.resources;

import com.overseas.workshopmongo.dto.UserDTO;
import com.overseas.workshopmongo.entities.User;
import com.overseas.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listUDTO = list.stream().map(UserDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(listUDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User u = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(u));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
       userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
     User u = userService.fromDTO(objDTO);
     u = userService.insert(u);
     URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
     return ResponseEntity.created(uri).build();
    }
 }
