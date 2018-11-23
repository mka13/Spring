package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.Entity.User;
import com.sda.javapoz11.hellospring.hellospring.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping ("/users")
public class UsersControler {
    @Autowired
    private UsersService usersService;


  //  @GetMapping(value = "/users")
  @GetMapping()
    public List<User> users(String lastName) {
        return usersService.findAll();

    }

   // @GetMapping(value = "/users", params = "lastName")
   @GetMapping(params = "lastName")
    public List<User> usersByLastName(@RequestParam("lastName") String lastName) {
        return usersService.findByLastName(lastName);
    }

    // @GetMapping("/users/{id}")
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return usersService.findById(id);
    }

}
