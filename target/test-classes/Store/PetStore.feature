Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Place an order for a pet
    Given User launches URI
    When The user makes the post call to the endpoint "/store/order" with "<id>","<petId>","<quantity>","<shipdate>","<status>" and "<complete>"
    Then user need to get a response code: 200
    And The user validates the "<id>","<petId>","<quantity>","<shipdate>","<status>" and "<complete>"
    Given User launches URI
    When The user makes a GET call to the resource "store/order/"
    Then user need to get a response code: 200
    And The user validates the "<id>","<petId>","<quantity>","<shipdate>","<status>" and "<complete>"

    Examples: 
      | id    | petId  | quantity | shipdate                 | status    | complete |
      | 8765 | 193849 |        4 | 2020-07-04T05:00:07.538Z | available | true     |
      
      
