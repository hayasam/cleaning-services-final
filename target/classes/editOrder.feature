Feature: Edit Order in Cleaning system
  Description: Edit an order in the Cleaning Order system
  Actors: Customer

  Scenario: the customer edit his order successfully
    Given the customer is logged in
    And he/she is opening the order page
    And  he/she has at leaset one order
    And he/she want to edit this order to another time
    When he/she click on "edit" button Next to each order
    And he/she should  choose another avaliable order to book
    Then this order will be booked for this customer
    And success message appear "Done"


  Scenario: the customer edit his order unsuccessfully
    Given the customer is logged in
    And he/she is opening the order page
    And  he/she has at leaset one order
    And he/she want to edit this Order to another time
    When he/she click on "edit" button Next to each Order
    And he/she  choose unavailable time
    Then error message will appear "Choose another time to order"