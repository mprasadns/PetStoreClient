package com.interview.sunil.service;

import com.interview.sunil.swagger.model.Pet;
import com.interview.sunil.swagger.model.Pet.*;

import java.util.List;

public interface PetStoreOrchestrationService {
    List<Pet> invokeFindByStatus(StatusEnum capture);
}
