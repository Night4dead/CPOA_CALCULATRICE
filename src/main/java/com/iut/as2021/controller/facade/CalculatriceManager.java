package com.iut.as2021.controller.facade;

import com.iut.as2021.controller.service.interfaces.IServiceExpression;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.Expression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("calculatriceManager")
public class CalculatriceManager {

    private static final Logger logger = Logger.getLogger(CalculatriceManager.class);

    private String result;

    @Autowired
    private IServiceExpression serviceExpression;

    public String calculer(String expression) throws MathsExceptions {
        logger.info("--> calcul de l'expression : "+expression);
        try{
            result = serviceExpression.calculate(expression);
            logger.info("Manager: result: "+result);
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MathsExceptions(e.getMessage());
        }
    }

}
