package com.iut.as2021.metier;

import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;

public class Calculer {
    private IMaths maths;

    public Calculer(){
        maths = new Maths();
    }

    public double addition(String expression,int signe){
        String left = getLeftElement(expression, signe);
        String right = getRightElement(expression, signe);
        return maths.addition(Double.valueOf(left),Double.valueOf(right));
    }


    public double soustraction(String expression,int signe){
        String left = getLeftElement(expression, signe);
        String right = getRightElement(expression, signe);
        return maths.soustraction(Double.valueOf(left),Double.valueOf(right));
    }


    public double multiplication(String expression, int signe){
        String left = getLeftElement(expression, signe);
        String right = getRightElement(expression, signe);
        return maths.multiplication(Double.valueOf(left),Double.valueOf(right));
    }


    public double division(String expression,int signe) throws Exception{
        String left = getLeftElement(expression, signe);
        String right = getRightElement(expression, signe);
        return maths.division(Double.valueOf(left),Double.valueOf(right));
    }


    private String getRightElement(String expression, int signe) {
        return expression.substring(signe+1).trim();
    }

    private String getLeftElement(String expression, int signe) {
        return expression.substring(0, signe).trim();
    }
}
