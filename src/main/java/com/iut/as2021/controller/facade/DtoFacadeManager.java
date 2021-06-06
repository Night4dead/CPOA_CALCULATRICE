package com.iut.as2021.controller.facade;

import com.iut.as2021.modele.dto.DtoExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoFacadeManager {
    @Autowired
    private DtoExpression dtoExpression;

    public DtoExpression getDtoExpression(){ return dtoExpression;}

    public void setDtoExpression(DtoExpression dtoExpression) { this.dtoExpression = dtoExpression;}
}
