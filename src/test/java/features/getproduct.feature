Feature: Get all products from the api
  Scenario: verify the get api for the products
    Given I hit the url of get products api endpoint
    When I pass the url of the products in the request
    Then I receive the response code as 200

  Scenario Outline: verify the rate of product is correct
    Given I hit the url of get products api endpoint
    When I pass the url of the products in the request
    Then I verify the rate of the first product is <FirstProductRate>
    Examples:
    |FirstProductRate|
    |3.9             |

