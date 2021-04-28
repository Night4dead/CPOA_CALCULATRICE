package com.iut.as2021.DAO;

import java.util.List;

public interface IDAO<T>{
    T readById(int i);

    List<T> getAll();
    boolean update(T object);
    boolean create(T object);
    boolean delete(T object);
}
