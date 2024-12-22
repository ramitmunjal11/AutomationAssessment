Feature: User Sign Up

  Scenario: Successful User Registration
    Given I am on the sign-up page
    When I enter valid details "FName" "LName" "test3921@test.com" "Password123" "Password123"
    And I click on Create an Account
    Then I should see a success message

  Scenario: Registration with Existing Email
    Given I am on the sign-up page
    When I enter same email details "FFName" "LLName" "test3921@test.com" "Password123" "Password123"
    And I click on Create an Account
    Then I should see an error message for existing email