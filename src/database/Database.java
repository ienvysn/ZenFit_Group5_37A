/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;
/**
 *
 * @author ACER
 */
public interface Database {
   Connection openConnection();
   void CloseConnection(Connection conn);
   ResultSet runQuery(Connection conn,String query);  // start ma yo
   int executeUpdate(Connection conn,String query); //execute bho bhane yo
    
}
