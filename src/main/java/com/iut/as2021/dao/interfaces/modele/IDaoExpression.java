package com.iut.as2021.dao.interfaces.modele;

import com.iut.as2021.dao.entity.EntityExpression;
import com.iut.as2021.dao.interfaces.IDaoGeneric;

public interface IDaoExpression extends IDaoGeneric<EntityExpression> {
    void deleteExpressionbyId(Integer id);

}
