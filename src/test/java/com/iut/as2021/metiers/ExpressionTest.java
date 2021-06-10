package com.iut.as2021.metiers;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.Expression;
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
        resultat = new Expression("3 + 4 + 5 + 6");
        Assert.assertEquals(resultat.getValue(), 18, 2);
    }
    @Test
    public void testExpressionSimpleAdditionWithNegative() throws MathsExceptions {
        resultat = new Expression("-4+5+6");
        Assert.assertEquals(resultat.getValue(), 7, 2);
    }
    @Test
    public void testExpressionSimpleAdditionWithOneP() throws MathsExceptions {
        resultat = new Expression("(3+4)+5+6");
        Assert.assertEquals(resultat.getValue(), 18, 2);
    }
    @Test
    public void testExpressionSimpleAdditionWithTwoP() throws MathsExceptions {
        resultat = new Expression("(3+4)+(5+6)");
        Assert.assertEquals(resultat.getValue(), 18, 2);
    }

    @Test
    public void testExpressionSimpleSoustractionWithoutP() throws MathsExceptions {
        resultat = new Expression("1+2-3+3");
        Assert.assertEquals(resultat.getValue(), 3, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionWithOneP() throws MathsExceptions {
        resultat = new Expression("(1+2)-3+3");
        Assert.assertEquals(resultat.getValue(), 3, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionWithTwoP() throws MathsExceptions {
        resultat = new Expression("(1+2)-(3+3)");
        Assert.assertEquals(resultat.getValue(), -3, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionWithOnePRight() throws MathsExceptions {
        resultat = new Expression("1+2-(3+3)");
        Assert.assertEquals(resultat.getValue(), -3, 2);
    }

    @Test
    public void testExpressionSimpleMultiplication() throws MathsExceptions {
        resultat = new Expression("7*3");
        Assert.assertEquals(resultat.getValue(), 21, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationPriorityAdd() throws MathsExceptions {
        resultat = new Expression("7*3+1");
        Assert.assertEquals(resultat.getValue(), 22, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithP() throws MathsExceptions {
        resultat = new Expression("(7*3)*5");
        Assert.assertEquals(resultat.getValue(), 105, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithPWithoutOpe() throws MathsExceptions {
        resultat = new Expression("(7*3)(5+1)");
        Assert.assertEquals(resultat.getValue(), 126, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithPWithoutOpe2() throws MathsExceptions {
        resultat = new Expression("(7*3)(5+1)*5");
        Assert.assertEquals(resultat.getValue(), 630, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithPWithoutOpe3() throws MathsExceptions {
        resultat = new Expression("(7*3)(5+1)(1+2)");
        Assert.assertEquals(resultat.getValue(), 378, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithPWithoutOpe4() throws MathsExceptions {
        resultat = new Expression("(7*3)((5+1)(1+1))");
        Assert.assertEquals(resultat.getValue(), 252, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationWithTwoP() throws MathsExceptions {
        resultat = new Expression("(7+1)*(3+1)");
        Assert.assertEquals(resultat.getValue(), 32, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationPriority() throws MathsExceptions {
        resultat = new Expression("(7+1)*(2*3+1)");
        Assert.assertEquals(resultat.getValue(), 56, 2);
    }

    @Test
    public void testExpressionSimpleDivision() throws MathsExceptions {
        resultat = new Expression("8/2");
        Assert.assertEquals(resultat.getValue(), 4, 2);
    }@Test
    public void testExpressionSimpleDivisionWithOneP() throws MathsExceptions {
        resultat = new Expression("8/(2+2)");
        Assert.assertEquals(resultat.getValue(), 2, 2);
    }@Test
    public void testExpressionSimpleDivisionWithTwoP() throws MathsExceptions {
        resultat = new Expression("(8+2)/(2+3)");
        Assert.assertEquals(resultat.getValue(), 2, 2);
    }


    @Test
    public void testExpressionComplexeFull() throws MathsExceptions {
        resultat = new Expression("((6+3)+(4+5-2))/1");
        Assert.assertEquals(resultat.getValue(),16,2);
    }
    @Test
    public void testExpressionComplexeFull2() throws MathsExceptions {
        resultat = new Expression("(-1+2)-(1*3)*(3+1)");
        Assert.assertEquals(resultat.getValue(),-9,2);
    }
    @Test
    public void testExpressionComplexeFull3() throws MathsExceptions {
        resultat = new Expression("(5+(2*1)+(3*1))/((5*2)-(2+3))");
        Assert.assertEquals(resultat.getValue(),2,2);
    }
    @Test
    public void testExpressionComplexeFull4() throws MathsExceptions {
        resultat = new Expression("(((((6+3)+(4+5-2))/1)))");
        Assert.assertEquals(resultat.getValue(),16,2);
    }
    @Test
    public void testExpressionComplexeFull5() throws MathsExceptions {
        resultat = new Expression("((6+3)+(((4+5-2))))/(1)");
        Assert.assertEquals(resultat.getValue(),16,2);
    }
    @Test
    public void testExpressionComplexeFull6() throws MathsExceptions {
        resultat = new Expression("(((((6+3))))+(4+5-2))/1");
        Assert.assertEquals(resultat.getValue(),16,2);
    }

    @Test
    public void testExpressionWithNegative() throws MathsExceptions{
        resultat = new Expression("-1+2");
        Assert.assertEquals(resultat.getValue(),1,2);
    }
    @Test
    public void testExpressionWithNegative2() throws MathsExceptions{
        resultat = new Expression("1+-1+2");
        Assert.assertEquals(resultat.getValue(),2,2);
    }
    @Test
    public void testExpressionWithNegative3() throws MathsExceptions{
        resultat = new Expression("1+(-1+2)");
        Assert.assertEquals(resultat.getValue(),2,2);
    }
    @Test
    public void testExpressionWithNegative4() throws MathsExceptions{
        resultat = new Expression("(-1--2)");
        Assert.assertEquals(resultat.getValue(),1,2);
    }
    @Test
    public void testExpressionWithNegative5() throws MathsExceptions{
        resultat = new Expression("-1+-2");
        Assert.assertEquals(resultat.getValue(),-3,2);
    }
    @Test
    public void testExpressionWithNegative6() throws MathsExceptions{
        resultat = new Expression("(-1+2)+(-3+4)");
        Assert.assertEquals(resultat.getValue(),2,2);
    }

    @Test
    public void testExpressionBy01() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("Division par zero impossible");
        resultat = new Expression("1/0");
        Assert.assertEquals(resultat.getValue(),1,2);
    }
    @Test
    public void testExpressionBy02() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("Division par zero impossible");
        resultat = new Expression("1/(1-1)");
        Assert.assertEquals(resultat.getValue(),1,2);
    }
    @Test
    public void testExpressionBy03() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("Division par zero impossible");
        resultat = new Expression("1/(((2*5)+4)*0)");
        Assert.assertEquals(resultat.getValue(),1,2);
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
        e.expectMessage("expression entre paranthèses vide : '()'");
        resultat = new Expression("3+()");
    }
    @Test
    public void testExpressionWrongParenthesis() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("expression mal paranthésée");
        resultat = new Expression("3+)4+3(");
    }
    @Test
    public void testExpressionWrongParenthesis2() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("expression mal paranthésée");
        resultat = new Expression("(2+1))(2+1");
    }
    @Test
    public void testExpressionWrongParenthesis3() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("expression mal paranthésée");
        resultat = new Expression("(2+1))");
    }
    @Test
    public void testExpressionWrongParenthesis4() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("expression mal paranthésée");
        resultat = new Expression(")2+1)");
    }
    @Test
    public void testExpressionAdditionNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("a+2");
    }
    @Test
    public void testExpressionMultiplicationNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("ba*2");
    }
    @Test
    public void testExpressionSoustractionNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("e-2");
    }
    @Test
    public void testExpressionDivisionNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("!/2");
    }
    @Test
    public void testExpressionDivisionNotaNumber2() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("=/2");
    }

    @Test
    public void testExpressionNotNumnber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression ne contient pas de chiffres");
        resultat = new Expression("+");
    }

    @Test
    public void testExpressionNotNumnber2() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression ne contient pas de chiffres");
        resultat = new Expression("-");
    }

    @Test
    public void testExpressionNotNumnber3() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression ne contient pas de chiffres");
        resultat = new Expression("/");
    }

    @Test
    public void testExpressionNotNumnber4() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("ar");
    }

    @Test
    public void testExpressionComplexWithSeveralBrackets() throws MathsExceptions {
        resultat = new Expression("(((((2 + 3)) * ((4 + 5)) + 2)))");
        Assert.assertEquals(resultat.getValue(), 47, 0);
    }
    @Test
    public void testExpressionComplexWithSeveralBrackets2() throws MathsExceptions {
        resultat = new Expression("(((((2 + 3)) * ((4 + 5)) + 2))) + 3 * 2");
        Assert.assertEquals(resultat.getValue(), 53, 0);
    }
    @Test
    public void testExpressionComplexWithSeveralBrackets3() throws MathsExceptions {
        resultat = new Expression("((((((2 + 3)) * ((4 + 5)) + 2))) + 3 )* 2");
        Assert.assertEquals(resultat.getValue(), 100, 0);
    }
        @Test
    public void testExpressionSimpleAdditionDoubleWithoutP() throws MathsExceptions {
        resultat = new Expression("3.5 + 4.5 + 5.5 + 6.5");
        Assert.assertEquals(resultat.getValue(), 20, 2);
    }
    @Test
    public void testExpressionSimpleAdditionDoubleWithNegative() throws MathsExceptions {
        resultat = new Expression("-4.5+5.5+6.5");
        Assert.assertEquals(resultat.getValue(), 7.5, 2);
    }
    @Test
    public void testExpressionSimpleAdditionDoubleWithOneP() throws MathsExceptions {
        resultat = new Expression("(3.5+4.5)+5.5+6.5");
        Assert.assertEquals(resultat.getValue(), 20, 2);
    }
    @Test
    public void testExpressionSimpleAdditionDoubleWithTwoP() throws MathsExceptions {
        resultat = new Expression("(3.5+4.5)+(5.5+6.5)");
        Assert.assertEquals(resultat.getValue(), 20, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionDoubleWithoutP() throws MathsExceptions {
        resultat = new Expression("1.5+2.5-3.5+3.5");
        Assert.assertEquals(resultat.getValue(), 4, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionDoubleWithOneP() throws MathsExceptions {
        resultat = new Expression("(1.5+2.5)-3.5+3.5");
        Assert.assertEquals(resultat.getValue(), 4, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionDoubleWithTwoP() throws MathsExceptions {
        resultat = new Expression("(1.5+2.5)-(3.5+3.5)");
        Assert.assertEquals(resultat.getValue(), -3, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionDoubleWithOnePRight() throws MathsExceptions {
        resultat = new Expression("1.5+2.5-(3.5+3.5)");
        Assert.assertEquals(resultat.getValue(), -3, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDouble() throws MathsExceptions {
        resultat = new Expression("7.5*3.5");
        Assert.assertEquals(resultat.getValue(), 26.25, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoublePriorityAdd() throws MathsExceptions {
        resultat = new Expression("7.5*3.5+1.5");
        Assert.assertEquals(resultat.getValue(), 27.75, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoubleWithP() throws MathsExceptions {
        resultat = new Expression("(7.5*3.5)*5.5");
        Assert.assertEquals(resultat.getValue(), 144.375, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoubleWithPWithoutOpe() throws MathsExceptions {
        resultat = new Expression("(7.5*3.5)(5.5+1.5)");
        Assert.assertEquals(resultat.getValue(), 183.75, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoubleWithPWithoutOpe2() throws MathsExceptions {
        resultat = new Expression("(7.5*3.5)(5.5+1.5)*5.5");
        Assert.assertEquals(resultat.getValue(), 1010.625, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoubleWithPWithoutOpe3() throws MathsExceptions {
        resultat = new Expression("(7.5*3.5)(5.5+1.5)(1.5+2.5)");
        Assert.assertEquals(resultat.getValue(), 735, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoubleWithPWithoutOpe4() throws MathsExceptions {
        resultat = new Expression("(7.5*3.5)((5.5+1.5)(1.5+1.5))");
        Assert.assertEquals(resultat.getValue(), 551.25, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoubleWithTwoP() throws MathsExceptions {
        resultat = new Expression("(7.5+1.5)*(3.5+1.5)");
        Assert.assertEquals(resultat.getValue(), 45, 2);
    }
    @Test
    public void testExpressionSimpleMultiplicationDoublePriority() throws MathsExceptions {
        resultat = new Expression("(7.5+1.5)*(2.5*3.5+1.5)");
        Assert.assertEquals(resultat.getValue(), 92.25, 2);
    }

    @Test
    public void testExpressionSimpleDivisionDouble() throws MathsExceptions {
        resultat = new Expression("8.2/2.5");
        Assert.assertEquals(resultat.getValue(), 3.28, 2);
    }@Test
    public void testExpressionSimpleDivisionDoubleWithOneP() throws MathsExceptions {
        resultat = new Expression("8.5/(2.5+2.5)");
        Assert.assertEquals(resultat.getValue(), 1.7, 2);
    }@Test
    public void testExpressionSimpleDivisionDoubleWithTwoP() throws MathsExceptions {
        resultat = new Expression("(8.5+2.5)/(0.4+0.6)");
        Assert.assertEquals(resultat.getValue(), 11, 2);
    }

    @Test
    public void testExpressionComplexeDoubleFull() throws MathsExceptions {
        resultat = new Expression("((6.5+3.5)+(4.5+5.5-2.5))/1.5");
        Assert.assertEquals(resultat.getValue(),11.6666666667,2);
    }
    @Test
    public void testExpressionComplexeDoubleFull2() throws MathsExceptions {
        resultat = new Expression("(-1.5+2.5)-(1.5*3.5)*(3.5+1.5)");
        Assert.assertEquals(resultat.getValue(),-25.25,2);
    }
    @Test
    public void testExpressionComplexeDoubleFull3() throws MathsExceptions {
        resultat = new Expression("(5.5+(2.1*1.1)+(3.1*1.1))/((5.1*2.1)-(2.5+3.5))");
        Assert.assertEquals(resultat.getValue(),2.3821656051,2);
    }
    @Test
    public void testExpressionComplexeDoubleFull4() throws MathsExceptions {
        resultat = new Expression("(((((6.5+3.5)+(4.5+5.5-2.5))/1.5)))");
        Assert.assertEquals(resultat.getValue(),11.6666666667,2);
    }
    @Test
    public void testExpressionComplexeDoubleFull5() throws MathsExceptions {
        resultat = new Expression("((6.5+3.5)+(((4.5+5.5-2.5))))/(1.5)");
        Assert.assertEquals(resultat.getValue(),11.6666666667,2);
    }
    @Test
    public void testExpressionComplexeDoubleFull6() throws MathsExceptions {
        resultat = new Expression("(((((6.5+3.5))))+(4.5+5.5-2.5))/1.5");
        Assert.assertEquals(resultat.getValue(),11.6666666667,2);
    }

    @Test
    public void testExpressionAdditionDoubleNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("a+2.3");
    }
    @Test
    public void testExpressionMultiplicationDoubleNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("ba*2.1");
    }
    @Test
    public void testExpressionSoustractionDoubleNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("e-1.4");
    }
    @Test
    public void testExpressionDivisionDoubleNotaNumber() throws MathsExceptions{
        e.expect(MathsExceptions.class);
        e.expectMessage("l'expression contient des caractères non-autorisés");
        resultat = new Expression("!/6.8");
    }

    @Test
    public void testExpressionComplexDoubleWithSeveralBrackets() throws MathsExceptions {
        resultat = new Expression("(((((2.3 + 3.4)) * ((4.5 + 5.7)) + 2.1)))");
        Assert.assertEquals(resultat.getValue(), 60.23999999999999, 0);
    }
    @Test
    public void testExpressionComplexDoubleWithSeveralBrackets2() throws MathsExceptions {
        resultat = new Expression("(((((2.1 + 3.2)) * ((4.3 + 5.4)) + 2.5))) + 3.6 * 2.7");
        Assert.assertEquals(resultat.getValue(), 63.63, 0);
    }
    @Test
    public void testExpressionComplexDoubleWithSeveralBrackets3() throws MathsExceptions {
        resultat = new Expression("((((((2.1 + 3.2)) * ((4.3 + 5.4)) + 2.5))) + 3.6 )* 2.7");
        Assert.assertEquals(resultat.getValue(), 155.27700000000002, 0);
    }
}
