package com.iut.as2021.tools;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metiers.Expression;

public class Tools {
    public String getRightElement(String expression, int signe) {
        return expression.substring(signe+1).trim();
    }

    public String getLeftElement(String expression, int signe) {
        return expression.substring(0, signe).trim();
    }

    public int countNbParenthesis(String expression) throws MathsExceptions {
        int count = 0;
        boolean first=false;
        int cmptOpen=0;
        if(isClosingParentheses(0,expression)||
                isOpenParentheses(expression.length()-1,expression)){
            throw new MathsExceptions("expression mal paranthésée");
        }
        if (expression.equals("()")){
            throw new MathsExceptions("expression entre paranthèses vide : '()'");
        }
        for (int i=0;i<expression.length();i++){
            if(hasUnauthorizedChar(i,expression))
            {
                throw new MathsExceptions("l'expression contient des caractères non-autorisés");
            }
            if(isOpenParentheses(i,expression)){
                cmptOpen++;
                if(i==0){
                    first=true;
                }
                if (i>0&&first==true){
                    count--;
                }
            }
            if(isClosingParentheses(i,expression) && i>0){
                cmptOpen--;
                count++;
                if(cmptOpen==0&&first==true){
                    first=false;
                }
            }
        }
        if(cmptOpen!=0){
            throw new MathsExceptions("expression mal paranthésée");
        }
        return count;
    }

    private boolean hasUnauthorizedChar(int iCurrent, String expression){
        return isNotADigit(iCurrent,expression)
                &&expression.charAt(iCurrent)!=' '
                &&!isOperator(expression.charAt(iCurrent))
                &&!isClosingParentheses(iCurrent,expression)
                &&!isOpenParentheses(iCurrent,expression);
    }

    public boolean isNotADigit(int iCurrent,String expression){
        return !Character.isDigit(expression.charAt(iCurrent));
    }

    public boolean isClosingParentheses(int iCurrent, String exp){
        return exp.charAt(iCurrent)==')';
    }

    public boolean isOpenParentheses(int iCurrent, String exp){
        return exp.charAt(iCurrent)=='(';
    }

    public boolean isOperator(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/') return true;
        return false;
    }

    public String trimParenthesis(String expression) throws MathsExceptions {
        String res=expression;
        while (countNbParenthesis(res)==1 && res.indexOf('(')==0 && res.lastIndexOf(')')==res.length()-1){
            res=res.substring(1,res.length()-1);
        }
        return res;
    }
}
