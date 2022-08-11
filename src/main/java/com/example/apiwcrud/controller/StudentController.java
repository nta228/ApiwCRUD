package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.Student;
import com.example.apiwcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAllStudent(){
        List<Student> lsStudent = studentService.findAll();
        if (lsStudent.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // return new ResponseEntity.ok(lsUser);
        }
        return new ResponseEntity<List<Student>>(lsStudent,HttpStatus.OK);
    }
    @RequestMapping(value = "students/save", method = RequestMethod.POST)
    public ResponseEntity<Student> saveNewStudent(@RequestBody Student s){
        studentService.saveStudent(s);
        return new ResponseEntity<Student>(s, HttpStatus.OK);
    }
    @RequestMapping(value = "students/update", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(
            @PathParam("id") Integer id, @RequestBody Student s){
        Student oldStudent = studentService.findById(id);
        oldStudent.setName(s.getName());
        oldStudent.setEmail(s.getEmail());
        oldStudent.setPhone(s.getPhone());
        studentService.saveStudent(oldStudent);
        return new ResponseEntity<Student>(oldStudent, HttpStatus.OK);
    }
    @RequestMapping(value = "students/update2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent2(
            @PathVariable("id") Integer id,
            @RequestBody Student s){
        Student oldStudent = studentService.findById(id);
        oldStudent.setName(s.getName());
        oldStudent.setEmail(s.getEmail());
        oldStudent.setPhone(s.getPhone());
        studentService.saveStudent(oldStudent);
        return new ResponseEntity<Student>(oldStudent, HttpStatus.OK);
    }
    @RequestMapping(value = "students/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(
            @PathVariable("id") Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}