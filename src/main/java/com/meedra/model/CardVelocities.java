package com.meedra.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Table(name = "pc_card_velocities", indexes = {
        @Index(name = "ix_crd_velcities_1", columnList = "pan, seqNr, issuerNr", unique = true),
        @Index(name = "ix_crd_velcities_2", columnList = "issuerNr")
}, uniqueConstraints = {
        @UniqueConstraint(name = "DF__pc_card_v__seq_n__151B244E", columnNames = {"seqNr"})
})

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Getter
@Setter
@ToString

@NamedStoredProcedureQuery(name = "CardVelocities.sp_isw_postcard_enc_update_pc_card_velocities",
        procedureName = "sp_isw_postcard_enc_update_pc_card_velocities", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pan", type= String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "encPan", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "recordsCount", type = Integer.class)

})
public class CardVelocities implements Serializable {
   private static final long serialVersionUID = -5404284086098312834L;

   @EmbeddedId
   private CardVelocitiesId cardVelocitiesId;

   @Column(name = "velocityNr", nullable = false, length = 3)
   private Integer d_velocityNr;

   @Column(name = "goodsNrTransTot", nullable = false, length = 4)
   private Integer e_goodsNrTransTot;

   @Column(name = "goodsTot", nullable = false,length = 9,columnDefinition = "numeric(12)")
   private BigDecimal f_goodsTot;

   @Column(name = "goodsOfflineTot", nullable = false, columnDefinition = "numeric(12)")
   private BigDecimal g_goodsOfflineTot;

   @Column(name = "cashNrTransTot", nullable = false, length = 4)
   private Integer h_cashNrTransTot;

   @Column(name = "cashTot", nullable = false, columnDefinition = "numeric(12)")
   private BigDecimal i_cashTot;

   @Column(name = "cashOfflineTot", nullable = false,length = 9,columnDefinition = "numeric(12)")
   private BigDecimal j_cashOfflineTot;

   @Column(name = "cnpTot",nullable = false, columnDefinition = "numeric(12)")
   private BigDecimal k_cnpTot;

   @Column(name = "cnpOfflineTot", nullable = false, columnDefinition = "numeric(12)")
   private BigDecimal l_cnpOfflineTotal;

   @Column(name = "depositTot", nullable = false, columnDefinition = "numeric(12)")
   private BigDecimal m_depositTot;

   @Column(name="weeklyVelocityNr" , length = 4)
   private Integer n_weeklyVelocityNr;

   @Column(name = "weeklyGoodsNrTransTot", length = 4)
   private Integer o_weeklyGoodsNrTransTot;

   @Column(name = "weeklyGoodsTot", columnDefinition = "numeric(12)")
   private BigDecimal p_weeklyGoodsTot;

   @Column(name = "weeklyGoodsOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal q_weeklyGoodsOfflineTot;

   @Column(name = "weeklyCashNrTransTot",length =  4)
   private Integer r_weeklyCashNrTransTot;

   @Column(name= "weeklyCashTot", columnDefinition = "numeric(12)")
   private BigDecimal s_weeklyCashTot;

   @Column(name = "weeklyCashOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal t_weeklyCashOfflineTot;

   @Column(name = "weeklyCnpTot", columnDefinition = "numeric(12)")
   private BigDecimal u_weeklyCnpTot;

   @Column(name = "weeklyCnpOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal v_weeklyCnpOfflineTot;

   @Column(name = "weeklyDepositTot", columnDefinition = "numeric(12)")
   private BigDecimal w_weeklyDepositTot;

   @Column(name = "monthlyVelocityNr", length = 4)
   private Integer x_monthlyVelocityNr;

   @Column(name = "monthlyGoodsNrTransTot", length = 4)
   private Integer  y_monthlyGoodsNrTransTot;

   @Column(name ="monthlyGoodsTot", columnDefinition = "numeric(12)")
   private BigDecimal z_monthlyGoodsTot;

   @Column(name = "monthlyGoodsOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal za_monthlyGoodsOfflineTot;

   @Column(name = "monthlyCashNrTransTot", length = 4)
   private Integer zb_monthlyCashNrTransTot;

   @Column(name ="monthlyCashTot", columnDefinition = "numeric(12)")
   private BigDecimal  zc_monthlyCashTot;

   @Column (name = "monthlyCashOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal zd_monthlyCashOfflineTot;

   @Column(name = "monthlyCnpTot", columnDefinition = "numeric(12)")
   private BigDecimal ze_monthlyCnpTot;

   @Column(name = "monthlyCnpOfflineTot" , columnDefinition = "numeric(12)")
   private BigDecimal  zf_monthlyCnpOfflineTot;

   @Column(name = "monthlyDepositTot", columnDefinition = "numeric(12)")
   private BigDecimal zg_monthlyDepositTot;

   @Column(name = "paymntNrTransTot", length = 4)
   private Integer zh_paymntNrTransTot;

   @Column(name = "paymntTot", columnDefinition = "numeric(12)")
   private BigDecimal zi_paymntTot;

   @Column(name = "paymntOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal zj_paymntOfflineTot;

   @Column(name = "weeklyPaymntNrTransTot", length = 4)
   private Integer zk_weeklyPaymntNrTransTot;

   @Column(name = "weeklyPaymntTot", columnDefinition = "numeric(12)")
   private BigDecimal zl_weeklyPaymntTot;

   @Column(name= "weeklyPaymntOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal zm_weeklyPaymntOfflineTot;

   @Column(name = "monthlyPaymntNrTransTot", length = 4)
   private Integer zn_monthlyPaymntNrTransTot;

   @Column(name = "monthlyPaymntTot", columnDefinition = "numeric(12)")
   private BigDecimal zo_monthlyPaymntTot;

   @Column(name = "monthlyPaymntOfflineTot", columnDefinition = "numeric(12)")
   private BigDecimal zp_monthlyPaymntOfflineTot;

   @Column(name = "lastUpdatedDate",nullable = false,columnDefinition="datetime")
   private java.sql.Timestamp zq_lastUpdatedDate;


   @Override
   public int hashCode() {
      return 1747101152;
   }



}



