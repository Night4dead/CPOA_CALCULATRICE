package com.iut.as2021.dao.factory;

import static org.springframework.beans.factory.annotation.Autowire.BY_TYPE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import com.iut.as2021.dao.interfaces.modele.IDaoExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Configurable(preConstruction = true, autowire = BY_TYPE)
@Scope(SCOPE_PROTOTYPE)
public class DaoFactory extends DaoFactoryGeneric{
    @Autowired
    private IDaoExpression daoExpression;

    @Override
    public IDaoExpression getDaoExpression() {
        if (daoExpression == null) {
            logger.debug("'Dao utilisateur' est nul");
        }
        return daoExpression;
    }
}
