package view;

import javax.swing.*;
import java.awt.*;
import model.FeedbackData;

public class FeedbackCardPanel extends JPanel {
    private JLabel feedbackType;
    private JLabel feedbackIssue;
    private JLabel feedbackSuggestion;

    public FeedbackCardPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(4, 39, 56));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 0;
        add(typeLabel, gbc);

        feedbackType = new JLabel();
        feedbackType.setForeground(Color.WHITE);
        gbc.gridx = 1;
        add(feedbackType, gbc);

        JLabel issueLabel = new JLabel("Issue:");
        issueLabel.setForeground(Color.WHITE);
        issueLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 1;
        add(issueLabel, gbc);

        feedbackIssue = new JLabel();
        feedbackIssue.setForeground(Color.WHITE);
        gbc.gridx = 1;
        add(feedbackIssue, gbc);

        JLabel suggestionLabel = new JLabel("Suggestion:");
        suggestionLabel.setForeground(Color.WHITE);
        suggestionLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 2;
        add(suggestionLabel, gbc);

        feedbackSuggestion = new JLabel();
        feedbackSuggestion.setForeground(Color.WHITE);
        gbc.gridx = 1;
        add(feedbackSuggestion, gbc);
    }

    public void setFeedbackData(FeedbackData data) {
        feedbackType.setText(data.getType());
        feedbackIssue.setText(data.getIssue());
        feedbackSuggestion.setText(data.getSuggestion());
    }
} 