package main;

import interfaces.IMaths;
import mathematics.Maths;

public class StartTestMain {
    public static void main(String[] args) {
        IMaths maths = new Maths();
        try {
            System.out.println(maths.multiplication(-3,-2));
            System.out.println(maths.division(2,0));
        } catch (Exception e){
            System.out.println("Erreur : "+ e.getMessage());
        }

    }
}
