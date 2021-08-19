package com.meedra.service;


import com.google.gson.Gson;
import com.meedra.config.EncryptorConfig;
import com.meedra.repository.AccountVelocitiesRepository;
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
public class AccountVelocitiesService {

    @Autowired
    Gson gson;
    @Autowired
    private AccountVelocitiesRepository accountVeloRepo;
    @Autowired
    private EncryptorConfig encConfig;

    public HashMap fetchAccountIds() {
        HashMap<String, String> accountIdMap = new LinkedHashMap<>();
        int issuer_nr = encConfig.getIssuerNumbers();
        List<String> accountIds = accountVeloRepo.getAllAccountId(issuer_nr);

        if (accountIds.isEmpty()) {
            log.error("No records found!");
        }

        for (String s : accountIds) {
            accountIdMap.put(s, s);
        }

        return accountIdMap;
    }


    @Modifying
    public void updateAccountIds(HashMap<String, Object> encAccountIdsMap) throws Exception {
        int numberOfRecordsUpdated = 0;

        for (Object o : encAccountIdsMap.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;

            val accountVelRecordToBeUpdated = accountVeloRepo.fetchAccountVelRecord(mapElement.getKey().toString());
            if (accountVelRecordToBeUpdated == null) {
                throw new Exception("No record found for AccountId " + mapElement.getKey().toString());
            }

            numberOfRecordsUpdated = accountVeloRepo
                    .updateAccountVelocityRecord(mapElement.getKey().toString(), mapElement.getValue().toString()) + numberOfRecordsUpdated;


            log.info("number of records updated for Issuer " + encConfig.getIssuerNumbers() + " is " + numberOfRecordsUpdated);


        }

    }


}
