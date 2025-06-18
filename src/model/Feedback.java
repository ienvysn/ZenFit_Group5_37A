/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Salifa
 */
public class Feedback {
    private String typee;
    private String issue;
    private String suggestion;

    public Feedback(String typee, String issue, String suggestion) {
        this.typee = typee;
        this.issue = issue;
        this.suggestion = suggestion;
    }

    // Getters
    public String getTypee() {
        return typee;
    }

    public String getIssue() {
        return issue;
    }

    public String getSuggestion() {
        return suggestion;
    }

    // Setters (optional if needed)
}


