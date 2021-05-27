package com.iut.as2021.dao;

import com.iut.as2021.dao.expression.IDAOExpression;
import static com.iut.as2021.dao.DAOFactory.getDAOFactory;

import com.iut.as2021.dao.expression.MySqlExpressionDAO;
import com.iut.as2021.metiers.Expression;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyInt;

public class MySqlDAOExpressionTest {
    private IDAOExpression dao;

    private MySqlExpressionDAO daoMock;

    @Before
    public void setUp(){
        dao = getDAOFactory(ETypeDAO.MYSQL).getDAOExpression();
        daoMock = Mockito.mock(MySqlExpressionDAO.class);
    }

    @Test
    public void testReadById() throws Exception {
        Expression resultat = dao.readById(1);
        Assert.assertEquals(resultat.getValue(),3,0);
    }

    @Test
    public void testReadByIdMock() throws Exception {
        Expression resultat = new Expression("2+3");
        Mockito.when(daoMock.readById(anyInt())).thenReturn(resultat);
        Assert.assertEquals(resultat.getValue(),5,0);
    }
}
