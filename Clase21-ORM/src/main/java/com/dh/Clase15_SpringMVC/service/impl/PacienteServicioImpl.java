package com.dh.Clase15_SpringMVC.service.impl;

import com.dh.Clase15_SpringMVC.dao.IDAO;
import com.dh.Clase15_SpringMVC.entity.Paciente;
import com.dh.Clase15_SpringMVC.service.IPacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicioImpl implements IPacienteServicio {

    @Autowired
    private IDAO<Paciente> interfazDAO;



    @Override
    public Paciente guardar(Paciente paciente) {
        return interfazDAO.guardar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return interfazDAO.consultarPorId(id);
    }

    @Override
    public List<Paciente> listarTodos() {
        return interfazDAO.listarTodos();
    }

    @Override
    public void actualizar(Paciente paciente) {

    }

    @Override
    public void eliminar(Integer id) {

    }
}
