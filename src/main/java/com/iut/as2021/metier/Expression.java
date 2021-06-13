package com.iut.as2021.metier;

import static com.iut.as2021.enums.Operation.ADDITION;
import static com.iut.as2021.enums.Operation.DIVISION;
import static com.iut.as2021.enums.Operation.SOUSTRACTION;
import static com.iut.as2021.enums.Operation.MULTIPLICATION;
import static com.iut.as2021.enums.Operation.INCONNUE;

import com.iut.as2021.enums.Operation;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.exceptions.MathsTechnicalException;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;
import com.iut.as2021.tools.Tools;

public class Expression {
    private Operation ope;
    private IMaths maths;
    private Tools tools;


    private String expression;
    private int id;

    private Expression leftExpression;
    private Expression rightExpression;


    /**
     * Renvois le résultat du calcul d'une expression
     * */
    public double getValue() throws MathsExceptions {
        double res=0;
        if (this.ope==INCONNUE){
            try {
                res = Double.parseDouble(this.expression);
            } catch (Exception e){
                throw new MathsTechnicalException("Erreur de format de l'expression");
            }
        } else {
            res = this.calculate();
        }
        return res;
    }

    /**
     * Constructeur expression, va stocker l'expression ainsi que la décomposer en deux membres distincts
     * */
    public Expression(String exp) throws MathsExceptions{
        if (exp == null || exp.isEmpty()){
            throw new MathsExceptions("l'expression est vide");
        }
        tools = new Tools();
        this.expression = tools.trimParenthesis(exp);
        if (this.expression.length()==1 && tools.isNotADigit(0,this.expression)){
            throw new MathsExceptions("l'expression ne contient pas de chiffres");
        }
        this.ope=INCONNUE;
        assignLeftRightExpressions();
        maths = new Maths();
    }


    /**
     * Décomposition de l'expression en deux membres selon la position de l'opérateur ayant la plus petite priorité de calcul
     * */
    private void assignLeftRightExpressions()throws MathsExceptions{
        int pos = getPosition();
        if(!INCONNUE.equals(ope)){
            if(pos<0 && MULTIPLICATION.equals(ope)){
                leftExpression= new Expression(tools.getLeftElement(this.expression,(-pos)+1));
                rightExpression= new Expression(tools.getRightElement(this.expression,-pos));
            } else {
                leftExpression= new Expression(tools.getLeftElement(this.expression,pos));
                rightExpression= new Expression(tools.getRightElement(this.expression,pos));
            }

        }
    }

    /**
     * Récupère la position de l'opérateur avec la plus petite priorité de calcul
     * */
    private int getPosition(){
        int pos=0,count=0;
        for(int i=this.expression.length()-1;i>-1;i--){
            if(tools.isClosingParentheses(i,this.expression)){
                count++;
            }
            if(isImplicitMultiplication(i,i+1)){
                pos=-i;
                this.ope=MULTIPLICATION;
            }
            if (tools.isOpenParentheses(i,this.expression)){
                count--;
            }
            if(i>0 && !isNegativeNumber(i)){
                if(isNewOperator(i,count,pos)){
                    pos=i;
                    switchOpe(this.expression.charAt(i));
                }
            }
        }
        return pos;
    }

    /**
     * Test la présence d'un signe - indiquant un nombre négatif
     * */
    private boolean isNegativeNumber(int iCurrent){
        return this.expression.charAt(iCurrent)=='-' &&
                (tools.isOperator(this.expression.charAt(iCurrent-1)) ||
                        tools.isOpenParentheses(iCurrent-1,this.expression));
    }

    /**
     * Vérifie si l'opérateur détecter est le nouvel opérateur avec la plus petite priorité de calcul
     * */
    private boolean isNewOperator(int iCurrent, int count, int pos){
        return tools.isOperator(this.expression.charAt(iCurrent)) &&
                count==0 &&
                ( pos==0 || this.ope==MULTIPLICATION || this.ope==DIVISION );
    }

    /**
     * Vérifie la présence d'une paranthèse ) indique une multiplication implicite --> (1+2)(3*2)
     * */
    private boolean isImplicitMultiplication(int iCurrent, int iBefore){
        return iCurrent<this.expression.length()-2 &&
                tools.isClosingParentheses(iCurrent,this.expression) &&
                tools.isOpenParentheses(iBefore,this.expression);
    }

    /**
     * Détermine l'opérateur du char c
     * */
    private void switchOpe(char c){
        switch(c){
            case '+':
                this.ope = ADDITION;
                break;
            case '-':
                this.ope = SOUSTRACTION;
                break;
            case '*':
                this.ope = MULTIPLICATION;
                break;
            case '/':
                this.ope = DIVISION;
                break;
        }
    }

    /**
     * Calcul le résultat d'une expression
     * */
    private double calculate() throws MathsExceptions{
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

    public String getExpression() {
        return expression;
    }

    @Override
    public String toString(){
        return this.expression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
