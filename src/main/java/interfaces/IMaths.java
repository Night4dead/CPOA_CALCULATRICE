package interfaces;

import exceptions.MathsException;

public interface IMaths {
    public int addition(int a, int b);
    public int soustraction(int a, int b);
    public int multiplication(int a, int b);
    public double division(int a, int b) throws MathsException;

}
