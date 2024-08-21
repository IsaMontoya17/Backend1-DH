package com.digitalhouse.odontologiaAPIRest.services;

import com.digitalhouse.odontologiaAPIRest.domain.Turno;

import java.util.List;

public interface ITurnoService {
    Turno guardar(Turno turno);
    Turno buscarPorId(Integer id);
    List<Turno> listar();
}
