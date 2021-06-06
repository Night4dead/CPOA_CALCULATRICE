package com.iut.as2021.modele;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BoExpression {
    private Integer id;

    @Size(message = "{expression.expression.invalid")
    @NotEmpty(message = "Merci de rentrer une expression")
    private String exp;

    public String getExp() {
        return this.exp;
    }
}
