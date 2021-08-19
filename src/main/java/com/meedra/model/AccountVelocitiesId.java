package com.meedra.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AccountVelocitiesId implements Serializable {
    private static final long serialVersionUID = 6178295345462135300L;

    @Column(name = "issuerNr", nullable = false, length = 4)
    private Integer a_issuerNr;

    @Column(name = "accountId", nullable = false, columnDefinition = "varchar(66)")
    private String b_accountId;

    @Column(name = "accountType", nullable = false, columnDefinition = "varchar(3) default 'NIL'")
    private String c_accountType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountVelocitiesId that = (AccountVelocitiesId) o;

        if (!Objects.equals(a_issuerNr, that.a_issuerNr)) return false;
        if (!Objects.equals(b_accountId, that.b_accountId)) return false;
        return Objects.equals(c_accountType, that.c_accountType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a_issuerNr);
        result = 31 * result + (Objects.hashCode(b_accountId));
        result = 31 * result + (Objects.hashCode(c_accountType));
        return result;
    }
}