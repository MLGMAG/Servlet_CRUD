package net.mlgmag.Servlets.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    void save(T t);

    void update(T t);

    void delete(T t);

    List<T> getAll();

    T getByID(ID id);
}
