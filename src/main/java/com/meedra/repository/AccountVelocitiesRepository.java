package com.meedra.repository;

import com.meedra.model.AccountVelocities;
import com.meedra.model.AccountVelocitiesId;
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
public interface AccountVelocitiesRepository extends JpaRepository<AccountVelocities, AccountVelocitiesId>
{
    @Query(value = "select  account_id from pc_account_velocities (nolock) where issuer_nr = :issuerNr and len(account_id) < 20", nativeQuery = true)
    List<String> getAllAccountId(@Param("issuerNr") int issuerNr);

    @Query(value = "select * from pc_account_velocities (nolock) where account_id = :accountId", nativeQuery = true)
    AccountVelocities fetchAccountVelRecord(@Param("accountId") String accountId);

    @Transactional
    @Procedure(name = "AccountVelocities.sp_isw_postcard_enc_update_pc_account_velocities")
    int updateAccountVelocityRecord(@Param("accountId") String accountId, @Param("encAccountId") String encAccountId);


}