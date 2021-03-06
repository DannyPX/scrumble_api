package com.scrumble.boardapi.RestControllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.scrumble.boardapi.Connections.ApiClient;
import com.scrumble.boardapi.Logic.UserService;
import com.scrumble.boardapi.Models.User;
import com.scrumble.boardapi.Resources.CreateUserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = userService.getById(id);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody CreateUserResource newUser) {
        User user = new User.Builder(newUser.getUsername())
                .build();
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }
}
