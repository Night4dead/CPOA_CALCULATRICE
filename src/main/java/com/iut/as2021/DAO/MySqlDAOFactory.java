package com.iut.as2021.DAO;

public class MySqlDAOFactory extends DAOFactory{

    @Override
    public IDAOExpression getDAOExpression() {
        return MySqlExpressionDAO.getDAOInstance();
    }
}
