/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FeedbackDao;
import model.FeedbackData;
import java.util.List;

/**
 *
 * @author Salifa
 */
public class FeedbackController {
    private final FeedbackDao feedbackDao;

    public FeedbackController() {
        this.feedbackDao = new FeedbackDao();
    }

    public List<FeedbackData> getAllFeedback() {
        return feedbackDao.getAllFeedback();
    }

    public boolean submitFeedback(String type, String issue, String suggestion) {
        FeedbackData feedback = new FeedbackData(type, issue, suggestion);
        return feedbackDao.addFeedback(feedback);
    }
}


