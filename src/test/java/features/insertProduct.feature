Feature: insert products using post api
  Scenario Outline: validate post api works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of the products in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response code as 200