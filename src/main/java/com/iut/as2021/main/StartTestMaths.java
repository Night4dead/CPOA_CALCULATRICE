package com.iut.as2021.main;


import com.iut.as2021.dao.DAOFactory;
import com.iut.as2021.dao.ETypeDAO;
import com.iut.as2021.metiers.Expression;

import java.util.ArrayList;

public class StartTestMaths {

	public static void main(String[] args) {


		try {
			DAOFactory daof = DAOFactory.getDAOFactory(ETypeDAO.MYSQL);
			ArrayList<Expression> exp2 = daof.getDAOExpression().getAll();
			for (Expression e : exp2) {
				System.out.println("id "+e.getId()+" : "+e.getExpression()+" = "+e.getValue());
			}
		} catch (Exception e){
			System.out.println("Erreur : "+e.getMessage());
		}
	}
}
