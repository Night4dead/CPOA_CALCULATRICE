package com.iut.as2021.controller.service.interfaces;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.modele.BoExpression;

import java.util.List;

public interface IServiceExpression {

    String calculate(String expression) throws MathsExceptions;

    void save(BoExpression expression) throws MathsExceptions;

    void deleteAll() throws MathsExceptions;

    List<BoExpression> expressionList() throws MathsExceptions;
}
