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
import model.Feedback;
import model.FeedbackData;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao {

    private final MySqlConnection db = new MySqlConnection();

    public boolean addFeedback(FeedbackData feedback) {
        Connection conn = null;
        try {
            conn = db.openConnection();
            String sql = "INSERT INTO feedback (typee, issue, suggestion) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, feedback.getType());
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

    public List<FeedbackData> getAllFeedback() {
        List<FeedbackData> feedbackList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = db.openConnection();
            String sql = "SELECT typee, issue, suggestion FROM feedback";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FeedbackData feedback = new FeedbackData(
                    rs.getString("typee"),
                    rs.getString("issue"),
                    rs.getString("suggestion")
                );
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) db.CloseConnection(conn);
        }
        return feedbackList;
    }
}


