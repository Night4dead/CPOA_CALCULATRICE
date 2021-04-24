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
import com.sun.org.apache.xpath.internal.operations.Div;

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


    public Expression(String expression) throws MathsExceptions{
        if (expression == null || expression.isEmpty()){
            throw new MathsExceptions("L'expression est vide");
        }
        maths = new Maths();
        tools = new Tools();
        this.expression = expression.trim();
        int posOpeAdd, posOpeSous, posOpeMult, posOpeDiv,posOpe=-1,posParOp;
        int cmptOpenPar=0;
        boolean start=false, operator=false;


        if(tools.countNbParenthesis(this.expression)==1 && this.expression.charAt(0)=='(' && this.expression.charAt(this.expression.length()-1)==')'){
            this.expression = this.expression.substring(1,this.expression.length()-1);
        }


        if((posParOp=this.expression.lastIndexOf(')'))==this.expression.length()-1){
            for (int i=this.expression.length()-1; i>0; i--) {
                if(this.expression.charAt(i)==')'){
                    cmptOpenPar++;
                    start= (start ? start : !start);
                } else if(this.expression.charAt(i)=='('){
                    cmptOpenPar--;
                }
                if(i!=0 && cmptOpenPar ==0 && start){
                    switch (this.expression.charAt(i-1)){
                        case '+':
                            this.ope = ADDITION;
                            posOpe = i-1;
                            break;
                        case '-':
                            this.ope = SOUSTRACTION;
                            posOpe = i-1;
                            break;
                        case '*':
                            this.ope = MULTIPLICATION;
                            posOpe = i-1;
                            break;
                        case '/':
                            this.ope = DIVISION;
                            posOpe = i-1;
                            break;
                        default:
                            if(i!=0){
                                this.ope = MULTIPLICATION;
                                posOpe = -1;
                            } else {
                                this.ope = INCONNUE;
                            }
                            break;
                    }
                    if(posOpe!=-1){
                        this.rightExpression =  new Expression(tools.getRightElement(this.expression,i-1));
                        this.leftExpression = new Expression(tools.getLeftElement(this.expression,i-1));
                    } else {
                        this.rightExpression =  new Expression(tools.getRightElement(this.expression,i-1));
                        this.leftExpression = new Expression(tools.getLeftElement(this.expression,i));
                    }
                    break;
                }
            }
        } else {
            posOpeAdd=this.expression.lastIndexOf("+");
            posOpeSous=this.expression.lastIndexOf("-");
            posOpeMult=this.expression.lastIndexOf("*");
            posOpeDiv=this.expression.lastIndexOf("/");

            if((posOpeAdd>0 && posOpeAdd>posOpeSous && posOpeAdd>posOpeMult && posOpeAdd>posOpeDiv)){
                posOpe = posOpeAdd;
                this.ope = ADDITION;
            } else if((posOpeSous>0&& posOpeSous>posOpeAdd && posOpeSous>posOpeMult && posOpeSous>posOpeDiv)){
                posOpe = posOpeSous;
                this.ope = SOUSTRACTION;
            } else if((posOpeMult>0 && posOpeMult>posOpeAdd && posOpeMult>posOpeSous && posOpeMult>posOpeDiv)){
                posOpe = posOpeMult;
                this.ope = MULTIPLICATION;
            } else if ((posOpeDiv>0 && posOpeDiv>posOpeAdd && posOpeDiv>posOpeMult && posOpeDiv>posOpeSous)){
                posOpe = posOpeDiv;
                this.ope = DIVISION;
            } else{
                this.ope = INCONNUE;
            }

            if(this.ope!=INCONNUE){
                this.leftExpression = new Expression(tools.getLeftElement(this.expression,posOpe));
                this.rightExpression = new Expression(tools.getRightElement(this.expression,posOpe));
            }

        }
        System.out.println("left : "+this.getLeftExpression()+", right : "+this.getRightExpression());
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
