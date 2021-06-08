package com.iut.as2021.controller.service;

import com.iut.as2021.controller.service.implementation.ServiceExpressionImp;
import com.iut.as2021.controller.service.interfaces.IServiceExpression;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceExpressionTest {

    private IServiceExpression service;

    @Before
    public void setUp() {
        service = new ServiceExpressionImp();
    }

    @Test
    public void testServiceExpressionExists(){
        Assert.assertNotNull(service);
    }
}
