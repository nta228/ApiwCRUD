package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.Tblclass;
import com.example.apiwcrud.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value = "classes", method = RequestMethod.GET)
    public ResponseEntity<List<Tblclass>> findAllClass(){
        List<Tblclass> lsClass = classService.findAll();
        if (lsClass.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // return new ResponseEntity.ok(lsUser);
        }
        return new ResponseEntity<List<Tblclass>>(lsClass,HttpStatus.OK);
    }
    @RequestMapping(value = "classes/save", method = RequestMethod.POST)
    public ResponseEntity<Tblclass> saveNewClass(@RequestBody Tblclass c){
        classService.saveClass(c);
        return new ResponseEntity<Tblclass>(c, HttpStatus.OK);
    }
    @RequestMapping(value = "classes/update", method = RequestMethod.PUT)
    public ResponseEntity<Tblclass> updateClass(
            @PathParam("id") Integer id, @RequestBody Tblclass c){
        Tblclass oldClass = classService.findById(id);
        oldClass.setName(c.getName());
        classService.saveClass(oldClass);
        return new ResponseEntity<Tblclass>(oldClass, HttpStatus.OK);
    }
    @RequestMapping(value = "classes/update2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tblclass> updateClass2(
            @PathVariable("id") Integer id,
            @RequestBody Tblclass c){
        Tblclass oldClass = classService.findById(id);
        oldClass.setName(c.getName());
        classService.saveClass(oldClass);
        return new ResponseEntity<Tblclass>(oldClass, HttpStatus.OK);
    }
    @RequestMapping(value = "class/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tblclass> deleteClass(
            @PathVariable("id") Integer id){
        classService.deleteClass(id);
        return ResponseEntity.ok().build();
    }

}
