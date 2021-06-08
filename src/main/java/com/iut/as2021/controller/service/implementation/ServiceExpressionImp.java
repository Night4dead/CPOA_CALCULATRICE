package com.iut.as2021.controller.service.implementation;

import com.iut.as2021.controller.facade.DtoFacadeManager;
import com.iut.as2021.controller.service.interfaces.IServiceExpression;
import com.iut.as2021.dao.entity.EntityExpression;
import com.iut.as2021.dao.factory.DaoFactoryGeneric;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.exceptions.MathsTechnicalException;
import com.iut.as2021.metier.Expression;
import com.iut.as2021.modele.BoExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceExpressionImp implements IServiceExpression {

    private static Logger logger = Logger.getLogger(ServiceExpressionImp.class);

    @Autowired
    private DaoFactoryGeneric daofg;

    @Autowired
    private DtoFacadeManager dto;

    @Override
    public void setDao(DaoFactoryGeneric daoFactoryGeneric) throws MathsExceptions {
        if(daofg == null){
            throw new MathsTechnicalException("[Attention la Dao de type 'Factory Generic' est null ... ]");
        }
        this.daofg = daoFactoryGeneric;
    }

    @Override
    public void setDto(DtoFacadeManager dtoManager) throws MathsExceptions {
        if(dto == null){
            throw new MathsTechnicalException("[Attention le DTO manager est null ... ]");
        }
        this.dto = dtoManager;
    }

    @Override
    public String calculate(String expression) throws MathsExceptions {
        logger.info("************* Calcul de l'expression : "+ expression);
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(100);
        return df.format((new Expression(expression)).getValue());
    }

    @Override
    public void save(BoExpression expression) throws MathsExceptions {
        logger.info("************* Sauvegarde de l'expression");
        EntityExpression entityExpression = dto.getDtoExpression().unAdapt(expression);
        if (expression.isNew()){
            daofg.getDaoExpression().persist(entityExpression);
        } else {
            daofg.getDaoExpression().update(entityExpression);
        }
    }

    @Override
    public void deleteAll(List<BoExpression> expressionList) throws MathsExceptions {
        logger.info("*********** Suppressions des expressions");
        for (BoExpression entity : expressionList){
            daofg.getDaoExpression().deleteExpressionbyId(entity.getId());
        }
    }

    @Override
    public List<BoExpression> expressionList() throws MathsExceptions {
        List<BoExpression> expressionList = new ArrayList<>();
        for (EntityExpression entity : daofg.getDaoExpression().getList()){
            expressionList.add(dto.getDtoExpression().adapt(entity));
        }
        logger.info("************ Récupération des expressions, nb : "+expressionList.size());
        return expressionList;
    }


}
