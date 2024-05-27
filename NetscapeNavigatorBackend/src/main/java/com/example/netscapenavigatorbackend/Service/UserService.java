package com.example.netscapenavigatorbackend.Service;

import com.example.netscapenavigatorbackend.API.Model.User;
import com.example.netscapenavigatorbackend.API.Model.Response;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    ArrayList<User> users;

    public UserService(){
        users = new ArrayList<>();
        users.add(new User("nenekazi123","200204","0839991567"));
        users.add(new User("bazie521", "22943", "0604853210"));
        users.add(new User("nenekazipaca", "0204", "0787089731"));
        users.add(new User("kwaito", "kwidzi", "0737899297"));
    }

    public Optional<Response> createUser(String userName, String password, String phoneNumber){
        for (User user: users){
            if (user.getUserName().equals(userName)){
                return Optional.of(new Response("NAK"));
            }
        }
        users.add(new User(userName, password, phoneNumber));
        return Optional.of(new Response("ACK"));
    }

    public Optional<Response> login(String userName, String password){
        for (User user: users){
            if (user.getUserName().equals(userName)){
                String response = user.checkPassword(password);
                if (response.equals("ACK")){
                    return Optional.of(new Response("ACK"));
                }
                else{
                    return Optional.of(new Response("NAK"));
                }
            }
        }
        
        return Optional.of(new Response("NAK"));
    }

    public Optional<Response> addLink(String userName, String visitedLink){
        for (User user: users){
            if (user.getUserName().equals(userName)){
                String response = user.addLink(visitedLink);
                if (response.equals("ACK")){
                    return Optional.of(new Response("ACK"));
                }
                else{
                    return Optional.of(new Response("NAK"));
                }
            }
        }
        
        return Optional.of(new Response("NAK"));
    }

    public Optional<Response> deleteLink(String userName, int pos){
        for (User user: users){
            if (user.getUserName().equals(userName)){
                String response = user.deleteLink(pos);
                if (response.equals("ACK")){
                    return Optional.of(new Response("ACK"));
                }
                else{
                    return Optional.of(new Response("NAK"));
                }
            }
        }
        
        return Optional.of(new Response("NAK"));
    }

    public Optional<User> getInsights(String userName){
        for (User user: users){
            if (user.getUserName().equals(userName)){
                return Optional.of(user);
            }
        }
        
        return Optional.of(new User("None","None","None"));
    }
}
