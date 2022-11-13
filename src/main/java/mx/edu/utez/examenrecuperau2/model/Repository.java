package mx.edu.utez.examenrecuperau2.model;

import mx.edu.utez.examenrecuperau2.utils.Response;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findOne(long id);
    Response<T> save(T object);
    Response<T> update(T object);
    String delete(long id);
}
