Feature: Generating a report
  Description: Generating a report
  Actors: Worker, Secretary

  Scenario: The secretary needs to generate a report on the number of visitors in a given month
    When the secretary is logged in
    And and he/she want to check the number of visitors in a certain month "05"
    And he choose visitors list for a certain month
    And click on button "Generate report"
    Then a report of number of visitors will be generated

  Scenario: The secretary need to generate a report for the available services
    When the secretary is logged in
    And and he/she want to check the number of available services
    And he/she choose services list
    And click on button "Generate report"
    Then a report of available services will be generated
