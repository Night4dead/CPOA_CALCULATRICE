package com.iut.as2021.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "historique")
public class EntityExpression implements Serializable {
    public EntityExpression(){}

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "expression")
    private String expression;

    @Override
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }
        if (!(objet instanceof EntityExpression)) {
            return false;
        }
        EntityExpression other = (EntityExpression) objet;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
