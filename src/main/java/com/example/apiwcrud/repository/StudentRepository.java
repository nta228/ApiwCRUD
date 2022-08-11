package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.Student;
import com.example.apiwcrud.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);
    List<Student> findAllByNameContainsIgnoreCase(String name);
    List<Student> findAllByNameAndEmail(String name, String email);
    List<Student> findAllByNameOrderByEmailAsc(String name);
}
