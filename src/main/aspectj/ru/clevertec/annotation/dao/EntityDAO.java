package ru.clevertec.annotation.dao;


import java.util.List;

public interface EntityDAO<T> {
    T save(T t);

    T update(T t);

    void delete(Long id);

    T getById(Long id);

    List<T> getAll();
}
