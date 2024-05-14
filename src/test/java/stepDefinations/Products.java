package stepDefinations;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Products {
    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody body;

    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the url of the products in the request")
    public void i_pass_the_url_of_the_proucts_in_the_request() {
        httpRequest = given();
        response = httpRequest.get("products");
    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {
        statusCode = response.getStatusCode();
        assertEquals(statusCode, 200);
    }

    @Then("I verify the rate of the first product is {}")
    public void i_verify_the_rate_of_the_first_product_is(String rate) {
        body = response.getBody();
        String ResponseBody = body.asString();
        JsonPath jsnpath = response.jsonPath();
        String s = jsnpath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate, s);

    }

    @Given("I hit the url of post product api endpoint")
    public void iHitTheUrlOfPostProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();
    }


    @And("^I pass the request body of product title (.*)$")
    public void iPassTheRequestBodyOfProductTitleProductTitle(String title) {
        JsonObject requestParams = new JsonObject();
        requestParams.add("title", "title");
        requestParams.add("price", "32.5");
        requestParams.add("description", "hgbds");
        requestParams.add("image", "https://google.com");
        requestParams.add("category", "electronics");
        httpRequest.body(requestParams.toString());
        response = httpRequest.post("products");
        body = response.getBody();
        System.out.println(response.getStatusCode());
        System.out.println(body.asString());


    }

    @Given("I hit the url of put product api endpoint")
    public void iHitTheUrlOfPutProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";

    }

    


    @And("I pass the request body of product")
    public void iPassTheRequestBodyOfProduct() {
    }

    @When("I pass the url of the products with {}")
    public void iPassTheUrlOfTheProductsWithProductNumber(String number) {
        httpRequest = given();

        JsonObject requestParams = new JsonObject();
        requestParams.add("title", "test product");
        requestParams.add("price", "32.5");
        requestParams.add("description", "hgbds");
        requestParams.add("image", "https://google.com");
        requestParams.add("category", "electronics");
        httpRequest.body(requestParams.toString());
        response= httpRequest.put("products/"+number);
        body = response.getBody();
        System.out.println(response.getStatusCode());
        System.out.println(body.asString());

    }

    @Given("i hit the url of delete product api")
    public void iHitTheUrlOfDeleteProductApi() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("i pass the url of delete products in the request with {}")
    public void iPassTheUrlOfDeleteProductsInTheRequestWithProductNumber(String number) {
        httpRequest = given();
        response= httpRequest.delete("products/"+number);
        body = response.getBody();
        System.out.println(response.getStatusCode());
        System.out.println(body.asString());
    }
}
