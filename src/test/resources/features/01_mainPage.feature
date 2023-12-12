Feature: Main page opening
I want to see if the main page opens when I go to the correct url

Scenario: User clicks to the url 

Given I navigate to "https://stage.psn.cx/widget-preview?code=PSN-eh35zwa"
Then I should see the "https://stage.psn.cx/widget-preview?code=PSN-eh35zwa" is opened
