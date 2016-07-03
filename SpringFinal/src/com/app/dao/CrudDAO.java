package com.app.dao;

public interface CrudDAO<T> {

    int insertNew(T t);
    int update(T t);
    boolean delete(T t);
    T getById(Integer id);
}
