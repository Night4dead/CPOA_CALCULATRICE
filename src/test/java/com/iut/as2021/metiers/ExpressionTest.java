package com.iut.as2021.metiers;

import com.iut.as2021.exceptions.MathsExceptions;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionTest {

    private Expression resultat;

    @Test
    public void testExpressionSimpleAddition() throws MathsExceptions {
        resultat = new Expression("3+4+5+6");
        Assert.assertEquals(resultat.calculate(), 18, 2);
    }

    @Test
    public void testExpressionSimpleSoustraction() throws MathsExceptions {
        resultat = new Expression("1+2-3+3");
        Assert.assertEquals(resultat.calculate(), 3, 2);
    }

    @Test
    public void testExpressionSimpleMultiplication() throws MathsExceptions {
        resultat = new Expression("7*3");
        Assert.assertEquals(resultat.calculate(), 21, 2);
    }

    @Test
    public void testExpressionSimpleDivision() throws MathsExceptions {
        resultat = new Expression("8 / 2");
        Assert.assertEquals(resultat.calculate(), 4, 2);
    }

}