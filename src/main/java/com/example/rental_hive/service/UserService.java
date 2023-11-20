package com.example.rental_hive.service;

import com.example.rental_hive.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public User save(User user);

    public List<User> findAll();

    public Optional<User> findById(Long id);

    public User update(User userUpdated);

    public void delete(User user);
}
