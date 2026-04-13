package com.myapp.quickchat.junittests;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Shiko
 */
import com.myapp.quickchat.Login;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testValidUsername() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(login.checkPasswordComplexity("Chasec@1"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testValidCell() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testInvalidCell() {
        assertFalse(login.checkCellPhoneNumber("0838968976"));
    }

    @Test
    public void testLoginSuccess() {
        login.registerUser("kyl_1", "Chasec@1", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Chasec@1"));
    }

    @Test
    public void testLoginFail() {
        login.registerUser("kyl_1", "Chasec@1", "+27838968976");
        assertFalse(login.loginUser("wrong", "wrong"));
    }
}
