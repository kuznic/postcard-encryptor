package com.meedra.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ExtendedVelocitiesId implements Serializable {
    private static final long serialVersionUID = 6178295345462135300L;


    @Column(name = "issuerNr", nullable = false, length = 4)
    private Integer a_issuerNr;


    @Column(name = "pan", nullable = false, columnDefinition = "varchar(66)")
    private Integer b_pan;


    @Column(name = "seqNr", nullable = false, columnDefinition = "char(3) default 'NIL'")
    private String c_seqNr;


    @Column(name = "customerId", nullable = false, columnDefinition = "varchar(25) ")
    private String d_customerId;


    @Column(name = "accountId", nullable = false, columnDefinition = "varchar(66)")
    private String e_accountId;


    @Column(name = "accountType", nullable = false, columnDefinition = "varchar(3) ")
    private String f_accountType;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExtendedVelocitiesId that = (ExtendedVelocitiesId) o;

        if (!Objects.equals(a_issuerNr, that.a_issuerNr)) return false;
        if (!Objects.equals(b_pan, that.b_pan)) return false;
        if (!Objects.equals(c_seqNr, that.c_seqNr)) return false;
        if (!Objects.equals(d_customerId, that.d_customerId)) return false;
        if (!Objects.equals(e_accountId, that.e_accountId)) return false;
        return Objects.equals(f_accountType, that.f_accountType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a_issuerNr);
        result = 31 * result + (Objects.hashCode(b_pan));
        result = 31 * result + (Objects.hashCode(c_seqNr));
        result = 31 * result + (Objects.hashCode(d_customerId));
        result = 31 * result + (Objects.hashCode(e_accountId));
        result = 31 * result + (Objects.hashCode(f_accountType));
        return result;
    }
}