package com.iut.as2021.main;


import com.iut.as2021.DAO.DAOFactory;
import com.iut.as2021.DAO.ETypeDAO;
import com.iut.as2021.metiers.Expression;

public class StartTestMaths {

	public static void main(String[] args) {


		try {
			Expression exp = new Expression("(1+2)-3+3");
			//System.out.println(exp+", left element : "+exp.getLeftExpression()+", right element : "+exp.getRightExpression().getExpression()+", ope : "+exp.getOpe());
			System.out.println(exp.getValue());
			DAOFactory daof = DAOFactory.getDAOFactory(ETypeDAO.MYSQL);
			daof.getDAOExpression().create(exp);
			System.out.println(daof.getDAOExpression().readById(exp.getId()));
		} catch (Exception e){
			System.out.println("Erreur : "+e.getMessage());
		}
	}
}
