package mathematics;

import exceptions.MathsException;
import interfaces.IMaths;

public class Maths implements IMaths{
    @Override
    public int addition(int a, int b){
        return a + b;
    }

    @Override
    public int soustraction(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplication(int a, int b) {
        int res=0;
        for(int i=0;i<(a < 0 && b < 0 ? -a : (a<0 ? b : a));i++){
            int temp = ((a < 0 && b < 0)? -b : (a < 0 ? a : b));
            res=addition(res,temp);
        }
        return res;
    }

    @Override
    public double division(int a, int b) throws MathsException {
        if(b==0) throw new MathsException("Division par zéro interdite");
        try {
            return a/ b;
        } catch(Exception e) {
            throw new MathsException(e.getMessage());
        }
    }
}
