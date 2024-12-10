Feature: Home Page Title Verification

  Scenario: Verify the home page title, navbar,items
    Given I navigate to the homepage
    Then the title should be "STORE"
    Then the navigation list should contain the following items
      | Home    |
      | Contact |
      | About us|
      | Cart    |
      | Log in  |
      | Sign up |
    And the categories list should contain the following items
      | Phones   |
      | Laptops  |
      | Monitors |
