package com.meedra.repository;

import com.meedra.model.CardActivity;
import com.meedra.model.CardActivityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Repository
public interface CardActivityRepository extends JpaRepository<CardActivity, CardActivityId>
{
    @Query(value = "select  pan from pc_card_activity (nolock) where issuer_nr = :issuerNr and len(pan) < 20", nativeQuery = true)
    List<String> getAllCards(@Param("issuerNr") int issuerNr);

    @Query(value = "select distinct pan from pc_card_activity (nolock) where pan = :pan", nativeQuery = true)
    String fetchPan(@Param("pan") String pan);

    @Transactional
    @Procedure(name = "CardActivity.sp_isw_postcard_enc_update_pc_card_activity")
    int updateCardActivityRecord(@Param("pan") String pan, @Param("encPan") String encPan);


}