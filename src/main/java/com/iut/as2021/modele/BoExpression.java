package com.iut.as2021.modele;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Business Object
 * */
public class BoExpression {
    private Integer id;
    
    @Size(message = "{expression.expression.invalid")
    @NotEmpty(message = "Merci de rentrer une expression")
    private String exp;

    /**
     * Résultat d'une expression
     * */
    private String res;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public boolean isNew(){return (id==null);}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getExp() {
        return this.exp;
    }
}
