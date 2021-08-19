package com.meedra.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Table(name = "pc_card_activity",  indexes = {
        @Index(name = "ix_card_activity_1", columnList = "pan, seqNr, tranLocalDatetime"),
        @Index(name = "ix_card_activity_2", columnList = "tranLocalDatetime")
}, uniqueConstraints = {
        @UniqueConstraint(name = "DF__pc_card_a__seq_n__498EEC8D", columnNames = { "seqNr"})
})

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Getter
@Setter
@ToString

@NamedStoredProcedureQuery(name = "CardActivity.sp_isw_postcard_enc_update_pc_card_activity",
        procedureName = "sp_isw_postcard_enc_update_pc_card_activity", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pan", type= String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "encPan", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "recordsCount", type = Integer.class)

})
public class CardActivity implements Serializable {
    private static final long serialVersionUID = -5404284086098312834L;

   @EmbeddedId
   private CardActivityId cardActivityId;

    @Column(name = "tranType", nullable = false, columnDefinition = "char(3)")
    private String d_tranType;

    @Column(name = "tranCurrencyCode",  columnDefinition = "char(3)")
    private String e_tranCurrencyCode;

    @Column(name = "tranAmount", nullable = false,columnDefinition = "numeric(9)")
    private BigDecimal f_tranAmount;

    @Column(name = "tranLocalDatetime", nullable = false,columnDefinition="datetime(8)" )
    private  java.sql.Timestamp g_tranLocalDatetime;

    @Column(name = "extendedTranType", columnDefinition = "char(4)")
    private String h_extendedTranTyp;

    @Column(name = "tranRefNr", columnDefinition = "varchar(49)")
    private String i_tranRefNr;



    @Override
    public int hashCode() {
        return 1747101152;
    }



}