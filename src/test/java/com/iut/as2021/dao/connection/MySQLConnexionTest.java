package com.iut.as2021.dao.connection;


import com.iut.as2021.dao.connexion.MySqlConnexion;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnexionTest {
    @Test
    public void testConnexionIsValid() throws SQLException {
        Assert.assertNotNull(MySqlConnexion.getInstance().getSqlConnexion());
    }

    @Test
    public void testConnexionIsSingleton() throws SQLException {
        Connection co1 = MySqlConnexion.getInstance().getSqlConnexion();
        Connection co2 = MySqlConnexion.getInstance().getSqlConnexion();
        Assert.assertEquals(co1,co2);
    }
}
