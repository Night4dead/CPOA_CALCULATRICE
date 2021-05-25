package com.iut.as2021.dao.connexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnexion {
    private static MySqlConnexion instance;

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
        Properties p = new Properties();

        File file = new File("config/mysql.properties");
        try {
            FileInputStream source = new FileInputStream(file);
            p.loadFromXML(source);
            this.url="jdbc:mysql://"+p.getProperty("url")+":"+p.getProperty("port")+"/"+p.getProperty("bdd");
            this.login = p.getProperty("login");
            this.pwd = p.getProperty("pass");
        } catch (IOException ioe){
            System.out.println("probleme de lecture des properties MySQL : "+ioe.getMessage());
        }
    }
}
