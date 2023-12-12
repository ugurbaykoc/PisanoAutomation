Feature: Filling in Agreement form
  I want to complete and submit agreement form
  Scenario: Fill in and select relevant fields to submit Agreement form
    When Conversation flow textbox is filled in
    And User agreement is accepted
    And Favorite feedback tool is selected
    Then Next Page button is clicked to proceed to next page action