package com.iut.as2021.dao.connexion;

import com.iut.as2021.tools.LoaderTools;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.apache.log4j.Logger.getLogger;

public class MySqlConnexion {
    private static MySqlConnexion instance;

    private static final Logger logger = getLogger(MySqlConnexion.class);

    public static MySqlConnexion getInstance(){
        if(instance == null){
            instance = new MySqlConnexion();
        }
        return instance;
    }

    private String url,login,pwd;
    private Connection sqlConnexion;

    private MySqlConnexion(){
        this.readProperties();
    }

    public Connection getSqlConnexion() throws SQLException {

        if(this.sqlConnexion==null || this.sqlConnexion.isClosed()){
            this.sqlConnexion = DriverManager.getConnection(this.url,this.login,this.pwd);
        }
        return this.sqlConnexion;
    }

    private void readProperties(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties p = LoaderTools.loader("/mysql.properties");
            this.url="jdbc:mysql://"+p.getProperty("url")+":"+p.getProperty("port")+"/"+p.getProperty("bdd");
            this.login = p.getProperty("login");
            this.pwd = p.getProperty("pass");
        } catch (Exception ioe){
            logger.error("probleme de lecture des properties MySQL : "+ioe.getMessage());
        }
    }
}
