package com.interview.sunil.acceptance;

import com.interview.sunil.client.PetStoreClient;
import com.interview.sunil.client.PetStoreClientImpl;
import com.interview.sunil.swagger.model.Pet;
import com.interview.sunil.swagger.model.Pet.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class PetStoreStepDefinitions {

    private List<Pet> petList;

    @Given("^I have the status as (.*) for the Pets list$")
    public void i_have_the_status_of_the_pet_availability(String status) {
        assertTrue(!Objects.isNull(status));

    }

    @When("I request the list of Pets with the status (.*)$")
    public void i_request_the_list_of_pets(String status) {
        PetStoreClient petStoreClient = new PetStoreClientImpl();
        StatusEnum givenStatus = StatusEnum.fromValue(status.toLowerCase());
        petList = petStoreClient.getPetsByStatus(givenStatus);
    }

    @Then("I should have list of all the Pets based on the status (.*)$")
    public void i_should_have_list_of_all_the_pets(String status) {
        assertNotNull(petList);
        List<Pet> doggieList = new ArrayList<>();
        for(Pet pet: petList){
            if(pet.getName() != null && pet.getName().equals("doggie")){
                doggieList.add(pet);
            }
        }
        if(doggieList != null) {
            for (Pet pet : doggieList) {
                assertEquals(pet.getName(), "doggie");
                assertEquals(pet.getStatus().name(), status.toUpperCase());
            }
        }
    }


}
