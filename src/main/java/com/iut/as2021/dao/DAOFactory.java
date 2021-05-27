package com.iut.as2021.dao;

import com.iut.as2021.dao.expression.IDAOExpression;
import com.iut.as2021.dao.mysql.MySqlDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory getDAOFactory(ETypeDAO cible){
        DAOFactory daoF = null;
        switch (cible){
            case MYSQL:
                daoF = new MySqlDAOFactory();
                break;
        }
        return daoF;
    }

    public abstract IDAOExpression getDAOExpression();
}
