package com.iut.as2021.DAO;

import com.iut.as2021.metiers.Expression;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public Expression getLast() throws Exception {
        Expression last = null;

        String sql = "select * from historique where id IN (select MAX(id) from historique);";

        Connection co = MySqlConnexion.getInstance().getSqlConnexion();

        PreparedStatement requete = co.prepareStatement(sql);
        ResultSet resSet = requete.executeQuery();
        if(resSet.next()){
            last = new Expression(resSet.getString("expression"));
            last.setId(resSet.getInt("id"));
        }
        return last;
    }

    @Override
    public Expression readById(int i) throws Exception {
        Expression exp = null;

        String sql = "select expression from historique where id =?;";

        Connection co = MySqlConnexion.getInstance().getSqlConnexion();

        PreparedStatement requete = co.prepareStatement(sql);
        requete.setInt(1, i);
        ResultSet resSet = requete.executeQuery();
        if(resSet.next()){
            exp = new Expression(resSet.getString("expression"));
            exp.setId(i);
        }
        return exp;
    }

    @Override
    public List<Expression> getAll() {
        return null;
    }

    @Override
    public boolean update(Expression object) throws Exception {
        String sql = "UPDATE historique set expression=? where id=?";

        Connection co = MySqlConnexion.getInstance().getSqlConnexion();

        PreparedStatement requete = co.prepareStatement(sql);
        requete.setString(1,object.getExpression());
        requete.setInt(object.getId(),2);

        int nbLignes = requete.executeUpdate();
        return nbLignes==1;
    }

    @Override
    public boolean create(Expression object) throws Exception {
        String sql = "INSERT INTO historique (expression) values (?)";

        Connection co = MySqlConnexion.getInstance().getSqlConnexion();

        PreparedStatement requete = co.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        requete.setString(1,object.getExpression());

        int nbLignes = requete.executeUpdate();
        ResultSet res = requete.getGeneratedKeys();
        if (res.next()){
            object.setId(res.getInt(1));
        }
        return nbLignes==1;
    }

    @Override
    public boolean delete(Expression object) throws Exception {
        String sql = "delete from historique where id=?";

        Connection co = MySqlConnexion.getInstance().getSqlConnexion();

        PreparedStatement requete = co.prepareStatement(sql);
        requete.setInt(1,object.getId());

        int nbLignes = requete.executeUpdate();
        return nbLignes==1;
    }
}
