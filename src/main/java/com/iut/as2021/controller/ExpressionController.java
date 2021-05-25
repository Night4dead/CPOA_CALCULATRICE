package com.iut.as2021.controller;


import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metiers.Expression;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class ExpressionController extends ActionSupport {
    private String expression;
    private String exp_res;
    private Expression exp_class;



    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression){
        this.expression = expression;
        try {
            setExp_class(new Expression(this.expression));
        } catch ( Exception e){
            setExpRes(e.getMessage());
        }
    }

    public String getExpRes() {
        return exp_res;
    }

    public void setExpRes(String exp) {
        if (this.exp_class!= null){
            try{
                this.exp_res = String.valueOf(this.exp_class.getValue());
            } catch (Exception e){
                this.exp_res= e.getMessage();
            }
        }
        else {
            this.exp_res = exp;
        }
        System.out.println(this.expression+"="+this.exp_res);
    }

    public Expression getExp_class() {
        return exp_class;
    }

    public void setExp_class(Expression exp_class) {
        this.exp_class = exp_class;
        setExpRes("");
    }

    public String execute(){
        return Action.SUCCESS;
    }
}
