package com.iut.as2021.facade;

import com.iut.as2021.dao.expression.IDAOExpression;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metiers.Expression;

public class CalculatriceManager {

    private IDAOExpression dao;
    private Expression calculatrice;

    public CalculatriceManager(IDAOExpression dao){
        this.dao = dao;
    }

    public String calculer(String expression) throws MathsExceptions {
        try{
            calculatrice = new Expression(expression);
            return String.valueOf(calculatrice.getValue());
        } catch (Exception e) {
            throw new MathsExceptions(e.getMessage());
        }
    }

    public boolean saveResult() throws Exception {
        return dao.create(this.calculatrice);
    }
}
