package org.codegym.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T entity);
    boolean isExistsById(Long id);
    void deleteById(Long id);
}
