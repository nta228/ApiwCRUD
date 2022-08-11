package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findAllByName(String name);
    List<Users> findAllByNameContainsIgnoreCase(String name);
    List<Users> findAllByNameAndEmail(String name, String email);
    List<Users> findAllByNameOrderByEmailAsc(String name);
}
