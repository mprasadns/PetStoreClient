package com.interview.sunil.client;

import com.interview.sunil.service.PetStoreOrchestrationService;
import com.interview.sunil.service.PetStoreOrchestrationServiceImpl;
import com.interview.sunil.swagger.model.Pet;
import com.interview.sunil.swagger.model.Pet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class PetStoreClientImpl implements PetStoreClient {


    PetStoreOrchestrationService orchestrationService;

    public PetStoreClientImpl(){
        orchestrationService = new PetStoreOrchestrationServiceImpl();
    }

    public PetStoreClientImpl(PetStoreOrchestrationService orchestrationService){
        this.orchestrationService = orchestrationService;
    }

    @Override
    public List<Pet> getPetsByStatus(StatusEnum givenStatus) {
        return orchestrationService.invokeFindByStatus(givenStatus);
    }
}
