Feature: delete product using DELETE api
  Scenario Outline: validate delete product api status code works correctly
    Given i hit the url of delete product api
    When i pass the url of delete products in the request with <ProductNumber>
    Then I receive the response code as 200
    Examples:
    |ProductNumber|
    |3            |