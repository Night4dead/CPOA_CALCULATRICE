package com.iut.as2021.DAO;

import com.iut.as2021.metiers.Expression;

import java.util.List;

public class MySqlExpressionDAO implements IDAOExpression{

    private static MySqlExpressionDAO instance;

    private MySqlExpressionDAO(){}

    public static MySqlExpressionDAO getDAOInstance(){
        if(instance == null){
            instance = new MySqlExpressionDAO();
        }
        return instance;
    }

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
