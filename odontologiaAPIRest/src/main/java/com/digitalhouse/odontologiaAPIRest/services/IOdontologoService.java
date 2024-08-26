package com.digitalhouse.odontologiaAPIRest.services;

import com.digitalhouse.odontologiaAPIRest.domain.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo guardar(Odontologo odontologo);

    Odontologo buscarPorId(Integer id);

    Boolean eliminar(Integer id);

    Odontologo actualizar(Odontologo odontologo);

    List<Odontologo> listar();

}//CIERRE DE LA CLASE
