package com.iut.as2021.controller.service;

import com.iut.as2021.controller.facade.DtoFacadeManager;
import com.iut.as2021.controller.service.implementation.ServiceExpressionImp;
import com.iut.as2021.controller.service.interfaces.IServiceExpression;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.modele.dto.DtoExpression;
import org.junit.Before;

public class ServiceExpressionTest {

    private IServiceExpression service;

    @Before
    public void setUp() throws MathsExceptions {
        service = new ServiceExpressionImp();
        DtoFacadeManager manager = new DtoFacadeManager();
        manager.setDtoExpression(new DtoExpression());
        service.setDto(manager);
    }


}
