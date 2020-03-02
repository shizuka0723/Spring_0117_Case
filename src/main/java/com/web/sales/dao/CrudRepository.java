package com.web.sales.dao;

import java.util.Optional;

public interface CrudRepository<T, ID> {

    void save(T entity);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    void deleteById(ID id);

    void update(T entity);
}