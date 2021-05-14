package com.iut.as2021.DAO;

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
