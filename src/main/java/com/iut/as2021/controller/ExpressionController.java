package com.iut.as2021.controller;


import com.iut.as2021.metiers.Expression;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class ExpressionController extends ActionSupport {
    private String expression;
    private String expRes;
    private String error;



    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression){
        this.expression = expression;
        try {
            this.expRes = String.valueOf((new Expression(this.expression)).getValue());
        } catch ( Exception e){
            setError(e.getMessage());
        }
    }

    public String getExpRes() {
        return expRes;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String execute(){

        return Action.SUCCESS;
    }

}
