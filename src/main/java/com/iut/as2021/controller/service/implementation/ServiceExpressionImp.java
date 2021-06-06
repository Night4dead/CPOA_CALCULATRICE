package com.iut.as2021.controller.service.implementation;

import com.iut.as2021.controller.facade.DtoFacadeManager;
import com.iut.as2021.controller.service.interfaces.IServiceExpression;
import com.iut.as2021.dao.factory.DaoFactoryGeneric;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.Expression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceExpressionImp implements IServiceExpression {

    private static Logger logger = Logger.getLogger(ServiceExpressionImp.class);

    @Autowired
    private DaoFactoryGeneric daofg;

    @Autowired
    private DtoFacadeManager dto;

    @Override
    public String calculate(String expression) throws MathsExceptions {
        return String.valueOf((new Expression(expression)).getValue());
    }
}
