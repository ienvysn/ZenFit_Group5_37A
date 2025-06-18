/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FeedbackDao;
import view.Feedback;

/**
 *
 * @author Salifa
 */
public class FeedbackController {
    private final FeedbackDao dao = new FeedbackDao();

    public boolean submitFeedback(String type, String issue, String suggestion) {
        Feedback feedback = new Feedback(type, issue, suggestion);
        return dao.addFeedback(feedback);
    }
}


