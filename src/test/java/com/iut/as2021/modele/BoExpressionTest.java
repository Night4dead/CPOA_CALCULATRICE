package com.iut.as2021.modele;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoExpressionTest {

    private BoExpression expression;

    @Before
    public void testSetup() {
        expression = new BoExpression();
    }

    @Test
    public void testExpressionExists(){
        Assert.assertNotNull(expression);
    }
}
