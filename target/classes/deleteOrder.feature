Feature: Delete Order in Cleaning system
  Description: Delete an order in the Cleaning Order system
  Actors: Customer

  Scenario: the customer delete his order
    Given the customer is logged in
    And he/she is opening the order page
    And  he/she has at leaset one order
    And he/she want to delete this order
    When he/she click on "delete" button Next to edit button
    And click on "Yes" from the confirmation message
    Then this order will be deleted
    And success message appear "Done"

  Scenario: the customer try to delete his order
    Given the customer is logged in
    And he/she is opening the order page
    And  he/she has at leaset one order
    And he/she want to delete this order
    When he/she click on "delete" button Next to edit button
    And click on "No" from the confirmation message
    Then this order will not be deleted