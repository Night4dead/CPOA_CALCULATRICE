package com.iut.as2021.controller.service.interfaces;

import com.iut.as2021.exceptions.MathsExceptions;

public interface IServiceExpression {

    String calculate(String expression) throws MathsExceptions;
}
