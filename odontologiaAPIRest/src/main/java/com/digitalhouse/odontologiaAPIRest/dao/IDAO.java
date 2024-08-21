package com.digitalhouse.odontologiaAPIRest.dao;

import java.util.List;

public interface IDAO<T> {

    T guardar (T t);

    List<T> listar();

    T consultarPorId(Integer id);

    Boolean eliminarPorId(Integer id);

    T actualizar(T t);

    /*T actualizar(T t, String string1, String string2);*/

}//CIERRE DE LA CLASE
