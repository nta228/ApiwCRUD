package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Users;

import java.util.List;

public interface UserService {
    public void saveUser(Users u);
    public void deleteUser(Integer id);
    public Users findById(Integer id);
    public List<Users> findAll();
    public List<Users> findAllByName(String name);
}
