package com.iut.as2021.dao;

import java.util.ArrayList;

public interface IDAO<T>{
    T readById(int i) throws Exception;
    T getLast() throws Exception;
    ArrayList<T> getAll() throws Exception;
    boolean update(T object) throws Exception;
    boolean create(T object) throws Exception;
    boolean delete(T object) throws Exception;
}
