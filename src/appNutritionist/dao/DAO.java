package appNutritionist.dao;

import java.util.List;

public interface DAO<T, ID> {

    void insert(T entidad);
    T findById(ID id);
    List<T> findAll();
    void update(T entidad);
    void delete(ID id);
}