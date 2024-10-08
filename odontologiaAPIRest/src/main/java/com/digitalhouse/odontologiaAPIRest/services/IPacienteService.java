package com.digitalhouse.odontologiaAPIRest.services;

import com.digitalhouse.odontologiaAPIRest.domain.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente guardar(Paciente paciente);

    Paciente buscarPorId(Integer id);

    Boolean eliminar(Integer id);

    Paciente actualizar(Paciente paciente);

    List<Paciente> listar();

}//CIERRE DE LA CLASE
