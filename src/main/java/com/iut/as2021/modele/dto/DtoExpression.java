package com.iut.as2021.modele.dto;

import com.iut.as2021.dao.entity.EntityExpression;
import com.iut.as2021.dao.interfaces.IDtoGeneric;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.Expression;
import com.iut.as2021.modele.BoExpression;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class DtoExpression implements IDtoGeneric<BoExpression, EntityExpression> {

    /**
     * Convertis un objet entité de db en Business Object
     * */
    @Override
    public BoExpression adapt(EntityExpression object) throws MathsExceptions {
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(100);
        if(object != null){
            BoExpression expression = new BoExpression();
            expression.setId(object.getId());
            expression.setExp(object.getExpression());
            expression.setRes(df.format((new Expression(object.getExpression())).getValue()));
            return expression;
        }
        return null;
    }

    @Override
    public BoExpression adaptById(Integer id) {
        BoExpression expression = new BoExpression();
        expression.setId(id);
        return expression;
    }


    /**
     * Convertit un Business Object en entité de db
     * */
    @Override
    public EntityExpression unAdapt(BoExpression object) {
        EntityExpression entityExpression = new EntityExpression();
        if (!object.isNew()){
            entityExpression.setId(object.getId());
        }
        entityExpression.setExpression(object.getExp());
        return entityExpression;
    }
}
