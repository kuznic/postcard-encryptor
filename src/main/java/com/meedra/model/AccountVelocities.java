package com.meedra.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Table(name = "pc_account_velocities", indexes = {
        @Index(name = "ix_pc_acc_vel_1", columnList = "accountId, accountType, issuerNr", unique = true),
        @Index(name = "ix_pc_acc_vel_2", columnList = "issuerNr")
}, uniqueConstraints = {
        @UniqueConstraint(name = "DF__pc_accoun__accou__208CD6FA", columnNames = {"accountType"})
})

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Getter
@Setter
@ToString

@NamedStoredProcedureQuery(name = "AccountVelocities.sp_isw_postcard_enc_update_pc_account_velocities",
        procedureName = "sp_isw_postcard_enc_update_pc_account_velocities", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type= String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "encAccountId", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "recordsCount", type = Integer.class)

})
public class AccountVelocities implements Serializable {
   private static final long serialVersionUID = -5404284086098312834L;

   @EmbeddedId
   private AccountVelocitiesId accountVelocitiesId;

   @Column(name = "velocityNr", nullable = false, length = 3)
   private Integer d_velocityNr;

   @Column(name = "goodsNrTransTot", nullable = false, length = 4)
   private Integer e_goodsNrTransTot;

   @Column(name = "goodsTot", nullable = false,columnDefinition = "numeric(9)")
   private BigDecimal f_goodsTot;

   @Column(name = "goodsOfflineTot", nullable = false, columnDefinition = "numeric(9)")
   private BigDecimal g_goodsOfflineTot;

   @Column(name = "cashNrTransTot", nullable = false, length = 4)
   private Integer h_cashNrTransTot;

   @Column(name = "cashTot", nullable = false,columnDefinition = "numeric(9)")
   private BigDecimal i_cashTot;

   @Column(name = "cashOfflineTot", nullable = false,columnDefinition = "numeric(9)")
   private BigDecimal j_cashOfflineTot;

   @Column(name = "cnpTot",nullable = false,columnDefinition = "numeric(9)")
   private BigDecimal k_cnpTot;

   @Column(name = "cnpOfflineTot", nullable = false,columnDefinition = "numeric(9)")
   private BigDecimal l_cnpOfflineTotal;

   @Column(name = "depositTot", nullable = false,columnDefinition = "numeric(9)")
   private BigDecimal m_depositTot;

   @Column(name="weeklyVelocityNr" , length = 4)
   private Integer n_weeklyVelocityNr;

   @Column(name = "weeklyGoodsNrTransTot", length = 4)
   private Integer o_weeklyGoodsNrTransTot;

   @Column(name = "weeklyGoodsTot",columnDefinition = "numeric(9)")
   private BigDecimal p_weeklyGoodsTot;

   @Column(name = "weeklyGoodsOfflineTot", columnDefinition = "numeric(9)")
   private BigDecimal q_weeklyGoodsOfflineTot;

   @Column(name = "weeklyCashNrTransTot",length =  4)
   private Integer r_weeklyCashNrTransTot;

   @Column(name= "weeklyCashTot", columnDefinition = "numeric(9)")
   private BigDecimal s_weeklyCashTot;

   @Column(name = "weeklyCashOfflineTot", columnDefinition = "numeric(9)")
   private BigDecimal t_weeklyCashOfflineTot;

   @Column(name = "weeklyCnpTot", columnDefinition = "numeric(9)")
   private BigDecimal u_weeklyCnpTot;

   @Column(name = "weeklyCnpOfflineTot",columnDefinition = "numeric(9)")
   private BigDecimal v_weeklyCnpOfflineTot;

   @Column(name = "weeklyDepositTot", columnDefinition = "numeric(9)")
   private BigDecimal w_weeklyDepositTot;

   @Column(name = "monthlyVelocityNr", length = 4)
   private Integer x_monthlyVelocityNr;

   @Column(name = "monthlyGoodsNrTransTot", length = 4)
   private Integer  y_monthlyGoodsNrTransTot;

   @Column(name ="monthlyGoodsTot", columnDefinition = "numeric(9)")
   private BigDecimal z_monthlyGoodsTot;

   @Column(name = "monthlyGoodsOfflineTot", columnDefinition = "numeric(9)")
   private BigDecimal za_monthlyGoodsOfflineTot;

   @Column(name = "monthlyCashNrTransTot", length = 4)
   private Integer zb_monthlyCashNrTransTot;

   @Column(name ="monthlyCashTot", columnDefinition = "numeric(9)")
   private BigDecimal  zc_monthlyCashTot;

   @Column (name = "monthlyCashOfflineTot", columnDefinition = "numeric(9)")
   private BigDecimal zd_monthlyCashOfflineTot;

   @Column(name = "monthlyCnpTot", columnDefinition = "numeric(9)")
   private BigDecimal ze_monthlyCnpTot;

   @Column(name = "monthlyCnpOfflineTot" ,columnDefinition = "numeric(9)")
   private BigDecimal  zf_monthlyCnpOfflineTot;

   @Column(name = "monthlyDepositTot", columnDefinition = "numeric(9)")
   private BigDecimal zg_monthlyDepositTot;

   @Column(name = "paymntNrTransTot", length = 4)
   private Integer zh_paymntNrTransTot;

   @Column(name = "paymntTot", columnDefinition = "numeric(9)")
   private BigDecimal zi_paymntTot;

   @Column(name = "paymntOfflineTot", columnDefinition = "numeric(9)")
   private BigDecimal zj_paymntOfflineTot;

   @Column(name = "weeklyPaymntNrTransTot", length = 4)
   private Integer zk_weeklyPaymntNrTransTot;

   @Column(name = "weeklyPaymntTot", columnDefinition = "numeric(9)")
   private BigDecimal zl_weeklyPaymntTot;

   @Column(name= "weeklyPaymntOfflineTot", columnDefinition = "numeric(9)")
   private BigDecimal zm_weeklyPaymntOfflineTot;

   @Column(name = "monthlyPaymntNrTransTot", length = 4)
   private Integer zn_monthlyPaymntNrTransTot;

   @Column(name = "monthlyPaymntTot", columnDefinition = "numeric(9)")
   private BigDecimal zo_monthlyPaymntTot;

   @Column(name = "monthlyPaymntOfflineTot",columnDefinition = "numeric(9)")
   private BigDecimal zp_monthlyPaymntOfflineTot;

   @Column(name = "lastUpdatedDate",nullable = false,columnDefinition="datetime")
   private java.sql.Timestamp zq_lastUpdatedDate;


   @Override
   public int hashCode() {
      return 1747101152;
   }



}


