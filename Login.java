package com.myapp.quickchat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Shiko
 */
public class Login {

    private String username;
    private String password;
    private String cellPhone;

    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password != null &&
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    public boolean checkCellPhoneNumber(String cellPhone) {
        return cellPhone != null && cellPhone.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String username, String password, String cellPhone) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;

        return "User has been registered successfully.";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername != null &&
               inputPassword != null &&
               inputUsername.equals(this.username) &&
               inputPassword.equals(this.password);
    }

    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome user, user it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
