package com.iut.as2021.tools;

public class Tools {
    public String getRightElement(String expression, int signe) {
        return expression.substring(signe+1).trim();
    }

    public String getLeftElement(String expression, int signe) {
        return expression.substring(0, signe).trim();
    }
}
