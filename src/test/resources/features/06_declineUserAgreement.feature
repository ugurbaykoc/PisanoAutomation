Feature: Decline User Agreement
  I want to see Feedbackform Returned to the begining When I decline User Agreement
  Scenario: Verify widget open event
    When Switched to iframe
    And Click to widget button
  Scenario: Select Satisfactory score and Sentiment on first page
    When Switched to Iframe content
    And Select random satisfactory score
    And Select random Sentiment
    Then Next Step button is clicked to proceed to next step
  Scenario: Fill in and select relevant fields to submit Agreement form
    When Conversation flow textbox is filled in
    And User agreement is declined
    And Favorite feedback tool is selected
    And Next Page button is clicked to proceed to next page action
    Then Message on the first page is verified with "Would you recommend us to your friends and colleagues? (0: Not likely at all, 10: Very likely)"
