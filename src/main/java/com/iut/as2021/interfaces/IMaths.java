package com.iut.as2021.interfaces;

import com.iut.as2021.exceptions.MathsExceptions;

public interface IMaths {

	double addition(double a, double b);

	double soustraction(double a, double b);

	double multiplication(double a, double b);

	double division(double a, double b) throws MathsExceptions;
}
