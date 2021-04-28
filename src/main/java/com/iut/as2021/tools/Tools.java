package com.iut.as2021.tools;

public class Tools {
    public String getRightElement(String expression, int signe) {
        return expression.substring(signe+1).trim();
    }

    public String getLeftElement(String expression, int signe) {
        return expression.substring(0, signe).trim();
    }

    public int countNbParenthesis(String expression){
        int count = 0;
        boolean first=false;
        int cmptOpen=0;
        if(expression.charAt(0)==')'||expression.charAt(expression.length()-1)=='('){
            return -1;
        }
        for (int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='('){
                cmptOpen++;
                if(i==0){
                    first=true;
                }
                if (i>0&&first==true){
                    count--;
                }
            }
            if(expression.charAt(i)==')' && i>0){
                cmptOpen--;
                count++;
                if(cmptOpen==0&&first==true){
                    first=false;
                }
            }

        }
        if(cmptOpen!=0){
            return -1;
        }
        return count;
    }

    public String trimParenthesis(String expression){
        String res=expression;
        while (countNbParenthesis(res)==1 && res.indexOf('(')==0 && res.lastIndexOf(')')==res.length()-1){
            res=res.substring(1,res.length()-1);
        }
        return res;
    }
}
