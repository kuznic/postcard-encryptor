package com.meedra.repository;

import com.meedra.model.ExtendedVelocities;
import com.meedra.model.ExtendedVelocitiesId;
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
public interface ExtendedVelocitiesRepository extends JpaRepository<ExtendedVelocities, ExtendedVelocitiesId>
{
    @Query(value = "select  pan from pc_extended_velocities (nolock) where issuer_nr = :issuerNr and len(pan) < 20", nativeQuery = true)
    List<String> getAllCards(@Param("issuerNr") int issuerNr);

    @Query(value = "select pan from pc_extended_velocities (nolock) where pan = :pan", nativeQuery = true)
    String fetchExtendedVelRecord(@Param("pan") String pan);

    @Transactional
    @Procedure(name = "ExtendedVelocities.sp_isw_postcard_enc_update_pc_extended_velocities")
    int updateExtendedVelocityRecord(@Param("pan") String pan, @Param("encPan") String encPan);


}