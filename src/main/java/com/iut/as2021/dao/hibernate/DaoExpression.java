package com.iut.as2021.dao.hibernate;

import com.iut.as2021.dao.AbstractDao;
import com.iut.as2021.dao.entity.EntityExpression;
import com.iut.as2021.dao.interfaces.modele.IDaoExpression;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class DaoExpression extends AbstractDao<Integer, EntityExpression> implements IDaoExpression {
    @Override
    public EntityExpression readById(Integer id) {
        return null;
    }

    @Override
    public void deleteExpressionbyId(Integer id) {

    }

    @Override
    public EntityExpression getExpressionById(String id) {
        return null;
    }
}
