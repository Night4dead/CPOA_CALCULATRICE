package com.iut.as2021.controller;


import com.iut.as2021.facade.CalculatriceManager;
import com.iut.as2021.metiers.Expression;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class CalculatriceController extends ActionSupport {
    private String expression;
    private String expRes;
    private String error;

    private CalculatriceManager manager;

    public CalculatriceController(){
        this.manager = new CalculatriceManager();
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
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
        try {
            expRes = manager.calculer(this.expression);
            manager.saveResult();
            return Action.SUCCESS;
        } catch (Exception e){
            setError(e.getMessage());
            return Action.ERROR;
        }
    }
}
