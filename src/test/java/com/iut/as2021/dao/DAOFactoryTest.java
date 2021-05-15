package com.iut.as2021.dao;

import com.iut.as2021.DAO.*;
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

    /*
    @Mock
    private DAOFactory mockDAOFactory;
     */


    @Mock
    private Expression mockExpression;
/*
@Mock
    private MySqlExpressionDAO mockMySqlDAO;
 */


    public DAOFactoryTest(){

    }

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass(){}

    @Before
    public void setUp() throws Exception {
        // to uncomment : mockMySqlDAO = mock(MySqlExpressionDAO.class);


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

    public void testReadById() throws Exception{
        /*
        *
        * test fait en cours recopié --> bug : \
        *  /data/Codding/school_projects/CPOA_CALCULATRICE/src/test/java/com/iut/as2021/dao/DAOFactoryTest.java:36:13
        *  java: cannot access com.iut.as2021.dao.MySqlExpressionDAO
        * bad class file: /data/Codding/school_projects/CPOA_CALCULATRICE/target/classes/com/iut/as2021/dao/MySqlExpressionDAO.class
        *    class file contains wrong class: com.iut.as2021.DAO.MySqlExpressionDAO
        *
        mockExpression = new Expression("1+5");
        when(mockMySqlDAO.readById(anyInt())).thenReturn(mockExpression);
        Assert.assertEquals(mockExpression.getValue(),6,0);
         */

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
