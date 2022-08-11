package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Users;
import com.example.apiwcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceIpm implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public void saveUser(Users u) {
        userRepository.save(u);

    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public Users findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }
    public List<Users> findAllByName(String name){
        return userRepository.findAllByName(name);
    }
}
