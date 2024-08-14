package com.desafiomagalu.services;

import com.desafiomagalu.domain.user.User;
import com.desafiomagalu.dtos.UserDTO;
import com.desafiomagalu.exception.UserNotFoundException;
import com.desafiomagalu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(UserDTO data) {
        User newUser = new User(data); // Use the UserDTO to initialize the User
        this.saveUser(newUser);
        return newUser;
    }

    public void saveUser(User user) {
        this.repository.save(user);
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id)
                .orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public void deleteUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (repository.findUserById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
    }
}
