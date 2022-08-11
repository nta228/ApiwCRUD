package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Tblclass;
import com.example.apiwcrud.model.Users;

import java.util.List;

public interface ClassService {
    public void saveClass(Tblclass c);
    public void deleteClass(Integer id);
    public Tblclass findById(Integer id);
    public List<Tblclass> findAll();
    public List<Tblclass> findAllByName(String name);
}
