package com.iut.as2021.metiers;

import static com.iut.as2021.enums.Operation.ADDITION;
import static com.iut.as2021.enums.Operation.DIVISION;
import static com.iut.as2021.enums.Operation.SOUSTRACTION;
import static com.iut.as2021.enums.Operation.MULTIPLICATION;
import static com.iut.as2021.enums.Operation.INCONNUE;

import com.iut.as2021.enums.Operation;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;
import com.iut.as2021.tools.Tools;

public class Expression {
    private Operation ope;
    private IMaths maths;
    private Tools tools;

    private String expression;

    private Expression leftExpression;
    private Expression rightExpression;

    public double getValue() throws MathsExceptions {
        double res=0;
        if (this.ope==INCONNUE){
            res = Integer.parseInt(this.expression);
        } else {
            res = this.calculate();
        }
        return res;
    }

    public Expression(String expression){
        maths = new Maths();
        tools = new Tools();
        this.expression = expression;
        int posOpeAdd, posOpeSous, posOpeMult, posOpeDiv,posOpe;
        posOpeAdd=this.expression.indexOf("+");
        posOpeSous=this.expression.indexOf("-");
        posOpeMult=this.expression.indexOf("*");
        posOpeDiv=this.expression.indexOf("/");
        posOpe = ((posOpeAdd>posOpeSous)&&(posOpeAdd>posOpeMult)&&(posOpeAdd>posOpeDiv) ? posOpeAdd :
                ( (posOpeSous>posOpeAdd)&&(posOpeSous>posOpeMult)&&(posOpeSous>posOpeDiv) ? posOpeSous :
                        ( (posOpeMult>posOpeAdd)&&(posOpeMult>posOpeSous)&&(posOpeMult>posOpeDiv)? posOpeMult:
                                ( (posOpeDiv>posOpeAdd)&&(posOpeDiv>posOpeSous)&&(posOpeDiv>posOpeMult) ? posOpeDiv : -1) ) ) );

        this.ope =

        if(this.ope!=INCONNUE){
            this.leftExpression = new Expression(tools.getLeftElement(this.expression,posOpe));
            this.rightExpression = new Expression(tools.getRightElement(this.expression,posOpe));
        }
    }

    public double calculate() throws MathsExceptions{
        double res=0;
        switch (ope){
            case INCONNUE:
                res = this.getValue();
                break;
            case ADDITION:
                res = maths.addition(leftExpression.getValue(),rightExpression.getValue());
                break;
            case SOUSTRACTION:
                res = maths.soustraction(leftExpression.getValue(),rightExpression.getValue());
                break;
            case MULTIPLICATION:
                res = maths.multiplication(leftExpression.getValue(),rightExpression.getValue());
                break;
            case DIVISION:
                res = maths.division(leftExpression.getValue(),rightExpression.getValue());
        }
        return res;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    public Operation getOpe(){
        return this.ope;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String toString(){
        return this.expression;
    }
}
