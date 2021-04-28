package com.iut.as2021.DAO;

import com.iut.as2021.metiers.Expression;

import java.util.List;

public class MySqlDAO implements IDAOExpression{
    @Override
    public Expression readById(int i) {
        return null;
    }

    @Override
    public List<Expression> getAll() {
        return null;
    }

    @Override
    public boolean update(Expression object) {
        return false;
    }

    @Override
    public boolean create(Expression object) {
        return false;
    }

    @Override
    public boolean delete(Expression object) {
        return false;
    }
}
