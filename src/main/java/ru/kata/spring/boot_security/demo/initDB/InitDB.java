package ru.kata.spring.boot_security.demo.initDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;



@Component
public class InitDB {
    private final UserService userService;


    public InitDB(UserService userService) {
        this.userService = userService;

    }

    @PostConstruct
   public void initDBInit(){
       User admin = new User("Ivan","Ivanov",25,"ivanov@gmail.com",
               "$2y$10$T2xl2aqRUT2ksgpoX8YPpOGOD28v9u/flBABPTw6NRirVxnePxrYK","vano");
       admin.setRoles(new HashSet<>());
       Role role1 = new Role("ROLE_ADMIN");
       admin.addRole(role1);
       userService.saveUser(admin);
   }

}



