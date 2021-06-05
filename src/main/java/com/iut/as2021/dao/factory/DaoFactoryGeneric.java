package com.iut.as2021.dao.factory;

import com.iut.as2021.dao.interfaces.modele.IDaoExpression;
import com.iut.as2021.enums.EPersistance;
import com.iut.as2021.exceptions.MathsTechnicalException;
import org.apache.log4j.Logger;

public abstract class DaoFactoryGeneric {
    protected static Logger logger = Logger.getLogger(DaoFactoryGeneric.class);

    public static DaoFactoryGeneric getDaoInstance(EPersistance persistance) throws MathsTechnicalException {
        switch (persistance) {
            case MYSQL:
                return new DaoFactoryMySql();
            case HIBERNATE:
                return new DaoFactory();
            default:
                throw new MathsTechnicalException("Instance de type " + persistance.name() + " impossible à créer ...");
        }

    }

    public abstract IDaoExpression getDaoExpression();
}
