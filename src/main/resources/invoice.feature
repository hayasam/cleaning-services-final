Feature: Issuing an invoice
  Description: Issuing an invoice
  Actors: Secretary

  Scenario: The customer request completed
    When the customer request completed
    Then the secretary will issue the invoice
