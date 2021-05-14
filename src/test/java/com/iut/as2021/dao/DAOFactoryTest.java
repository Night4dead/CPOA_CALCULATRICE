package com.iut.as2021.dao;

import com.iut.as2021.DAO.DAOFactory;
import com.iut.as2021.DAO.ETypeDAO;
import com.iut.as2021.DAO.IDAOExpression;
import com.iut.as2021.DAO.MySqlConnexion;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metiers.Expression;
import com.mysql.cj.log.NullLogger;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class DAOFactoryTest {

    @Mock
    private DAOFactory mockDAOFactory;

    @Mock
    private Expression mockExpression;

    public DAOFactoryTest(){

    }

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass(){}

    @Before
    public void setUp() throws Exception {
        /*mockDAOFactory = mock(DAOFactory.class);
        mockExpression = mock(Expression.class);

        //when(mockDAOFactory.getDAOFactory(ETypeDAO.MYSQL)).thenReturn(mockDAOFactory);
        when(mockDAOFactory.getDAOExpression().create(mockExpression)).thenReturn(Boolean.TRUE);
        when(mockDAOFactory.getDAOExpression().update(mockExpression)).thenReturn(Boolean.TRUE);
        when(mockDAOFactory.getDAOExpression().delete(mockExpression)).thenReturn(Boolean.TRUE);
        when(mockDAOFactory.getDAOExpression().readById(1)).thenReturn(mockExpression);
        when(mockDAOFactory.getDAOExpression().getLast()).thenReturn(mockExpression);
        when(mockDAOFactory.getDAOExpression().getAll()).thenReturn(null);*/
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testCreateWithNoExceptions() throws Exception {
        //Assert.assertEquals(mockDAOFactory.getDAOExpression().create(mockExpression),Boolean.TRUE);
    }

    @Test(expected = SQLException.class)
    public void testCreateWithPreparedStatementException() throws Exception{
        /*when(mockDAOFactory.getDAOExpression().create(mockExpression)).thenThrow(new SQLException());
        try {
            mockDAOFactory.getDAOExpression().create(mockExpression);
        } catch (SQLException se){
            throw se;
        }*/
    }
}
