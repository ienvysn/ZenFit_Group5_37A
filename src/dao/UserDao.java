/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;

import java.sql.*;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;

import model.UserData;
import model.LoginRequest;

/**
 *
 * @author ACER
 */
public class UserDao {
    MySqlConnection mysql = new MySqlConnection();

    public UserDao() {
    }

    public void signup(UserData user) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO users(username,password,joined_date,expiry_date,membership_type,role,image,phone) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setDate(3, new Date(user.getJoinedDate().getTime()));
            pstmt.setDate(4, new Date(user.getExpiryDate().getTime()));
            pstmt.setString(5, user.getMembershipType());
            pstmt.setString(6, "member");
            pstmt.setBytes(7, user.getImage());
            pstmt.setString(8, user.getPhone());

            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.CloseConnection(conn);
        }
    }

    public boolean checkUser(UserData user) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE username=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.CloseConnection(conn);
        }
        return false;
    }

    public void Login(UserData user) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            ResultSet result = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.CloseConnection(conn);
        }
    }

    public boolean checkLogin(LoginRequest user) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE username=? AND password=? AND (expiry_date IS NULL OR expiry_date >= CURRENT_DATE)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.CloseConnection(conn);
        }
        return false;
    }

    public UserData getUserByUsername(String username) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE username=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                // Construct UserData from result set
                return new UserData(
                        result.getString("username"),
                        result.getString("phone"),
                        result.getString("password"),
                        result.getDate("joined_date"),
                        result.getDate("expiry_date"),
                        result.getString("membership_type"),
                        result.getString("role"),
                        result.getBytes("image")
                        );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.CloseConnection(conn);
        }
        return null;
    }

    public UserData getUserById(int id) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                // Construct UserData from result set
                UserData user = new UserData(
                        result.getString("username"),
                        result.getString("phone"),
                        result.getString("password"),
                        result.getDate("joined_date"),
                        result.getDate("expiry_date"),
                        result.getString("membership_type"),
                        result.getString("role"),
                        result.getBytes("image")
                );
                user.setId(result.getInt("id"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.CloseConnection(conn);
        }
        return null;
    }

    public List<UserData> getAllUsers() {
        List<UserData> users = new ArrayList<>();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE role='member'";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                users.add(new UserData(
                 result.getString("username"),
                 result.getString("phone"),
                 result.getString("password"),
                result.getDate("joined_date"),
                 result.getDate("expiry_date"),
                 result.getString("membership_type"),
                 result.getString("role"),
                 result.getBytes("image")
  ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.CloseConnection(conn);
        }
        return users;
    }

    public boolean deleteUser(String username) {
        Connection conn = mysql.openConnection();
        String sql = "DELETE FROM users WHERE username=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            mysql.CloseConnection(conn);
        }
    }
}
