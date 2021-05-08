package com.iut.as2021.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T>{
    T readById(int i) throws Exception;

    List<T> getAll();
    boolean update(T object) throws Exception;
    boolean create(T object) throws Exception;
    boolean delete(T object) throws Exception;
}
