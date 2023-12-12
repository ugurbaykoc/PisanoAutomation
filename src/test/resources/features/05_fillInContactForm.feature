Feature: Fill In Contact Form Function
  I want to complete Contact Form

  Scenario: Fill im Contact Form
    When Email field is filled in
    And Name field is filled in
    And Country Code button is clicked
    And Verify the Country code container with "Afghanistan" placeholder text
    And Country Code is Searched with "Turkey"
    And Country Code is Selected
    And Phone Number is Filled
    And Submit button is clicked
    And See the "Thanks, I think test were succeeded" message
    Then Page is Refreshed
