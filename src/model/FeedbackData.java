package model;

public class FeedbackData {
    private String type;
    private String issue;
    private String suggestion;

    public FeedbackData(String type, String issue, String suggestion) {
        this.type = type;
        this.issue = issue;
        this.suggestion = suggestion;
    }

    public String getType() { return type; }
    public String getIssue() { return issue; }
    public String getSuggestion() { return suggestion; }
} 