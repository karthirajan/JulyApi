#Author: your.email@your.domain.com
Feature:

 @newpetcreation
  Scenario: Create a new pet Using Post Method
    Given User launches URI
    When user make POST call on the pet status endpoint for available pets "/pet"
    |432|1|Mahesh|Bull dog|url1|url2|1|breed|2|foreign|available|
    Then user need to get a response code: 200
    Then User validates the response of pets
    When The user makes a GET call to the resources "/pet/"
    Then user need to get a response code: 200
    Then User validates the response of pets
