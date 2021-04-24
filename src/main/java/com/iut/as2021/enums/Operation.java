package com.iut.as2021.enums;

public enum Operation {
    INCONNUE(0,""),
    ADDITION(1,"+"),
    SOUSTRACTION(2,"-"),
    MULTIPLICATION(3,"*"),
    DIVISION(4,"/");

    private int code;
    private String ope;

    public int getCode(){
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getOpe() {
        return ope;
    }

    public void setOpe(String ope) {
        this.ope = ope;
    }

    private Operation(int code, String operateur){
        this.code = code;
        this.ope = operateur;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "ope='" + ope + '\'' +
                '}';
    }
}
