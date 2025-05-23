/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class MySqlConnection implements Database {

    @Override
    public Connection openConnection() {
        try {
            String username = "root";
            String password = "salifa11";
            String database = "zenfit";

            Connection connection;
            connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database, username, password);

            if (connection == null) {
                System.out.println("Database not connected");
            } else {
                System.out.println("Database connected");
            }

            return connection;

        } catch (SQLException e ) {
            System.out.print(e);
            return null;
        }
            
        }

    @Override
    public void CloseConnection(Connection conn) {
        try{
            if(conn !=null && !conn.isClosed()){
                conn.close();
                System.out.println("Database closed");

            }
        }catch(SQLException e){
            System.out.print(e);
        }
    }

    @Override
    public ResultSet runQuery(Connection conn, String query) {
        try{
        Statement stmp= conn.createStatement();
        ResultSet result= stmp.executeQuery(query);
        return result;
        
    }catch(SQLException e){
        System.out.println(e);
        return null;
    }
    }
    @Override
    public int executeUpdate(Connection conn, String query) {
        try{
        Statement stmp= conn.createStatement();
        int result= stmp.executeUpdate(query);
        return result;
        
    }catch(SQLException e){
        System.out.println(e);
        return -1;
    }
    }
    
    
}
