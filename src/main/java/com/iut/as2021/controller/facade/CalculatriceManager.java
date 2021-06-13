package com.iut.as2021.controller.facade;

import com.iut.as2021.controller.service.interfaces.IServiceExpression;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.exceptions.MathsTechnicalException;
import com.iut.as2021.metier.Expression;
import com.iut.as2021.modele.BoExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("calculatriceManager")
public class CalculatriceManager {

    private static final Logger logger = Logger.getLogger(CalculatriceManager.class);

    private String result;

    @Autowired
    private IServiceExpression serviceExpression;


    /**
     * Calcule une expression
     * */
    public String calculer(String expression) throws MathsExceptions {
        try{
            result = serviceExpression.calculate(expression);
            logger.info(expression+" = "+result);
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new MathsExceptions(e.getMessage());
        }
    }

    /**
     * Sauvegarde une expression
     * */
    public void saveExpression(BoExpression expression) throws MathsExceptions {
        try {
            serviceExpression.save(expression);
        } catch (Exception e){
            throw new MathsTechnicalException("Erreur technique lors de la sauvegarde de l'expression");
        }
    }

    /**
     * Supprime toute les expressions
     * */
    public void deleteAll(List<BoExpression> expressions) throws MathsExceptions {
        logger.info("-> suppressions des expressions");
        try {
            serviceExpression.deleteAll(expressions);
        } catch (Exception e) {
            throw new MathsTechnicalException(e.getMessage());
        }
    }


    /**
     * Récupère tout l'historique des expressions de la db
     * */
    public List<BoExpression> getExpressions() throws MathsExceptions {
        try {
            return serviceExpression.expressionList();
        } catch (Exception e){
            throw new MathsTechnicalException(e.getMessage());
        }
    }
}
