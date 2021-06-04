package com.iut.as2021.controller;

import com.iut.as2021.facade.CalculatriceManager;
import com.opensymphony.xwork2.Action;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CalculatriceControllerSpring {

    private static final Logger logger = Logger.getLogger(CalculatriceControllerSpring.class);

    private String expression;
    private String expRes;
    private String error;

    @Autowired
    private CalculatriceManager calculatriceManager;

    /*public CalculatriceControllerSpring(CalculatriceManager calculatriceManager) {
        this.calculatriceManager=calculatriceManager;
    }*/


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

    public String calculate(){
        try {
            System.out.println("enter");
            System.out.println(calculatriceManager);
            logger.debug(calculatriceManager);
            expRes = calculatriceManager.calculer(this.expression);
            System.out.println(expRes);
            logger.debug(expRes);
            calculatriceManager.saveResult();
            return Action.SUCCESS;
        } catch (Exception e){
            logger.error(e.getMessage());
            setError(e.getMessage());
            return Action.ERROR;
        }
    }
}
