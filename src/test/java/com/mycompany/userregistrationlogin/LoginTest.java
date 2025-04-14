/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.userregistrationlogin;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectFormat() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Test123!", "+27838968976");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameIncorrectFormat() {
        Login login = new Login("Kyle", "Smith", "kyle!!!!!!!", "Test123!", "+27838968976");
        assertFalse(login.checkUserName());
        assertEquals(
            "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.",
            login.registerUser()
        );
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Anna", "Miller", "ann_2", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordFailsComplexity() {
        Login login = new Login("Anna", "Miller", "ann_2", "password", "+27838968976");
        assertFalse(login.checkPasswordComplexity());
        assertEquals(
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
            login.registerUser()
        );
    }

    @Test
    public void testCellPhoneCorrectFormat() {
        Login login = new Login("Leo", "Taylor", "leo_3", "Valid123!", "+27838968976");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectFormat() {
        Login login = new Login("Leo", "Taylor", "leo_3", "Valid123!", "08966553");
        assertFalse(login.checkCellPhoneNumber());
        assertEquals(
            "Cell phone number incorrectly formatted or does not contain international code.",
            login.registerUser()
        );
    }

    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("Zara", "Jones", "zar_1", "Test123!", "+27838968976");
        login.registerUser();
        assertTrue(login.loginUser("zar_1", "Test123!"));
        assertEquals("Welcome Zara, Jones it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    public void testFailedLogin() {
        Login login = new Login("Zara", "Jones", "zar_1", "Test123!", "+27838968976");
        login.registerUser();
        assertFalse(login.loginUser("wrongUser", "wrongPass"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
}
