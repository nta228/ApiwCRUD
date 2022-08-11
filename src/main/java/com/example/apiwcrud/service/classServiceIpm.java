package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Student;
import com.example.apiwcrud.model.Tblclass;
import com.example.apiwcrud.repository.ClassRepository;
import com.example.apiwcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classServiceIpm implements ClassService{
    @Autowired
    ClassRepository classRepository;
    @Override
    public void saveClass(Tblclass c) {
        classRepository.save(c);

    }

    @Override
    public void deleteClass(Integer id) {
        classRepository.deleteById(id);

    }

    @Override
    public Tblclass findById(Integer id) {
        return classRepository.findById(id).get();
    }

    @Override
    public List<Tblclass> findAll() {
        return classRepository.findAll();
    }
    public List<Tblclass> findAllByName(String name){
        return classRepository.findAllByName(name);
    }
}
