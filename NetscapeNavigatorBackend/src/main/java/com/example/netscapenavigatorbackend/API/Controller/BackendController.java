package com.example.netscapenavigatorbackend.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.netscapenavigatorbackend.API.Model.User;
import com.example.netscapenavigatorbackend.API.Model.Response;
import com.example.netscapenavigatorbackend.Service.UserService;

@RestController
public class BackendController {

    private UserService userService;
    
    @Autowired
    public BackendController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/createUser")
    public Response createUser(@RequestParam String userName, @RequestParam String password, @RequestParam String phoneNumber){
        return userService.createUser(userName, password, phoneNumber).get();
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam String userName, @RequestParam String password){
        return userService.getUser(userName, password).get();
    }
}