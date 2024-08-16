package com.digitalhouse.odontologia.services;

import com.digitalhouse.odontologia.domain.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo guardar(Odontologo odontologo);
    Odontologo buscarPorId(Integer id);
    void eliminar(Integer id);
    void actualizar(Odontologo odontologo);

    List<Odontologo> listar();

}
