package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.Users;
import com.example.apiwcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> findAllUser(){
        List<Users> lsUser = userService.findAll();
        if (lsUser.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // return new ResponseEntity.ok(lsUser);
        }
        return new ResponseEntity<List<Users>>(lsUser,HttpStatus.OK);
    }
    @RequestMapping(value = "user/save", method = RequestMethod.POST)
    public ResponseEntity<Users> saveNewUser(@RequestBody Users u){
        userService.saveUser(u);
        return new ResponseEntity<Users>(u, HttpStatus.OK);
    }
    @RequestMapping(value = "user/update", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateUser(
            @PathParam ("id") Integer id,@RequestBody Users u){
        Users oldUser = userService.findById(id);
        oldUser.setName(u.getName());
        oldUser.setEmail(u.getEmail());
        oldUser.setPhone(u.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<Users>(oldUser, HttpStatus.OK);
    }
    @RequestMapping(value = "user/update2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateUser2(
            @PathVariable("id") Integer id,
            @RequestBody Users u){
        Users oldUser = userService.findById(id);
        oldUser.setName(u.getName());
        oldUser.setEmail(u.getEmail());
        oldUser.setPhone(u.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<Users>(oldUser, HttpStatus.OK);
    }
    @RequestMapping(value = "user/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteUser(
            @PathVariable("id") Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
