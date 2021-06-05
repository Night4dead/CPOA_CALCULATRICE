package com.iut.as2021.controller.facade;

import com.iut.as2021.dao.expression.IDAOExpression;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metiers.Expression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("calculatriceManager")
public class CalculatriceManager {

    private static final Logger logger = Logger.getLogger(CalculatriceManager.class);


    private IDAOExpression dao;
    private Expression calculatrice;

    @Autowired
    public CalculatriceManager(IDAOExpression dao){
        this.dao = dao;
    }


    public String calculer(String expression) throws MathsExceptions {
        try{
            calculatrice = new Expression(expression);
            logger.info("Manager: result: "+calculatrice.getValue());
            return String.valueOf(calculatrice.getValue());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MathsExceptions(e.getMessage());
        }
    }

    public boolean saveResult() throws Exception {
        return dao.create(this.calculatrice);
    }
}
