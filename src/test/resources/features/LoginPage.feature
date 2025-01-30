Feature: Login Page Functionality

  Scenario Outline: User logs in with valid credentials
    Given I am on the login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I click the login button
    Then I should see the "<message>"

    Examples:
      | username       | password       | message          |
      | nightmare      |nightmare       | Welcome          |
      | wronguser      | nightmare      | Wrong password   |
      | nightmare      | wrongpassword  | Wrong password   |
      | wronguser      | wrongpassword  | Wrong password   |
      | wronguser      |                | Please fill out Username and Password.   |
      |                | wrongpassword  | Please fill out Username and Password.   |
