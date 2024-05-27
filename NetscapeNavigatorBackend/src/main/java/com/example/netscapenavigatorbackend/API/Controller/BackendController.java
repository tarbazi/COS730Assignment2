package com.example.netscapenavigatorbackend.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/loginr")
    public Response login(@RequestParam String userName, @RequestParam String password){
        return userService.login(userName, password).get;
    }

    @GetMapping("/addLink")
    public Response addLink(@RequestParam String userName, @RequestParam String visitedLink){
        return userService.addLink(userName, visitedLink).get();
    }

    @GetMapping("/deleteLink")
    public Response deleteLink(@RequestParam String userName, @RequestParam int pos){
        return userService.deleteLink(userName, pos).get();
    }

    @GetMapping("/getInsights")
    public User getInsights(@RequestParam String userName){
        return userService.getInsights(userName).get();
    }
}