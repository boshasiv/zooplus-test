package domain;

import controllers.PetController;
import okhttp3.Response;

import java.io.IOException;

public class PetstoreClient {
    private PetController petController;

    public PetstoreClient withPetController(PetController petController){
        this.petController = petController;
        return this;
    }

    public Response getPetById(String id) throws IOException {
        return petController.getPetById(id);
    }
}
