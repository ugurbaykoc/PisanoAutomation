Feature: Filling in Feedback Form
  I want to complete and submit the feedback form
  Scenario: Select Satisfactory score and Sentiment on first page
    When Switched to Iframe content
    And Select random satisfactory score
    And Select random Sentiment
    Then Next Step button is clicked to proceed to next step
