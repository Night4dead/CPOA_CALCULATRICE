package com.iut.as2021.controller;


import com.iut.as2021.metiers.Expression;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class ExpressionController extends ActionSupport {
    private String expression;
    private String expRes;
    private Expression expClass;
    private String error;



    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression){
        this.expression = expression;
        try {
            setExpClass(new Expression(this.expression));
        } catch ( Exception e){
            setError(e.getMessage());
        }
    }

    public String getExpRes() {
        if (this.error!=null){
            return this.error;
        }
        return expRes;
    }

    public void setExpRes(String exp) {
        try{
            this.expRes = String.valueOf(this.expClass.getValue());
        } catch (Exception e){
            setError(e.getMessage());
        }
    }

    public Expression getExpClass() {
        return expClass;
    }

    public void setExpClass(Expression exp_class) {
        this.expClass = exp_class;
        setExpRes("");
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
