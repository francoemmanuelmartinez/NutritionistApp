package Dao;

import java.util.List;

public interface DAO<T, ID> {

    void save(T entidad);
    T findById(ID id);
    List<T> listAll();
    void update(T entidad);
    void delete(ID id);
}