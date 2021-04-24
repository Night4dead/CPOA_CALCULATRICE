package com.iut.as2021.metiers;

import com.iut.as2021.exceptions.MathsExceptions;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionTest {

    private Expression resultat;
    private Expression resultat2;
    private Expression resultat3;

    @Test
    public void testExpressionSimpleAdditionMembresPositifs() throws MathsExceptions {
        resultat = new Expression("3+4");
        Assert.assertEquals(resultat.calculate(), 7, 2);
    }
    @Test
    public void testExpressionSimpleAdditionMembresNulls() throws MathsExceptions {
        resultat = new Expression("0+0");
        Assert.assertEquals(resultat.calculate(), 0, 2);
    }
    @Test
    public void testExpressionSimpleAdditionPremierMembreNull() throws MathsExceptions {
        resultat = new Expression("0+4");
        Assert.assertEquals(resultat.calculate(), 4, 2);
    }

    @Test
    public void testExpressionSimpleAdditionDeuxiemeMembresNull() throws MathsExceptions {
        resultat = new Expression("4+0");
        Assert.assertEquals(resultat.calculate(), 4, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionMembresPositifs() throws MathsExceptions {
        resultat = new Expression("3-4");
        Assert.assertEquals(resultat.calculate(), -1, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionMembresNulls() throws MathsExceptions {
        resultat = new Expression("0-0");
        Assert.assertEquals(resultat.calculate(), 0, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionPremierMembreNull() throws MathsExceptions {
        resultat = new Expression("0-4");
        Assert.assertEquals(resultat.calculate(), -4, 2);
    }

    @Test
    public void testExpressionSimpleSoustractionDeuxiemeMembresNull() throws MathsExceptions {
        resultat = new Expression("4-0");
        Assert.assertEquals(resultat.calculate(), 0, 2);
    }

    @Test
    public void testExpressionSimpleMultiplicationMembresPositifs() throws MathsExceptions {
        resultat = new Expression("7*3*2");
        Assert.assertEquals(resultat.calculate(), 42, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationMembresNegatifs() throws MathsExceptions {
        resultat = new Expression("-7*-3");
        Assert.assertEquals(resultat.calculate(), 42, 2);
        resultat2 = new Expression("-7*3");
        Assert.assertEquals(resultat2.calculate(), 42, 2);
        resultat3 = new Expression("3*(-7)");
        Assert.assertEquals(resultat3.calculate(), 42, 2);
    }

    @Test
    public void testExpressionSimpleMultiplicationMembreNull() throws MathsExceptions {
        resultat = new Expression("0*4*5");
        Assert.assertEquals(resultat.calculate(), 0, 2);
        resultat2 = new Expression("4*0*5");
        Assert.assertEquals(resultat2.calculate(), 0, 2);
        resultat3 = new Expression("4*5*0");
        Assert.assertEquals(resultat3.calculate(), 0, 2);
    }


    @Test
    public void testExpressionSimpleDivisionMembresPositifs() throws MathsExceptions {
        resultat = new Expression("8 / 2");
        Assert.assertEquals(resultat.calculate(), 4, 2);
    }

    @Test
    public void testExpressionSimpleDivisionMembresNegatifs() throws MathsExceptions {
        resultat = new Expression("-8 / -2");
        Assert.assertEquals(resultat.calculate(), 4, 2);
    }
}