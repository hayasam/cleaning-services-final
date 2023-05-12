Feature: Users Sign Out
  Description: The Users signed out of the Cleaning Management System
  Actor: All Users

  Background:
    Given the users credentials

      |Ahmad     |ahmad123|0595642327|Tulkrem   |Admin |
      |Qasem     |qasem123|0595642328|Nublus    |Worker|
      |Anas      |anas123 |0595642329|Jenin     |Customer|
      |Sara      |sara123 |0595642324|Ramallah  |Secretary|

  Scenario Outline: the <role> signed out
    Given that the <role> is signed in
    When the <role> signs out
    Then the <role> is not signed in

    Examples:
       |username    |password  |phone     |address   |role|
      |"Ahmad"     |"ahmad123"|0595642327|Tulkrem   |"Admin" |
      |"Qasem"     |"qasem123"|0595642328|Nubles    |"Worker"|
      |"Anas"      |"anas123" |0595642329|Jenin     |"Customer"|
      |"Sara"      |"sara123" |0595642324|Ramallah  |"Secretary"|

