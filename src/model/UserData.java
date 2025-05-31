/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class UserData {
    private int id;
    private String username;
    private String password;
    private Date joinedDate;
    private Date expiryDate;
    private String membershipType;
    private String role;
    private byte[] image;
    private String phone;

    public UserData(String username, String phone,String password, Date joinedDate, Date expiryDate, String membershipType,String role,byte[] image) {

        this.username = username;
        this.phone= phone;
        this.password = password;
        this.joinedDate = joinedDate;
        this.expiryDate = expiryDate;
        this.membershipType = membershipType;
        this.role = role;
        this.image = image;
        
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public byte[] getImage() {
        return image;
    }
    public String getPhone() {
        return phone;
    }



    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
     public void setImage(byte[] image) {
        this.image = image;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

