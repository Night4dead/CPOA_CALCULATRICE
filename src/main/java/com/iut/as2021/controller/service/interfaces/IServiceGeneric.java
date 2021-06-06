package com.iut.as2021.controller.service.interfaces;

import com.iut.as2021.controller.facade.DtoFacadeManager;
import com.iut.as2021.dao.factory.DaoFactoryGeneric;
import com.iut.as2021.exceptions.MathsExceptions;

public interface IServiceGeneric {
    void setDao(DaoFactoryGeneric daoFactoryGeneric) throws MathsExceptions;

    void setDto(DtoFacadeManager dtoManager) throws MathsExceptions;
}
