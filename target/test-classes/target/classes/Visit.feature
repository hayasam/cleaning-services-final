Feature: Show Visit for Customers
  Description: Show a visit to the Cleaning Order system
  Actors: Secretary

  Scenario: the customer visit the Cleaning system on his Order
    Given the secretary is logged in
    When a customer arrived to  Cleaning system on his Order
    Then a visit will be recorded

  Scenario: the customer visit the  Cleaning system without Order
    Given the secretary is logged in
    When a customer arrived to  Cleaning system without Order
    And the worker is available
    Then a visit will be recorded

  Scenario: the customer visit the  Cleaning system without Order
    Given the secretary is logged in
    When a customer arrived to  Cleaning system without Order
    And the worker is not available
    Then an Order will be recorded
