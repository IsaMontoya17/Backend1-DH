package com.digitalhouse.odontologiaAPIRest.dao;

import java.util.List;

public interface IDAO<T> {

    T guardar (T t);

    List<T> listar();

    T consultarPorId(Integer id);

    void eliminarPorId(Integer id);

    T actualizar(T t);
}
