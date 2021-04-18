package com.iut.as2021.mathematics;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;

public class Maths implements IMaths {

	@Override
	public double addition(double a, double b) {
		return a + b;
	}

	@Override
	public double soustraction(double a, double b) {
		return a - b;
	}

	@Override
	public double multiplication(double a, double b) {
		// Ecrire l'impl�mentation de multiplication en utilisant que des additions !
		// Tester tous les cas possibles (positifs, n�gatifs, 0 ...).
		return a * b;
	}

	@Override
	public double division(double a, double b) throws MathsExceptions {
		if (b == 0) {
			throw new MathsExceptions("Division par zero impossible");
		}
		try {
			return a / b;
		} catch (Exception e) {
			throw new MathsExceptions(e.getMessage());
		}
	}
}
