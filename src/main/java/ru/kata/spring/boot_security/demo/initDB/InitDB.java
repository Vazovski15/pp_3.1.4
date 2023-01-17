package ru.kata.spring.boot_security.demo.initDB;

import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class InitDB {
    private final UserService userService;
    private final RoleService roleService;
    private final UserRepository userRepository;


    public InitDB(UserService userService, RoleService roleService, UserRepository userRepository) {
        this.userService = userService;

        this.roleService = roleService;
        this.userRepository = userRepository;
    }

   /* @PostConstruct
    public void initDBInit(){
        User admin = new User("Ivan","Ivanov",25,"ivanov@gmail.com",
                "$2y$10$T2xl2aqRUT2ksgpoX8YPpOGOD28v9u/flBABPTw6NRirVxnePxrYK","vano");
        admin.setRoles(new HashSet<>());
        Role role1 = new Role("ROLE_ADMIN");
        admin.addRole(role1);


        userService.saveUser(admin);
    }*/
    @PostConstruct
    public void initDBInit() {
        User admin = new User("Ivan", "Ivanov", 25, "ivanov@gmail.com",
                "$2y$10$T2xl2aqRUT2ksgpoX8YPpOGOD28v9u/flBABPTw6NRirVxnePxrYK", "vano");
        Role role1=new Role("ROLE_ADMIN");
        Set<Role>roleAdmin=new HashSet<>(Set.of(role1));
        admin.setRoles(roleAdmin);
        userRepository.save(admin);

        User user=new User("Kris", "Sidorova", 30, "kris@gmail.com",
                "$2y$10$T2xl2aqRUT2ksgpoX8YPpOGOD28v9u/flBABPTw6NRirVxnePxrYK", "ks");
        Role role2=new Role("ROLE_USER");
        Set<Role>roleUser=new HashSet<>(Set.of(role2));
        user.setRoles(roleUser);
        userRepository.save(user);



    }
}



