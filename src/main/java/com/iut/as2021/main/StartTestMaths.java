package com.iut.as2021.main;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;
import com.iut.as2021.metiers.Expression;

public class StartTestMaths {

	public static void main(String[] args) {


		try {
			Expression exp = new Expression("(1+2)-3+3");
			//System.out.println(exp+", left element : "+exp.getLeftExpression()+", right element : "+exp.getRightExpression().getExpression()+", ope : "+exp.getOpe());
			System.out.println(exp.getValue());
		} catch (MathsExceptions e){
			System.out.println("Erreur : "+e.getMessage());
		}
	}
}
