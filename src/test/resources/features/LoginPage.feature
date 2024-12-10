Feature: Login Page Functionality

  Scenario Outline: User logs in with valid credentials
    Given I am on the login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I click the login button
    Then I should see the "<message>"

    Examples:
      | username      | password       | message           |
      | testuser       | testpassword   | Welcome   |
      | wronguser      | testpassword   | Wrong password   |
      | testuser       | wrongpassword  | Wrong password   |
      | wronguser      | wrongpassword  | Wrong password   |
      | wronguser      |                | Please fill out Username and Password.   |
      |                | wrongpassword  | Please fill out Username and Password.   |
