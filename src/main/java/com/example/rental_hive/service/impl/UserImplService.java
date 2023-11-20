package com.example.rental_hive.service.impl;

import com.example.rental_hive.domain.User;
import com.example.rental_hive.repository.UserRepository;
import com.example.rental_hive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserImplService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User userUpdated) {
        Optional<User> user = userRepository.findById(userUpdated.getId());
        if (user.isPresent()){
            return userRepository.save(userUpdated);
        }
        return null;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
