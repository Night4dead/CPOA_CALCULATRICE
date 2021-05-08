package com.iut.as2021.metiers;

import com.iut.as2021.exceptions.MathsExceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ExpressionTest {

    private Expression resultat;

    @Rule
    public ExpectedException e = ExpectedException.none();

    @Test
    public void testExpressionSimpleAdditionWithoutP() throws MathsExceptions {
        resultat = new Expression("3+4+5+6");
        Assert.assertEquals(resultat.calculate(), 18, 2);
    }
    @Test
    public void testExpressionSimpleAdditionWithNegative() throws MathsExceptions {
        resultat = new Expression("-4+5+6");
        Assert.assertEquals(resultat.calculate(), 7, 2);
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
    public void testExpressionSimpleMultiplicationWithPWithoutOpe2() throws MathsExceptions {
        resultat = new Expression("(7*3)(5+1)*5");
        Assert.assertEquals(resultat.calculate(), 630, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithPWithoutOpe3() throws MathsExceptions {
        resultat = new Expression("(7*3)(5+1)(1+2)");
        Assert.assertEquals(resultat.calculate(), 378, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithPWithoutOpe4() throws MathsExceptions {
        resultat = new Expression("(7*3)((5+1)(1+1))");
        Assert.assertEquals(resultat.calculate(), 252, 2);
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
    @Test
    public void testExpressionComplexeFull2() throws MathsExceptions {
        resultat = new Expression("(-1+2)-(1*3)*(3+1)");
        Assert.assertEquals(resultat.calculate(),-9,2);
    }
    @Test
    public void testExpressionComplexeFull3() throws MathsExceptions {
        resultat = new Expression("(5+(2*1)+(3*1))/((5*2)-(2+3))");
        Assert.assertEquals(resultat.calculate(),2,2);
    }
    @Test
    public void testExpressionComplexeFull4() throws MathsExceptions {
        resultat = new Expression("(((((6+3)+(4+5-2))/1)))");
        Assert.assertEquals(resultat.calculate(),16,2);
    }
    @Test
    public void testExpressionComplexeFull5() throws MathsExceptions {
        resultat = new Expression("((6+3)+(((4+5-2))))/(1)");
        Assert.assertEquals(resultat.calculate(),16,2);
    }
    @Test
    public void testExpressionComplexeFull6() throws MathsExceptions {
        resultat = new Expression("(((((6+3))))+(4+5-2))/1");
        Assert.assertEquals(resultat.calculate(),16,2);
    }

    @Test
    public void testExpressionWithNegative() throws MathsExceptions{
        resultat = new Expression("-1+2");
        Assert.assertEquals(resultat.calculate(),1,2);
    }
    @Test
    public void testExpressionWithNegative2() throws MathsExceptions{
        resultat = new Expression("1+-1+2");
        Assert.assertEquals(resultat.calculate(),2,2);
    }
    @Test
    public void testExpressionWithNegative3() throws MathsExceptions{
        resultat = new Expression("1+(-1+2)");
        Assert.assertEquals(resultat.calculate(),2,2);
    }
    @Test
    public void testExpressionWithNegative4() throws MathsExceptions{
        resultat = new Expression("(-1--2)");
        Assert.assertEquals(resultat.calculate(),1,2);
    }
    @Test
    public void testExpressionWithNegative5() throws MathsExceptions{
        resultat = new Expression("-1+-2");
        Assert.assertEquals(resultat.calculate(),-3,2);
    }

    @Test
    public void testExpressionBy0() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("Division par zero impossible");
        resultat = new Expression("1/0");
        Assert.assertEquals(resultat.calculate(),1,2);
    }

    @Test
    public void testExpressionEmpty() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression est vide");
        resultat = new Expression("");
    }
    @Test
    public void testExpressionEmptyRight() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression est vide");
        resultat = new Expression("3+");
    }
    @Test
    public void testExpressionEmptyParenthesis() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression est vide");
        resultat = new Expression("3+()");
    }
}