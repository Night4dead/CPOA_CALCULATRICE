package com.iut.as2021.tools;

import com.iut.as2021.exceptions.MathsExceptions;

public class Tools {
    public String getRightElement(String expression, int signe) {
        return expression.substring(signe+1).trim();
    }

    public String getLeftElement(String expression, int signe) {
        return expression.substring(0, signe).trim();
    }


    /**
     * Compte le nombre de paranthèses, si le nombre de paranthèses (cmptOpen, compteur Open) est à zéro,
     * c'est que l'expression est bien paranthésée et a autant de paranthèse fermantes qu'ouvrantes.
     * Count est égal à 1 si il y a une double paranthèse : ((expression)).
     * */
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
                if (i>0&& first){
                    count--;
                }
            }
            if(isClosingParentheses(i,expression) && i>0){
                cmptOpen--;
                count++;
                if(cmptOpen==0&& first){
                    first=false;
                }
            }
        }
        if(cmptOpen!=0){
            throw new MathsExceptions("expression mal paranthésée");
        }
        return count;
    }

    /**
     * Retourne un boolean true si un caractère interdit est présent,
     * e.g. des lettres, des ponctuations (autre que . --> nombre décimal)
     *      ou caractères spéciaux
     **/
    private boolean hasUnauthorizedChar(int iCurrent, String expression){
        return isNotADigit(iCurrent,expression)
                &&expression.charAt(iCurrent)!=' '
                &&expression.charAt(iCurrent)!='.'
                &&!isOperator(expression.charAt(iCurrent))
                &&!isClosingParentheses(iCurrent,expression)
                &&!isOpenParentheses(iCurrent,expression);
    }

    /**
     * renvois true si le caractère n'est pas un chiffre
     * */
    public boolean isNotADigit(int iCurrent,String expression){
        return !Character.isDigit(expression.charAt(iCurrent));
    }

    /**
     * regardes si le caractère est une paranthèse fermante
     *
     * */
    public boolean isClosingParentheses(int iCurrent, String exp){
        return exp.charAt(iCurrent)==')';
    }

    /**
     * regardes si le caractère est une paranthèse ouvrante
     *
     * */
    public boolean isOpenParentheses(int iCurrent, String exp){
        return exp.charAt(iCurrent)=='(';
    }

    /**
     * renvois true si le caractère est un opérateur
     * */
    public boolean isOperator(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/') return true;
        return false;
    }

    /**
     * Si count est égal à 1, donc qu'il y a une double paranthèse, et que ces paranthèses sont le premier et dernier caractères, alors on trim l'expression en les enlevant
     * */
    public String trimParenthesis(String expression) throws MathsExceptions {
        String res=expression;
        while (countNbParenthesis(res)==1 && res.indexOf('(')==0 && res.lastIndexOf(')')==res.length()-1){
            res=res.substring(1,res.length()-1);
        }
        return res;
    }
}
