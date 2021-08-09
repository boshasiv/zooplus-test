package controllers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class PetController {
    private String getPetUrl;
    private OkHttpClient client = new OkHttpClient();

    public PetController (String getPetUrl){
        this.getPetUrl = getPetUrl;
    }

    public Response getPetById(String id) throws IOException{
        Request request = new Request.Builder()
                .url(getPetUrl + id)
                .addHeader("accept", "application/json")
                .build();
        return client.newCall(request).execute();
    }

}
