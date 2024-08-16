package com.digitalhouse.odontologia.services;

import com.digitalhouse.odontologia.domain.Odontologo;
import com.digitalhouse.odontologia.domain.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente guardar(Paciente paciente);
    Paciente buscarPorId(Integer id);
    void eliminar(Integer id);
    Paciente actualizar(Paciente paciente);

    List<Paciente> listar();
}
