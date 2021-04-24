package com.iut.as2021.metiers;

import com.iut.as2021.exceptions.MathsExceptions;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionTest {

    private Expression resultat;

    @Test
    public void testExpressionSimpleAdditionWithoutP() throws MathsExceptions {
        resultat = new Expression("3+4+5+6");
        Assert.assertEquals(resultat.calculate(), 18, 2);
    }
    @Test
    public void testExpressionSimpleAdditionWithOneP() throws MathsExceptions {
        resultat = new Expression("(3+4)+5+6");
        Assert.assertEquals(resultat.calculate(), 18, 2);
    }
    @Test
    public void testExpressionSimpleAdditionWithTwoP() throws MathsExceptions {
        resultat = new Expression("(3+4)+(5+6)");
        Assert.assertEquals(resultat.calculate(), 18, 2);
    }

    @Test
    public void testExpressionSimpleSoustractionWithoutP() throws MathsExceptions {
        resultat = new Expression("1+2-3+3");
        Assert.assertEquals(resultat.calculate(), 3, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionWithOneP() throws MathsExceptions {
        resultat = new Expression("(1+2)-3+3");
        Assert.assertEquals(resultat.calculate(), 3, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionWithTwoP() throws MathsExceptions {
        resultat = new Expression("(1+2)-(3+3)");
        Assert.assertEquals(resultat.calculate(), -3, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionWithOnePRight() throws MathsExceptions {
        resultat = new Expression("1+2-(3+3)");
        Assert.assertEquals(resultat.calculate(), -3, 2);
    }

    @Test
    public void testExpressionSimpleMultiplication() throws MathsExceptions {
        resultat = new Expression("7*3");
        Assert.assertEquals(resultat.calculate(), 21, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationPriorityAdd() throws MathsExceptions {
        resultat = new Expression("7*3+1");
        Assert.assertEquals(resultat.calculate(), 22, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithP() throws MathsExceptions {
        resultat = new Expression("(7*3)*5");
        Assert.assertEquals(resultat.calculate(), 105, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithPWithoutOpe() throws MathsExceptions {
        resultat = new Expression("(7*3)(5+1)");
        Assert.assertEquals(resultat.calculate(), 126, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithTwoP() throws MathsExceptions {
        resultat = new Expression("(7+1)*(3+1)");
        Assert.assertEquals(resultat.calculate(), 32, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationPriority() throws MathsExceptions {
        resultat = new Expression("(7+1)*(2*3+1)");
        Assert.assertEquals(resultat.calculate(), 56, 2);
    }

    @Test
    public void testExpressionSimpleDivision() throws MathsExceptions {
        resultat = new Expression("8/2");
        Assert.assertEquals(resultat.calculate(), 4, 2);
    }@Test
    public void testExpressionSimpleDivisionWithOneP() throws MathsExceptions {
        resultat = new Expression("8/(2+2)");
        Assert.assertEquals(resultat.calculate(), 2, 2);
    }@Test
    public void testExpressionSimpleDivisionWithTwoP() throws MathsExceptions {
        resultat = new Expression("(8+2)/(2+3)");
        Assert.assertEquals(resultat.calculate(), 2, 2);
    }


    @Test
    public void testExpressionComplexeFull() throws MathsExceptions {
        resultat = new Expression("((6+3)+(4+5-2))/1");
        Assert.assertEquals(resultat.calculate(),16,2);
    }
}