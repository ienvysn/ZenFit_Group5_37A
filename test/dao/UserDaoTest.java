/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.List;
import model.LoginRequest;
import model.UserData;


/**
 *
 * @author Acer
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    
   
    /**
     * Test of signup method, of class UserDao.
     */
      public void testSignup() {
        System.out.println("signup");
        UserData user = null;
        UserDao instance = new UserDao();
        instance.signup(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class UserDao.
     */
    
    public void testCheckUser() {
        System.out.println("checkUser");
        UserData user = null;
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.checkUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Login method, of class UserDao.
     */
  
    public void testLogin() {
        System.out.println("Login");
        UserData user = null;
        UserDao instance = new UserDao();
        instance.Login(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class UserDao.
     */
  
    public void testCheckLogin() {
        System.out.println("checkLogin");
        LoginRequest user = null;
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.checkLogin(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByUsername method, of class UserDao.
     */
 
    public void testGetUserByUsername() {
        System.out.println("getUserByUsername");
        String username = "";
        UserDao instance = new UserDao();
        UserData expResult = null;
        UserData result = instance.getUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserDao.
     */
  
    public void testGetUserById() {
        System.out.println("getUserById");
        int id = 0;
        UserDao instance = new UserDao();
        UserData expResult = null;
        UserData result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class UserDao.
     */

    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserDao instance = new UserDao();
        List<UserData> expResult = null;
        List<UserData> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDao.
     */

    public void testDeleteUser() {
        System.out.println("deleteUser");
        String username = "";
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.deleteUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private void fail(String the_test_case_is_a_prototype) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(boolean expResult, boolean result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(UserData expResult, UserData result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(List<UserData> expResult, List<UserData> result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
