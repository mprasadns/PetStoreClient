package com.interview.sunil.client;

import com.interview.sunil.swagger.model.Pet;
import com.interview.sunil.swagger.model.Pet.*;

import java.util.List;

public interface PetStoreClient {
    List<Pet> getPetsByStatus(StatusEnum givenStatus);
}
