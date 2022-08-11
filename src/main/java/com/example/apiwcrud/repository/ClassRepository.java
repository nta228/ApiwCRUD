package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.Tblclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ClassRepository extends JpaRepository<Tblclass, Integer> {
    List<Tblclass> findAllByName(String name);

    List<Tblclass> findAllByNameContainsIgnoreCase(String name);
}
