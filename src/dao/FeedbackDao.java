/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.Database;
import database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import view.Feedback;

public class FeedbackDao {

    private final Database db;

    public FeedbackDao() {
        this.db = new MySqlConnection(); // Your own DB connection handler
    }

    public boolean addFeedback(Feedback feedback) {
        Connection conn = null;
        try {
            conn = db.openConnection();
            String sql = "INSERT INTO feedback (typee, issue, suggestion) VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, feedback.getTypee());
            stmt.setString(2, feedback.getIssue());
            stmt.setString(3, feedback.getSuggestion());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            if (conn != null) {
                db.CloseConnection(conn);
            }
        }
    }
}


