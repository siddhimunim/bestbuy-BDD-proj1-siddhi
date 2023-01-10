package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.ProductSteps;
import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class bestbuyProductEndPointSteps {
    static int id;
    static String name = "Dyson hoover ";
    static String type = "Electronics";
    static int price = 300;
    static int shipping = 15;
    static String upc = "012345";
    static String description = "Compatible with select electronic devices and plugs";
    static String manufacturer = "Dyson Company";
    static String model = "MN254z";
    static String url = "http://www.Dyson.com";
    static String image = "http://www.Dyson.com/image";

    static ValidatableResponse response;
    //This is endpoint for Product Api
    @Steps
    ProductSteps productSteps;


    @When("^User sends a GET request to products endpoint$")
    public void userSendsAGETRequestToProductsEndpoint() {
        response = productSteps.getAllProductInfo();
    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }


    @When("^User sends a POST request by providing the information to products endpoint$")
    public void userSendsAPOSTRequestByProvidingTheInformationNameTypePricePriceShippingShippingUpcDescriptionManufacturerModelUrlImageToProductsEndpoint() {
        response = productSteps.createProduct(name, type, price,
                shipping, upc, description, manufacturer, model, url, image);
        id = response.extract().path("id");
    }

    @Then("^User must get back valid status code 201$")
    public void userMustGetBackValidStatusCode() {
        response.statusCode(201);
    }

    @When("^User sends a PUT request by providing the information to products/id endpoint$")
    public void userSendsAPUTRequestByProvidingTheInformationNameTypePriceShippingUpcDescriptionManufacturerModelUrlImageToProductsEndpoint(){
        name = TestUtils.getRandomValue()+name;
        response = productSteps.updateProduct(id,name, type, price,
                shipping, upc, description, manufacturer, model, url, image).log().all();
    }

    @Then("^User get back valid status code 200$")
    public void userGetBackValidStatusCode() {
        response.statusCode(200);

    }
    @When("^User sends a DELETE request to products/id endpoint$")
    public void userSendsADELETERequestToProductsIdEndpoint() {
        response = productSteps.deleteProduct(id);
    }


    @Then("^User get back a valid status code 200$")
    public void userGetBackAValidStatusCode() {
        response.statusCode(200);

    }

}

