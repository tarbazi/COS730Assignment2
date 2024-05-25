package com.example.netscapenavigatorbackend.API.Model;
import java.util.ArrayList;

public class User {
    String userName;
    String password;
    String phoneNumber;
    ArrayList<String> visitedLinks;

    public User(String userName, String password, String phoneNumber){
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        visitedLinks = new ArrayList<>();
    } //new user constructor

    public void setUserName(String userName) {
        this.userName = userName;
    } //userName set method

    private void setPassword(String password) {
        this.password = password;
    } //password set method

    public String changePassword(String oldPassword, String newPassword){
        if (oldPassword.equals(password)){
            setPassword(newPassword);
            return "ACK";
        }
        else{
            return "{ Response : NAK}";
        }
    } //set password upon user password change

    public String passwordReset(){
        String newPassword = Integer.toString((int)Math.random()*10000);
        setPassword(newPassword);
        return newPassword;
    } //reset user password

    public void addLink(String visitedLink){
        visitedLinks.add(visitedLink);
    } //add visited link to the users visited links list

    public void deleteLink(int pos){
        visitedLinks.remove(pos); 
    } //deletes history element in position pos
}
