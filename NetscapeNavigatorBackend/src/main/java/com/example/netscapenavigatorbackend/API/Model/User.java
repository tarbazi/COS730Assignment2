package com.example.netscapenavigatorbackend.API.Model;
import java.util.ArrayList;

public class User {
    String userName;
    String password;
    ArrayList<String> visitedLinks;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        visitedLinks = new ArrayList<>();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addLink(String visitedLink){
        visitedLinks.add(visitedLink);
    }

    public void deleteLink(int pos){
        visitedLinks.remove(pos);
    }
}
