package com.codesquad.team10.airbnb.repository;

import java.util.List;
import java.util.Optional;

public interface JdbcRepository<T, ID> {
    Optional<T> findById(ID id);

    List<T> findAll();

    void add(T t);

    void update(T t);

    void delete(ID id);
}
