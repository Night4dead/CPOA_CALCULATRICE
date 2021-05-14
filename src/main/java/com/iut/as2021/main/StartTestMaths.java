package com.iut.as2021.main;


import com.iut.as2021.DAO.DAOFactory;
import com.iut.as2021.DAO.ETypeDAO;
import com.iut.as2021.metiers.Expression;

import java.util.ArrayList;

public class StartTestMaths {

	public static void main(String[] args) {


		try {
			//System.out.println(exp+", left element : "+exp.getLeftExpression()+", right element : "+exp.getRightExpression().getExpression()+", ope : "+exp.getOpe());
			//System.out.println(exp.getValue());
			DAOFactory daof = DAOFactory.getDAOFactory(ETypeDAO.MYSQL);
			ArrayList<Expression> exp2 = daof.getDAOExpression().getAll();
			//System.out.println("done");
			//System.out.println(daof.getDAOExpression().readById(exp.getId()));
			for (Expression e : exp2) {
				System.out.println("id "+e.getId()+" : "+e.getExpression()+" = "+e.getValue());
			}
		} catch (Exception e){
			System.out.println("Erreur : "+e.getMessage());
		}
	}
}
