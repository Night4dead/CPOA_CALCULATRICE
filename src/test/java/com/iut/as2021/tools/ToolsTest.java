package com.iut.as2021.tools;

import com.iut.as2021.exceptions.MathsExceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToolsTest {

    private Tools tools;

    @Before
    public void setUp(){
        tools = new Tools();
    }

    @Test
    public void testCountNbParenthesisCorrect() throws MathsExceptions {
        Assert.assertEquals(tools.countNbParenthesis("(1+2)(1+3)(1+4)"),3,2);
    }

    @Test
    public void testCountNbParenthesisCorrect2() throws MathsExceptions {
        Assert.assertEquals(tools.countNbParenthesis("(1+2)((3*4)+3)"),3,2);
    }

    @Test
    public void testCountNbParenthesisCorrect3() throws MathsExceptions {
        Assert.assertEquals(tools.countNbParenthesis("(1+2)(2+3)"),0,2);
    }

    @Test(expected = MathsExceptions.class)
    public void testCountNbParenthesisWrong() throws MathsExceptions {
        Assert.assertEquals(tools.countNbParenthesis("(1+2(2+3)"),0,2);
    }

    @Test(expected = MathsExceptions.class)
    public void testCountNbParenthesisWrong2() throws MathsExceptions {
        Assert.assertEquals(tools.countNbParenthesis("((1+2)(2+3)))"),0,2);
    }

    @Test(expected = MathsExceptions.class)
    public void testCountNbParenthesisWrong3() throws MathsExceptions {
        Assert.assertEquals(tools.countNbParenthesis("()"),0,2);
    }

    @Test(expected = MathsExceptions.class)
    public void testCountNbParenthesisWrong4() throws MathsExceptions {
        Assert.assertEquals(tools.countNbParenthesis("(asdas)"),0,2);
    }

    @Test
    public void testIsNotADigit(){
        Assert.assertEquals(tools.isNotADigit(0,"a"),true);
    }
    @Test
    public void testIsNotADigit2(){
        Assert.assertEquals(tools.isNotADigit(0,"%"),true);
    }
    @Test
    public void testIsNotADigit3(){
        Assert.assertEquals(tools.isNotADigit(0,"0"),false);
    }

    @Test
    public void testIsClosingParentheses(){
        Assert.assertEquals(tools.isClosingParentheses(0,")"),true);
    }
    @Test
    public void testIsClosingParentheses2(){
        Assert.assertEquals(tools.isClosingParentheses(0,"("),false);
    }
    @Test
    public void testIsClosingParentheses3(){
        Assert.assertEquals(tools.isClosingParentheses(0,"1"),false);
    }

    @Test
    public void testIsOpenParentheses(){
        Assert.assertEquals(tools.isOpenParentheses(0,"("),true);
    }
    @Test
    public void testIsOpenParentheses2(){
        Assert.assertEquals(tools.isOpenParentheses(0,"1"),false);
    }
    @Test
    public void testIsOpenParentheses3(){
        Assert.assertEquals(tools.isOpenParentheses(0,")"),false);
    }

    @Test
    public void testIsOperator(){
        Assert.assertEquals(tools.isOperator('+'),true);
    }
    @Test
    public void testIsOperator2(){
        Assert.assertEquals(tools.isOperator('-'),true);
    }
    @Test
    public void testIsOperator3(){
        Assert.assertEquals(tools.isOperator('/'),true);
    }
    @Test
    public void testIsOperator4(){
        Assert.assertEquals(tools.isOperator('*'),true);
    }
    @Test
    public void testIsOperator5(){
        Assert.assertEquals(tools.isOperator('a'),false);
    }
    @Test
    public void testIsOperator6(){
        Assert.assertEquals(tools.isOperator('2'),false);
    }

    @Test
    public void testTrimPanthesis() throws MathsExceptions {
        Assert.assertEquals(tools.trimParenthesis("(1+2)"),"1+2");
    }
    @Test
    public void testTrimPanthesis2() throws MathsExceptions {
        Assert.assertEquals(tools.trimParenthesis("(1+2+(1*3))"),"1+2+(1*3)");
    }
    @Test
    public void testTrimPanthesis3() throws MathsExceptions {
        Assert.assertEquals(tools.trimParenthesis("1+2+(1*3)"),"1+2+(1*3)");
    }
    @Test
    public void testTrimPanthesis4() throws MathsExceptions {
        Assert.assertEquals(tools.trimParenthesis("(1+2)(3*7)(9/3)"),"(1+2)(3*7)(9/3)");
    }
    @Test(expected = MathsExceptions.class)
    public void testTrimPanthesisError() throws MathsExceptions {
        Assert.assertEquals(tools.trimParenthesis("(1+2"),"1+2");
    }
    @Test(expected = MathsExceptions.class)
    public void testTrimPanthesisError2() throws MathsExceptions {
        Assert.assertEquals(tools.trimParenthesis("(1+2ad)"),"1+2");
    }
}
