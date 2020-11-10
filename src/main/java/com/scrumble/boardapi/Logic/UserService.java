package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.User;
import com.scrumble.boardapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        var users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.isEmpty() ? null : user.get();
    }

    public boolean register(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public User singIn(User user) throws Exception {
        throw new Exception("Not implemented");
    }
}
