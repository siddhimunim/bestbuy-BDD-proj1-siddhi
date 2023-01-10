package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.model.StorePojo;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class bestbuyStoreEndPointSteps {
    static ValidatableResponse response;
    static int id;
    static String name = "Next";
    static String type = "Retail";
    static String address = "87 hanover street";
    static String address2 = "CV 287";
    static String city = "Coventry";
    static String state = "Midland";
    static String zip = "945455";
    static int lat = 85;
    static int lng = 4899;
    static String hours ="Mon: 10-8; Tue: 10-6; Wed: 10-9; Thurs: 10-9; Fri: 10-8; Sat: 10-9; Sun: 10-4";
    private StorePojo.Services services;
    @Steps
    StoreSteps storeSteps;
    @When("^User sends a GET request to stores endpoint$")
    public void userSendsAGETRequestToStoresEndpoint() {
        response = storeSteps.getAllStoreInfo();
    }

    @When("^User sends a POST request by providing the information to stores endpoint$")
    public void userSendsAPOSTRequestByProvidingTheInformationToStoresEndpoint() {
        response = storeSteps.createStore(name, type, address,address2, city, state, zip, lat, lng, hours,services);
        id = response.extract().path("id");
    }
    @Then("^User must get back valid status code 201 for post request$")
    public void userMustGetBackValidStatusCodeForPostRequest() {
        response.statusCode(201);
    }

    @When("^User sends a PUT request by providing the information to stores/id endpoint$")
    public void userSendsAPUTRequestByProvidingTheInformationToStoresIdEndpoint() {
        name = name + "_Updated";
        response = storeSteps.updateStore(id,name, type, address,address2, city, state, zip, lat, lng, hours,services);
    }

    @When("^User sends a DELETE request to stores/id endpoint$")
    public void userSendsADELETERequestToStoresIdEndpoint() {
        storeSteps.deleteStore(id);
    }


}
