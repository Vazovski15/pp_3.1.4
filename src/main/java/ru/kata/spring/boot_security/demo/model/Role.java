package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Role implements GrantedAuthority {

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    public Role() {}


    public Role(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
