Feature: Adding a service
  Description: Customer wants to adding a service
  Actors: Customer

  Scenario: the service is available
    Given the customer is logged in
    And the customer want to select a service
    When the customer select a service "2"
    And the service is available
    Then the service price will be added to the invoice
    And message displayed "Service added successfully"


  Scenario: the service is not available
    Given the customer is logged in
    And the customer want to select a service
    When the customer select a service "1"
    And the service is not available
    Then message displayed "This service is not available"
    
     Scenario: Discount
    Given the customer is chose the service
    When totel price of the service less than 250
    Then the customer while have dicount 10%
    Scenario: Discount
    Given the customer is chose the service
    When totel price of the service more than 250 and less than 500
    Then the customer while have dicount 15%
    Scenario: Discount
    Given the customer is chose the service
    When totel price of the service more thant 500
    Then the customer while have dicount 20%
    
