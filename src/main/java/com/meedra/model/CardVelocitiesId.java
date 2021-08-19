package com.meedra.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
public class CardVelocitiesId implements Serializable {
    private static final long serialVersionUID = 6178295345462135300L;

    @Column(name = "issuerNr", nullable = false, length = 4)
    private Integer a_issuerNr;

    @Column(name = "pan", nullable = false, columnDefinition = "varchar(66)")
    private Integer b_pan;

    @Column(name = "seqNr", nullable = false, columnDefinition = "char(3) default 'NIL'")
    private String c_seqNr;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardVelocitiesId that = (CardVelocitiesId) o;

        if (!Objects.equals(a_issuerNr, that.a_issuerNr)) return false;
        if (!Objects.equals(b_pan, that.b_pan)) return false;
        return Objects.equals(c_seqNr, that.c_seqNr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a_issuerNr);
        result = 31 * result + (Objects.hashCode(b_pan));
        result = 31 * result + (Objects.hashCode(c_seqNr));
        return result;
    }
}