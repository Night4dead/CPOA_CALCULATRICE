package com.iut.as2021.factory;

import com.iut.as2021.dao.factory.DaoFactory;
import com.iut.as2021.dao.factory.DaoFactoryGeneric;
import com.iut.as2021.enums.EPersistance;
import com.iut.as2021.exceptions.MathsExceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DaoFactoryTest {
    private DaoFactoryGeneric factoryGeneric;

    @Before
    public void setUp() throws MathsExceptions {
        factoryGeneric = DaoFactory.getDaoInstance(EPersistance.HIBERNATE);
    }

    @Test
    public void testFactoryExists(){ Assert.assertNotNull(factoryGeneric);}

}
