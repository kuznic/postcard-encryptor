package com.meedra.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "pc_extended_velocities", indexes = {
        @Index(name = "pk_ext_vel", columnList = "issuerNr, pan, seqNr, customerId, accountId, accountType", unique = true)
}, uniqueConstraints = {
        @UniqueConstraint(name = "pk_ext_vel", columnNames = {"issuerNr", "pan", "seqNr", "customerId", "accountId", "accountType"})
})

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Getter
@Setter
@ToString

@NamedStoredProcedureQuery(name = "ExtendedVelocities.sp_isw_postcard_enc_update_pc_extended_velocities",
        procedureName = "sp_isw_postcard_enc_update_pc_extended_velocities", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pan", type= String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "encPan", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "recordsCount", type = Integer.class)

})
public class ExtendedVelocities implements Serializable {
    private static final long serialVersionUID = -5404284086098312834L;

   @EmbeddedId
   private ExtendedVelocitiesId extendedVelocitiesId;

   @Column(name = "velocityTotals", nullable = false, columnDefinition = "varchar(7000) ")
   private String g_velocityTotals;

    @Column(name = "lastUpdatedDate",nullable = false,columnDefinition="datetime")
    private java.sql.Timestamp h_lastUpdatedDate;


    @Override
    public int hashCode() {
        return 1747101152;
    }



}