package com.iut.as2021.modele.dto;

import com.iut.as2021.dao.entity.EntityExpression;
import com.iut.as2021.dao.interfaces.IDtoGeneric;
import com.iut.as2021.metier.Expression;
import org.springframework.stereotype.Component;

@Component
public class DtoExpression implements IDtoGeneric<Expression, EntityExpression> {
    @Override
    public Expression adapt(EntityExpression object) {
        return null;
    }

    @Override
    public Expression adaptById(Integer id) {
        return null;
    }

    @Override
    public EntityExpression unAdapt(Expression object) {
        return null;
    }
}
