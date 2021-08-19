package com.meedra.service;

import com.google.gson.Gson;
import com.meedra.config.EncryptorConfig;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class PanAccountEncryptorService {

    @Autowired
    EncryptorConfig encryptorConfig;

    @Autowired
    Gson gson;


    public HashMap<String, Object> encryptPanOrAccount(HashMap<String, String> panAccountMap) {
        HashMap<String, Object> encryptedMap;
        HashMap<String, Object> newEncryptedMap = new HashMap<>();

        String url = encryptorConfig.getUrl();
        String userName = encryptorConfig.getUserName();
        String password = encryptorConfig.getPassword();
        String payload = gson.toJson(panAccountMap);


        Client client = Client.create();
        WebResource resource = client.resource(url);

        String authStr = userName + ":" + password;
        String encoded = Base64.getEncoder().withoutPadding().encodeToString(authStr.getBytes());


        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                .header("Content-type", "application/json")
                .header("Authorization", "Basic " + encoded)
                .post(ClientResponse.class, payload);

        String jsonResponse = response.getEntity(String.class);
        //System.out.println("Json Response " + jsonResponse);
        encryptedMap = gson.fromJson(jsonResponse, HashMap.class);

        for (Object o : encryptedMap.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            newEncryptedMap.put(mapElement.getKey().toString().replace("_hash", ""), mapElement.getValue());
        }

//        System.out.println("input" + panAccountMap);
//        System.out.println("output" +  newEncryptedMap);


        return newEncryptedMap;


    }


}
