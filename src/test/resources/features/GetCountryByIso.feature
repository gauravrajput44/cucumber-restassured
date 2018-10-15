@ISO
Feature: Get country 

  Scenario Outline: User calls web service to get a valid country by iso code
    Given a country exists with "<code>"
    When a user retrieves the country by iso
    Then the status code is 200
    And response includes the "<country>"

    Examples: 
      | code | country                  							|
      | US   | United States of America 							|
      | DE   | Germany                    							|
      | GB   | United Kingdom of Great Britain and Northern Ireland |

   Scenario Outline: User calls web service to get a country by invalid iso code
    Given a country exists with "<code>"
    When a user retrieves the country by iso
    Then the status code is 200
    And response includes the following "<message>"
    
    Examples: 
      | code 		| message                  											|
      | invalidiso  | No matching country found for requested code [invalidiso].	   	|
    
      