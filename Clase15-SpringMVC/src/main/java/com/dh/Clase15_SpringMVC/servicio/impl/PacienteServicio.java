package com.dh.Clase15_SpringMVC.servicio.impl;

import com.dh.Clase15_SpringMVC.dao.IDAO;
import com.dh.Clase15_SpringMVC.dao.impl.ImplementacionPaciente;
import com.dh.Clase15_SpringMVC.modelo.Paciente;

import java.util.List;

public class PacienteServicio {
    private IDAO<Paciente> interfazDAO;

    public PacienteServicio() {
        this.interfazDAO = new ImplementacionPaciente();
    }

    public Paciente guardar(Paciente paciente) {
        return interfazDAO.guardar(paciente);
    }

    public void eliminar(Integer id){
        interfazDAO.eliminarPorId(id);
    }

    public List<Paciente> listarTodos() {
        return interfazDAO.listarTodos();
    }

    public Paciente buscarPorId(Integer id) {
        return interfazDAO.consultarPorId(id);
    }

    public Paciente actualizar(Paciente paciente) {
        return interfazDAO.actualizar(paciente);
    }

}
