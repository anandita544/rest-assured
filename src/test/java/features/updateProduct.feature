Feature: update products using put api
  Scenario Outline: validate put api works correctly
    Given I hit the url of put product api endpoint
    When I pass the url of the products with <ProductNumber>
    And I pass the request body of product
    Then I receive the response code as 200
    Examples:
    |ProductNumber |
    |2             |