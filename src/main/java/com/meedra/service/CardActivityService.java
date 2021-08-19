package com.meedra.service;


import com.google.gson.Gson;
import com.meedra.config.EncryptorConfig;
import com.meedra.repository.CardActivityRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
@Service
public class CardActivityService {

    @Autowired
    Gson gson;
    @Autowired
    private CardActivityRepository cardActRepo;
    @Autowired
    private EncryptorConfig encConfig;

    public HashMap fetchCards() {
        HashMap<String, String> cardMap = new LinkedHashMap<>();
        int issuer_nr = encConfig.getIssuerNumbers();
        List<String> cards = cardActRepo.getAllCards(issuer_nr);

        if (cards.isEmpty()) {
            log.error("No records found!");
        }

        for (String s : cards) {
            cardMap.put(s, s);
        }

        return cardMap;
    }


    @Modifying
    public void updateCards(HashMap<String, Object> encCardIdsMap) throws Exception {
        int numberOfRecordsUpdated = 0;

        for (Object o : encCardIdsMap.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;

            val cardToBeUpdated = cardActRepo.fetchPan(mapElement.getKey().toString());
            if (cardToBeUpdated == null) {
                throw new Exception("No record found for CardId " + mapElement.getKey().toString());
            }

            numberOfRecordsUpdated = cardActRepo
                    .updateCardActivityRecord (mapElement.getKey().toString(), mapElement.getValue().toString()) + numberOfRecordsUpdated;


            log.info("number of records updated for Issuer " + encConfig.getIssuerNumbers() + " is " + numberOfRecordsUpdated);


        }

    }


}





















































