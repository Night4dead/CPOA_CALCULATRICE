package com.iut.as2021.controller;


import com.iut.as2021.controller.facade.CalculatriceManager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class CalculatriceController extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CalculatriceController.class);

    private String expression;
    private String expRes;
    private String error;

    private static final String APPLICATION_CONTEXT_FILE = "applicationContext.xml";


    private CalculatriceManager calculatriceManager;

    public CalculatriceController(){
        ClassPathResource cp = new ClassPathResource(APPLICATION_CONTEXT_FILE);
        XmlBeanFactory factory = new XmlBeanFactory(cp);
        this.calculatriceManager = (CalculatriceManager) factory.getBean("calculatriceManager");
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
            expRes = calculatriceManager.calculer(this.expression);
            calculatriceManager.saveResult();
            return Action.SUCCESS;
        } catch (Exception e){
            logger.error(e.getMessage());
            setError(e.getMessage());
            return Action.ERROR;
        }
    }
}
