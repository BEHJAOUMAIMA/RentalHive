package com.example.rental_hive.service;

import com.example.rental_hive.domain.Equipment;
import com.example.rental_hive.domain.User;
import com.example.rental_hive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    public User save(User user);

    public List<User> findAll();

    public User findById(Long id);

    public User update(User userUpdated);

    public void delete(User user);
}
