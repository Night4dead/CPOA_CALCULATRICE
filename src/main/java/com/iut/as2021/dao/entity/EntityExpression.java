package com.iut.as2021.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entité de db avec hibernate, représentant une expression
 * */

@Entity
@Data
@Table(name = "historique")
public class EntityExpression implements Serializable {
    public EntityExpression(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
