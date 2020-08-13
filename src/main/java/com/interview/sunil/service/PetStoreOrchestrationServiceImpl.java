package com.interview.sunil.service;

import com.interview.sunil.swagger.model.Pet;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;


public class PetStoreOrchestrationServiceImpl implements PetStoreOrchestrationService {

    RestTemplate restTemplate;
    private String resouceURL;

    public PetStoreOrchestrationServiceImpl(){
        restTemplate = new RestTemplate();
        resouceURL = "https://petstore.swagger.io/v2/pet/findByStatus";
    }

    @Override
    public List<Pet> invokeFindByStatus(Pet.StatusEnum status) {
        ResponseEntity<Pet[]> response;
        Pet[] pets = null;
        List<Pet> petList = null;

        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> entity = new HttpEntity<>(headers);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(resouceURL)
                    .queryParam("status", status);

            response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Pet[].class);

            pets = response.getBody();
            if(pets != null){
                petList = Arrays.asList(pets);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return petList;
    }
}
