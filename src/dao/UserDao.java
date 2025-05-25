/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.MySqlConnection;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Date;

import model.UserData;
import model.LoginRequest;
/**
 *
 * @author ACER
 */
public class UserDao {
    MySqlConnection mysql= new MySqlConnection();
 

    public UserDao() {
    }
public void signup(UserData user){
Connection conn =mysql.openConnection();
String sql= "INSERT INTO users(username,password,joined_date,expiry_date,membership_type) VALUES(?,?,?,?,?)";
    try(PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2,user.getPassword());
        pstmt.setDate(3, new Date(user.getJoinedDate().getTime()));
        pstmt.setDate(4, new Date(user.getExpiryDate().getTime()));
        pstmt.setString(5, user.getMembershipType());
        pstmt.executeUpdate();
    }catch(SQLException ex){
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
    mysql.CloseConnection(conn);
    }
}

public boolean checkUser(UserData user){
    Connection conn = mysql.openConnection();
    String sql= "SELECT * FROM users WHERE username=?";
    try(PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1, user.getUsername());
       ResultSet result= pstmt.executeQuery();
       return result.next();
    }catch(SQLException ex){
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        mysql.CloseConnection(conn);
    }
    return false;
}

public void Login(UserData user){
    Connection conn =mysql.openConnection();
    String sql= "SELECT * FROM users WHERE username=? AND password=?";
    try(PreparedStatement pstmt = conn.prepareStatement(sql)){
         pstmt.setString(1,user.getUsername());
        pstmt.setString(2, user.getPassword());
       ResultSet result= pstmt.executeQuery();
    }catch(SQLException ex){
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        mysql.CloseConnection(conn);
    }
}
public boolean checkLogin(LoginRequest user){
    Connection conn = mysql.openConnection();
    String sql= "SELECT * FROM users WHERE username=? AND password=? AND (expiry_date IS NULL OR expiry_date >= CURRENT_DATE)";
    try(PreparedStatement pstmt = conn.prepareStatement(sql)){
         pstmt.setString(1,user.getUsername());
        pstmt.setString(2, user.getPassword());
       ResultSet result= pstmt.executeQuery();
       return result.next();
    }catch(SQLException ex){
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        mysql.CloseConnection(conn);
    }
    return false;
}
}




