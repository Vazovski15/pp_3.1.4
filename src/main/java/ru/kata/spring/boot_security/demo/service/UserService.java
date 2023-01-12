package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getUserList();

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    User getUserByName(String username);
}
