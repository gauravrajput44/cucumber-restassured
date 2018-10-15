@POST
Feature: Post Country

  Scenario Outline: Send a create country request to the server and validate the response
    When I send an insert country request to the server "<name>" "<alpha2_code>" "<alpha3_code>"
    Then the status code is 201
    Examples:
      |  name  			| alpha2_code |  alpha3_code |
      |  Test_country   | TC		  |  TCY 		 | 


  