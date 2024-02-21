package com.microservices.restfullwebservices.controller;

import com.microservices.restfullwebservices.exception.UserNotFoundException;
import com.microservices.restfullwebservices.dao.UserDao;
import com.microservices.restfullwebservices.entity.User;
import com.microservices.restfullwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {
    private MessageSource messageSource;
    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService , MessageSource messageSource) {
        this.userDaoService = userDaoService;
        this.messageSource = messageSource;
    }

    @GetMapping("/helloI18")
    public String helloworldI18(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

    @GetMapping("/users")
    public List<User> getAllUsr() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getAllUser(@PathVariable int id) {
        User saveUser= userDaoService.findById(id);
        if(saveUser == null){
           throw new UserNotFoundException("id : "+ id);
        }
        return saveUser;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody UserDao userDao) {
        User savedUser = userDaoService.createUser(userDao);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        boolean deleted= userDaoService.deleteById(id);
    }

}
