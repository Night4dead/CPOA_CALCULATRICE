package com.iut.as2021.dao;

import com.iut.as2021.DAO.DAOFactory;
import com.iut.as2021.DAO.ETypeDAO;
import com.iut.as2021.DAO.IDAOExpression;
import com.iut.as2021.DAO.MySqlConnexion;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metiers.Expression;
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

    @Spy
    private DAOFactory mockDAOFactory;

    @Mock
    private MySqlConnexion mockMySQLConnexion;

    @Mock
    private Connection mockConn;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;
    private Expression expression;

    public DAOFactoryTest(){

    }

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass(){}

    @Before
    public void setUp() throws Exception {
        /*
        DAOFactory daof = DAOFactory.getDAOFactory(ETypeDAO.MYSQL);
        mockDAOFactory = spy(daof);
        when(daof.getDAOExpression().create(anyVararg())).thenReturn(anyBoolean());
        when(daof.getDAOExpression().update(anyVararg())).thenReturn(anyBoolean());
        when(daof.getDAOExpression().getLast()).thenReturn(expression);*/

    }

    @After
    public void tearDown(){

    }

    @Test
    public void testCreateWithNoExceptions() throws Exception {
        /*expression = new Expression("1+1");
        Assert.assertEquals(mockDAOFactory.getDAOExpression().create(expression),true);*/

        /*
        verify(mockConn,times(1)).prepareStatement(anyString(),anyInt());
        verify(mockPreparedStatement,times(1)).setString(anyInt(), anyString());
        verify(mockPreparedStatement,times(1)).execute();
        verify(mockConn,times(1)).commit();
        verify(mockResultSet,times(2)).next();
        verify(mockResultSet,times(1)).getInt(1);*/
    }

    @Test(expected = SQLException.class)
    public void testCreateWithPreparedStatementException() throws Exception{
        //when(mockConn.prepareStatement(anyString(),anyInt())).thenThrow(new SQLException());
        /*
        when(mockDAOFactory.getDAOExpression().create(expression)).thenThrow(new SQLException());
        try {
            DAOFactory instance = DAOFactory.getDAOFactory(ETypeDAO.MYSQL);
            expression = new Expression("1+1");
            instance.getDAOExpression().create(expression);
        } catch (SQLException se){
            verify(mockConn,times(1)).prepareStatement(anyString(),anyInt());
            verify(mockPreparedStatement,times(0)).setString(anyInt(), anyString());
            verify(mockPreparedStatement,times(0)).execute();
            verify(mockConn,times(0)).commit();
            verify(mockResultSet,times(0)).next();
            verify(mockResultSet,times(0)).getInt(1);
            throw se;
        }*/
    }
}
