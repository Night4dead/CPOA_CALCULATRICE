package com.iut.as2021.dao.mysql;

import com.iut.as2021.dao.DAOFactory;
import com.iut.as2021.dao.expression.IDAOExpression;
import com.iut.as2021.dao.expression.MySqlExpressionDAO;

public class MySqlDAOFactory extends DAOFactory {

    @Override
    public IDAOExpression getDAOExpression() {
        return MySqlExpressionDAO.getDAOInstance();
    }
}
