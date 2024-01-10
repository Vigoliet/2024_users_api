package com.example._users_api.services;

import com.example._users_api.models.User;
import com.example._users_api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    // Get all users
    public Iterable<User> getAllUsers(){
        return usersRepository.findAll();
    }


    // Get one user
    public Optional<User> getUserById(Long id) {
        return usersRepository.findById(id);
    }


    // Create user
    public User createUser(@RequestBody User user){
        usersRepository.save(user);
        return user;
    }

    // Update user
    public boolean updateUserById(@PathVariable Long id, @RequestBody User user){
        if (usersRepository.existsById(id))
            user.setId(id);
        usersRepository.save(user);
        return true;
    }

    // Delete user
    public boolean deleteUserById(@PathVariable Long id){
        // Check if the users exits
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
            // Else return false
        } else {
            return false;
        }
    }

    // Seed user
    public boolean seed(){
        try {
            User[] users = {
                    new User("vigor", "vigor@test.se"),
                    new User("andreas", "andreas@test.se"),
                    new User("adam", "adam@test.se")
            };
            var usersList = Arrays.stream(users).toList();
            usersRepository.saveAll(usersList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }


}
