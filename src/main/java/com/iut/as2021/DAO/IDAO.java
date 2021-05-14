package com.iut.as2021.DAO;

import com.iut.as2021.metiers.Expression;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDAO<T>{
    T readById(int i) throws Exception;
    T getLast() throws Exception;
    ArrayList<T> getAll() throws Exception;
    boolean update(T object) throws Exception;
    boolean create(T object) throws Exception;
    boolean delete(T object) throws Exception;
}
