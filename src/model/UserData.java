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

    public UserData( String username, String password, Date joinedDate, Date expiryDate, String membershipType){
       
        this.username = username;
        this.password = password;
        this.joinedDate = joinedDate;
        this.expiryDate = expiryDate;
        this.membershipType = membershipType;
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

    
}

